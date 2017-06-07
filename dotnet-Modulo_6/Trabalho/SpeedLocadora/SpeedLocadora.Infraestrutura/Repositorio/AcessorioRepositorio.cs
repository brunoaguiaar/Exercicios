using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Repositorio
{
    public class AcessorioRepositorio : IDisposable
    {
        Contexto contexto = new Contexto();

        public List<Acessorio> Listar()
        {
            return contexto.Acessorios.ToList();
        }

        public Acessorio Obter(int id)
        {
            return contexto.Acessorios.Where(x => x.IdAcessorio == id).FirstOrDefault();
        }

        public Acessorio ObterPorCpf(string nome)
        {
            return contexto.Acessorios.Where(x => x.NomeAcessorio == nome).FirstOrDefault();
        }

        public Acessorio Adicionar(Acessorio acessorio)
        {
            contexto.Acessorios.Add(acessorio);
            contexto.SaveChanges();
            return acessorio;
        }

        public void Deletar(int Id)
        {
            var acessorio = contexto.Acessorios.FirstOrDefault(x => x.IdAcessorio == Id);
            contexto.Acessorios.Remove(acessorio);
            contexto.SaveChanges();
        }

        public Acessorio Alterar(int id, Acessorio acessorio)
        {
            contexto.Entry(acessorio).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return Obter(id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
