using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Data.Entity;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Repositorio
{
    public class PacoteRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Pacote> Obter()
        {
            return contexto.Pacotes
                .Include(x => x.Acessorios)
                .ToList();
        }

        public Pacote ObterPacotePorId(int id)
        {
            return contexto.Pacotes.Where(x => x.IdPacote == id).FirstOrDefault();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
