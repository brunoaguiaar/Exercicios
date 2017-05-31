using EditoraCrescer.Infreaestrutura.Entidade;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infreaestrutura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();
        
        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }


        // fazer
        public Livro Obter(int Isbn)
        {
            return null;
        }

        public List<Livro> Obter(string genero)
        {
            var livroObtido = contexto.Livros.FirstOrDefault(x => x.Genero == genero);
            contexto.Livros.Add(livroObtido);
            return contexto.Livros.ToList();
        }

        public void Adicionar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public Livro Deletar(int Id)
        {
            var livroDeletado = contexto.Livros.FirstOrDefault(x => x.Isbn == Id);
            contexto.Livros.Remove(livroDeletado);
            return livroDeletado;
        }

        public void Alterar(int id, Livro livro)
        {
            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
