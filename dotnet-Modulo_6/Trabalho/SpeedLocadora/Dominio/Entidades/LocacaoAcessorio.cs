using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades 
{
    public class LocacaoAcessorio : EntidadeBasica
    {
        public int IdLocacaoAcessorio { get; set; }
        public Locacao Locacao { get; set; }
        public Acessorio Acessorio { get; set; }
        public int Quantidade { get; set; }

        public LocacaoAcessorio()
        { }

        public override bool Validar()
        {
            throw new NotImplementedException();
        }
    }
}
