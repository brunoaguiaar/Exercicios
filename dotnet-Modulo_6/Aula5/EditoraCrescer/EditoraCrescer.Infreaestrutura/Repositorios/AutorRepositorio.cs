using EditoraCrescer.Infraestrutura.Entidade;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutorRepositorio : IRepositorio<Autor>, IDisposable
    {
        private Contexto contexto = new Contexto();
        private RevisorRepositorio revisorRepositorio = new RevisorRepositorio();

        public List<Autor> Listar()
        {
            return contexto.Autores.ToList();
        }

        public Autor Obter(int id)
        {
            return contexto.Autores.Where(x => x.Id == id).FirstOrDefault();
        }

        public Autor Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
            return autor;
        }

        public List<Livro> ObterLivros(int id)
        {
            var livros = contexto.Livros.Where(x => x.IdAutor == id).ToList();

            livros.ForEach(x => {
                x.Autor = Obter(x.IdAutor);
                x.Revisor = revisorRepositorio.Obter(x.IdRevisor);
            });

            return livros;
        }

        public void Deletar(int Id)
        {
            var autorDeletado = contexto.Autores.FirstOrDefault(x => x.Id == Id);
            contexto.Autores.Remove(autorDeletado);
        }

        public Autor Alterar(int id, Autor autor)
        {
            contexto.Entry(autor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return Obter(id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
