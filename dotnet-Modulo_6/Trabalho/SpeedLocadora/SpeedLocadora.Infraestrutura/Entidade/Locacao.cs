using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Entidade
{
    class Locacao
    {
        public int IdLocacao { get; set; }
        public DateTime DataLocacao { get; set; }
        public DateTime DataEntrega { get; set; }
        public DateTime PrevisaoEntrega { get; set; }
        public double PrecoFinal { get; set; }
        public Pacote IdPacote { get; set; }
        public Acessorio IdAcessorio { get; set; }
        public Jogo IdJogo { get; set; }
        public Console IdConsole { get; set; }
    }
}
