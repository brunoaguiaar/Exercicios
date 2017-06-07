using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Repositorio
{
    public class LocacaoRepositorio : IDisposable
    {
        Contexto contexto = new Contexto();

        public List<Locacao> Listar()
        {
            return contexto.Locacoes.ToList();
        }

        public Locacao Obter(int id)
        {
            return contexto.Locacoes.Where(x => x.IdLocacao == id).FirstOrDefault();
        }

        public Locacao Adicionar(Locacao locacao)
        {
            contexto.Locacoes.Add(locacao);
            contexto.SaveChanges();
            return locacao;
        }

        public void Deletar(int Id)
        {
            var locacao = contexto.Locacoes.FirstOrDefault(x => x.IdLocacao == Id);
            contexto.Locacoes.Remove(locacao);
            contexto.SaveChanges();
        }

        public Locacao Alterar(int id, Locacao locacao)
        {
            contexto.Entry(locacao).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return Obter(id);
        }

        public void Dispose()
        {
            throw new NotImplementedException();
        }
    }
}
