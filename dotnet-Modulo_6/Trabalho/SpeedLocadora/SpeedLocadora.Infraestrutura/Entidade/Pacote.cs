using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Entidade
{
    class Pacote
    {
        public int IdPacote { get; set; }
        public Jogo IdJogo { get; set; }
        public string Tipo { get; set; }
        public double Valor { get; set; }
        public Console IdConsole { get; set; }
        public Acessorio IdAcessorio { get; set; }
    }
}
