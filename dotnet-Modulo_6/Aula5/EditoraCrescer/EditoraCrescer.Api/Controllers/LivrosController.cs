using EditoraCrescer.Infreaestrutura;
using EditoraCrescer.Infreaestrutura.Entidade;
using EditoraCrescer.Infreaestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/livros")]

    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        public IHttpActionResult ObterLivros()
        {
            var livros = repositorio.Obter();
            return Ok(livros);
        }
        [HttpGet]
        [Route("{isbn} : int")]
        public IHttpActionResult ObterLivroPorIsbn(int isbn)
        {
            var livro = repositorio.Obter(isbn);
            return Ok(livro);
        }

        [HttpGet]
        [Route("{isbn}")]
        public IHttpActionResult ObterLivroPorGenero(string genero)
        {
            var livro = repositorio.Obter(genero);
            return Ok(livro);
        }

        [HttpPost]
        public IHttpActionResult IncluirLivro(Livro livro)
        {
            repositorio.Adicionar(livro);
            return Ok();
        }

        [HttpDelete]
        [Route("{isbn}")]
        public IHttpActionResult RemoverLivro(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }

        [HttpPut]
        [Route("{isbn}")]
        public IHttpActionResult AlterarLivro(int id, Livro livro)
        {
            repositorio.Alterar(id, livro);
            return Ok();
        }


        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
