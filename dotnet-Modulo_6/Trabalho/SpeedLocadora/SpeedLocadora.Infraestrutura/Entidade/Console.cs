using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Entidade
{
    public class Console
    {
        public int IdConsole { get; set; }
        public string NomeConsole { get; set; }
        public int Quantidade { get; set; }
        public double Valor { get; set; }
        public Acessorio Acessorio { get; set; }
        public Jogo Jogo { get; set; }
    }
}
