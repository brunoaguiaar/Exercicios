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

        public VideoGame Alugar(VideoGame videoGame)
        {
            videoGame.Alugar();

            contexto.Entry(videoGame).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return videoGame;
        }

        public VideoGame Devolver(VideoGame videoGame)
        {
            videoGame.Devolver();

            contexto.Entry(videoGame).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return videoGame;
        }

        public object ListarDisponiveis()
        {
            return contexto.VideoGames.Where(x => x.Quantidade > 0).ToList();
        }

    }
}
