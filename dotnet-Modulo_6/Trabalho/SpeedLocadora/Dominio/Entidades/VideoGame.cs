using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class VideoGame : EntidadeBasica
    {
        public int IdVideoGame { get; set; }
        public string NomeVideoGame { get; set; }
        public int Quantidade { get; set; }
        public double Valor { get; set; }

        public VideoGame()
        {

        }

        public void Alugar()
        {
            Quantidade--;
        }

        public void Devolver()
        {
            Quantidade++;
        }

        public override bool Validar()
        {
            Mensagens.Clear();

            if (Quantidade <= 0)
                Mensagens.Add("Não possui produtos suficientes para alugar");

            return Quantidade > 0;
        }
    }
}