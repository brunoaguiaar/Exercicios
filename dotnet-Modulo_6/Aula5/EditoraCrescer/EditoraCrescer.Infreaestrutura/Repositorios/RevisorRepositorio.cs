using EditoraCrescer.Infraestrutura.Entidade;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio : IRepositorio<Revisor>, IDisposable
    {
        private Contexto contexto = new Contexto();
        private RevisorRepositorio revisorRepositorio = new RevisorRepositorio();

        public List<Revisor> Listar()
        {
            return contexto.Revisores.ToList();
        }

        public Revisor Obter(int id)
        {
            return contexto.Revisores.Where(x => x.Id == id).FirstOrDefault();
        }

        public Revisor Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
            return revisor;
        }

        public void Deletar(int Id)
        {
            var revisorDeletado = contexto.Revisores.FirstOrDefault(x => x.Id == Id);
            contexto.Revisores.Remove(revisorDeletado);
        }

        public Revisor Alterar(int id, Revisor revisor)
        {
            contexto.Entry(revisor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return Obter(id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
