using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Acessorio : EntidadeBasica
    {
        public int IdAcessorio { get; set; }
        public string NomeAcessorio { get; set; }
        public int Quantidade { get; set; }
        public double Valor { get; set; }

        public Acessorio()
        { }

        public override bool Validar()
        {
            throw new NotImplementedException();
        }
    }
}
