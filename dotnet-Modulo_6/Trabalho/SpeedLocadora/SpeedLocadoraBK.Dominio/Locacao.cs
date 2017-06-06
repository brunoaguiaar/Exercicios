using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Dominio
{
    public class Locacao
    {
        public int IdLocacao { get; private set; }
        public DateTime DataLocacao { get; private set; }
        public DateTime DataEntrega { get; private set; }
        public DateTime PrevisaoEntrega { get; private set; }
        public double PrecoFinal { get; private set; }
        public Pacote Pacote { get; private set; }
        public Acessorio Acessorio { get; private set; }
        public VideoGame VideoGame { get; private set; }
        public Usuario Usuario { get; private set; }
        public Cliente Cliente { get; private set; }
    }
}
