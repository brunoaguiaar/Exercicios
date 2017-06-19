using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Repositorio
{
    public class VideoGameRepositorio
    {
        private Contexto contexto = new Contexto();

        public IEnumerable<VideoGame> Listar()
        {
            return contexto.VideoGames.ToList();
        }

        public VideoGame Obter(int id)
        {
            return contexto.VideoGames.Where(u => u.IdVideoGame == id).FirstOrDefault();
        }

        public void Alugar(int idVideoGame)
        {
            var videoGame = contexto.VideoGames.Where(x => x.IdVideoGame == idVideoGame).FirstOrDefault();
            --videoGame.Quantidade;
            contexto.SaveChanges();
            return;
        }

        public void Devolver(int idVideoGame)
        {

            var videoGame = contexto.VideoGames.Where(x => x.IdVideoGame == idVideoGame).FirstOrDefault();
            ++videoGame.Quantidade;
            contexto.SaveChanges();
            return;
        }

        public object ListarDisponiveis()
        {
            return contexto.VideoGames.Where(x => x.Quantidade > 0).ToList();
        }

    }
}
