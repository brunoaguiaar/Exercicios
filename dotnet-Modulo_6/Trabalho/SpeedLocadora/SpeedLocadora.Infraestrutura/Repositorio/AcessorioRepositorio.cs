using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Repositorio
{
    public class AcessorioRepositorio
    {
        private Contexto contexto = new Contexto();

        public IEnumerable<Acessorio> Listar()
        {
            return contexto.Acessorios.ToList();
        }

        public void Aluga(List<Acessorio> listaAcessorios)
        {
            foreach (var acessorio in listaAcessorios)
            {
                var acessorios = contexto.Acessorios.Where(x => x.IdAcessorio == acessorio.IdAcessorio).FirstOrDefault();
                --acessorios.Quantidade;
            }
            contexto.SaveChanges();
            return;
        }

        public void Devolve(List<Acessorio> listaAcessorios)
        {
            foreach (var acessorio in listaAcessorios)
            {
                var acessorios = contexto.Acessorios.Where(x => x.IdAcessorio == acessorio.IdAcessorio).FirstOrDefault();
                ++acessorios.Quantidade;
            }
            contexto.SaveChanges();
            return;
        }

        public Acessorio ObterPorId(int id)
        {
            return contexto.Acessorios.Where(x => x.IdAcessorio == id).FirstOrDefault();
        }

        public List<Acessorio> ObterAcessoriosPorId(List<int> listaAcessorios)
        {
            List<Acessorio> retorno = null;
            foreach (var id in listaAcessorios)
            {
                var acessorio = ObterPorId(id);
                retorno.Add(acessorio);
            }
            return retorno;
        }


        public List<Acessorio> ListarDisponiveis()
        {
            return contexto.Acessorios.Where(x => x.Quantidade > 0).ToList();
        }
    }
}
