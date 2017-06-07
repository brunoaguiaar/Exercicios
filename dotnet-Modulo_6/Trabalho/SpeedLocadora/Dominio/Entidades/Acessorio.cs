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
        public virtual List<PacoteAcessorio> Pacotes { get; set; }
        public virtual List<Locacao> Locacao { get; set; }

        public Acessorio()
        {

        }

        public override bool Validar()
        {
            throw new NotImplementedException();
        }
    }
}
