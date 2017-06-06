using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Dominio
{
    public class Locacao
    {
        public int IdLocacao { get; set; }
        public DateTime DataLocacao { get; set; }
        public DateTime DataEntrega { get; set; }
        public DateTime PrevisaoEntrega { get; set; }
        public double PrecoFinal { get; set; }
        public Pacote Pacote { get; set; }
        public Acessorio Acessorio { get; set; }
        public VideoGame VideoGame { get; set; }
    }
}
