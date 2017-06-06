using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Dominio
{
    public class PacoteAcessorio
    {
        public Pacote Pacote { get; set; }
        public Acessorio Acessorio { get; set; }
        public int Quantidade { get; set; }
    }
}
