using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Locacao : EntidadeBasica
    {
        public int IdLocacao { get; private set; }
        public DateTime DataLocacao { get; private set; }
        public DateTime DataEntrega { get; private set; }
        public DateTime PrevisaoEntrega { get; private set; }
        public double PrecoFinal { get; private set; }
        public double PrecoPrevisto { get; private set; }
        public PacoteAcessorio PacoteAcessorios { get; private set; }
        public VideoGame VideoGame { get; private set; }
        public Usuario Usuario { get; private set; }
        public Cliente Cliente { get; private set; }

        public Locacao()
        {

        }

        public override bool Validar()
        {
            throw new NotImplementedException();
        }
    }
}
