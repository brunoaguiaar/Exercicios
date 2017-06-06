using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Dominio
{
    public class Acessorio
    {
        public int IdAcessorio { get; set; }
        public string NomeAcessorio { get; set; }
        public VideoGame VideoGame { get; set; }
    }
}
