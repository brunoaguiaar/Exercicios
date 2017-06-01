using EditoraCrescer.Infraestrutura.Entidade;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/autores")]
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();

        [HttpGet]
        public IHttpActionResult GetTodos()
        {
            return Ok(new { dados = repositorio.Listar() });
        }

        [HttpGet]
        public IHttpActionResult GetPorId(int id)
        {
            return Ok(new { dados = repositorio.Obter(id) });
        }

        [HttpGet]
        [Route("{id}/livros")]
        public IHttpActionResult GetLivrosAutor(int id)
        {
            return Ok(new { dados = repositorio.ObterLivros(id) });
        }

        [HttpPost]
        public IHttpActionResult Adicionar(Autor autor)
        {
            return Ok(new { dados = repositorio.Criar(autor) });
        }

        [HttpPut]
        public IHttpActionResult Alterar(int id, Autor autor)
        {
            return Ok(new { dados = repositorio.Alterar(id, autor) });
        }

        public IHttpActionResult Remove(int id)
        {
            repositorio.Deletar(id);
            return Ok(new { mensagens = "Deletado com sucesso" });
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}