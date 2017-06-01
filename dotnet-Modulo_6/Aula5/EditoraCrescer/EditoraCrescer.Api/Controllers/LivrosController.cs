using EditoraCrescer.Infraestrutura;
using EditoraCrescer.Infraestrutura.Entidade;
using EditoraCrescer.Infraestrutura.Repositorios;
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
            return Ok(new { dados = repositorio.ListaResumo() });
        }
        [HttpGet]
        [Route("{isbn:int}")]
        public IHttpActionResult ObterLivroPorIsbn(int isbn)
        {
            return Ok(new { dados = repositorio.Obter(isbn)} );
        }

        [HttpGet]
        [Route("{isbn}")]
        public IHttpActionResult ObterLivroPorGenero(string genero)
        {
            return Ok(new { dados = repositorio.ObterResumo(genero)} );
        }

        [HttpGet]
        [Route("lancamentos")]
        public IHttpActionResult GetLancamentos()
        {
            return Ok(repositorio.ObterLancamentosResumidos());
        }

        [HttpPost]
        public IHttpActionResult IncluirLivro(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok(new { dados = livro } );
        }

        [HttpDelete]
        [Route("{isbn:int}")]
        public IHttpActionResult RemoverLivro(int isbn)
        {
            repositorio.Deletar(isbn);
            return Ok(new { mensagens = "Deletado com sucesso" });
        }

        [HttpPut]
        [Route("{isbn:int}")]
        public IHttpActionResult AlterarLivro(int isbn, Livro livro)
        {
            return Ok(new { dados = repositorio.Alterar(isbn, livro) });
        }


        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
