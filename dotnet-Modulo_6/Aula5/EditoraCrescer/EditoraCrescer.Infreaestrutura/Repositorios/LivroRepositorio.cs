using EditoraCrescer.Infreaestrutura.Entidade;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infreaestrutura.Repositorios
{
    public class LivroRepositorio : IRepositorio<Livro>, IDisposable
    { 
        private AutorRepositorio autorRepositorio = new AutorRepositorio();
        private RevisorRepositorio revisorRepositorio = new RevisorRepositorio();
        private Contexto contexto = new Contexto();

        public List<Livro> Listar()
        {
            return contexto.Livros.ToList();
        }

        public object ListaResumo()
        {
            return contexto.Livros.Select(x => new {
                Isbn = x.Isbn,
                Titulo = x.Titulo,
                Capa = x.Capa,
                NomeAutor = x.Autor.Nome,
                Genero = x.Genero
            }).ToList();
        }

        public Livro Obter(int isbn)
        {
            var livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);

            livro.Autor = autorRepositorio.Obter(livro.IdAutor);
            livro.Revisor = revisorRepositorio.Obter(livro.IdRevisor);

            return livro;
        }

        public object Obter(string genero)
        {
            var livro = contexto.Livros.FirstOrDefault(x => x.Genero.Contains(genero));

            livro.Autor = autorRepositorio.Obter(livro.IdAutor);
            livro.Revisor = revisorRepositorio.Obter(livro.IdRevisor);

            return livro;
        }

        public object ObterResumo(string genero)
        {
            return contexto.Livros.Where(x => x.Genero.Contains(genero)).Select(x => new {
                Isbn = x.Isbn,
                Titulo = x.Titulo,
                Capa = x.Capa,
                NomeAutor = x.Autor.Nome,
                Genero = x.Genero
            }).ToList();
        }

        public object ObterLancamentosResumidos()
        {
            var data = DateTime.Now.AddDays(-7);

            return contexto.Livros
                .Where(x => (x.DataPublicacao > data))
                .Select(x => new {
                    Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.Capa,
                    NomeAutor = x.Autor.Nome,
                    Genero = x.Genero
                })
                .ToList();
        }
        public Livro Adicionar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();

            return livro;
        }

        public void Deletar(int Id)
        {
            var livroDeletado = contexto.Livros.FirstOrDefault(x => x.Isbn == Id);
            contexto.Livros.Remove(livroDeletado);
            contexto.SaveChanges();
        }

        public Livro Alterar(int isbn, Livro livro)
        {
            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return Obter(isbn);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
