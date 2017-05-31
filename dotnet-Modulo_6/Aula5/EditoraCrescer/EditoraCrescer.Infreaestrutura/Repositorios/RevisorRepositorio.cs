using EditoraCrescer.Infreaestrutura.Entidade;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infreaestrutura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public void Adicionar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public Revisor Deletar(int Id)
        {
            var revisorDeletado = contexto.Revisores.FirstOrDefault(x => x.Id == Id);
            contexto.Revisores.Remove(revisorDeletado);
            return revisorDeletado;
        }
    }
}
