using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class VideoGame
    {
        public int IdVideoGame { get; set; }
        public string NomeVideoGame { get; set; }
        public int Quantidade { get; set; }
        public double Valor { get; set; }

        public VideoGame()
        {

        }
    }
}