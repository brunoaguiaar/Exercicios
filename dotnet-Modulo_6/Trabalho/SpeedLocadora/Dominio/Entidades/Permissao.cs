using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Permissao : EntidadeBasica
    {
        public string Nome { get; private set; }
        public int Id { get; set; }

        public Permissao()
        { }

        public Permissao(string nome)
        {
            Nome = nome;
        }

        public override bool Validar()
        {
            throw new NotImplementedException();
        }
    }
}