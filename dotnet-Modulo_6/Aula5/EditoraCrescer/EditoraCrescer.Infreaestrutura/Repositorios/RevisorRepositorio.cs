using EditoraCrescer.Infreaestrutura.Entidade;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infreaestrutura.Repositorios
{
    public class RevisorRepositorio : IRepositorio<Revisor>, IDisposable
    {
        private Contexto contexto = new Contexto();
       

        public List<Revisor> Listar()
        {
            return contexto.Revisores.ToList();
        }

        public Revisor Obter(int id)
        {
            return contexto.Revisores.Where(x => x.Id == id).FirstOrDefault();
        }

        public Revisor Adicionar(Revisor revisor)
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
