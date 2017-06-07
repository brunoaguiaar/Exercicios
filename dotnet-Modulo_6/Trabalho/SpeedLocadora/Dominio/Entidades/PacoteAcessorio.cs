using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class PacoteAcessorio : EntidadeBasica
    {
        public int Id { get; set; }
        public Pacote Pacote { get; set; }
        public Acessorio Acessorio { get; set; }
        public int Quantidade { get; set; }

        public PacoteAcessorio()
        { }

        public override bool Validar()
        {
            throw new NotImplementedException();
        }
    }
}
