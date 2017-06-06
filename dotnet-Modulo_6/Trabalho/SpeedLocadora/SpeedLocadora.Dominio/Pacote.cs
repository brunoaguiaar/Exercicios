using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Dominio
{
    public class Pacote
    {
        public int IdPacote { get; set; }
        public string Tipo { get; set; }
        public double Valor { get; set; }
        public VideoGame VideoGame { get; set; }
        public Acessorio Acessorio { get; set; }
    }
}
