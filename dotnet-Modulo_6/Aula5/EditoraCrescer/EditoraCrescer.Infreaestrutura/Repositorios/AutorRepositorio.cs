using EditoraCrescer.Infreaestrutura.Entidade;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infreaestrutura.Repositorios
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public void Adicionar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public Autor Deletar(int Id)
        {
            var autorDeletado = contexto.Autores.FirstOrDefault(x => x.Id == Id);
            contexto.Autores.Remove(autorDeletado);
            return autorDeletado;
        }
    }
}
