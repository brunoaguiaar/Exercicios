using EditoraCrescer.Infraestrutura.Entidade;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/revisores")]

    public class RevisoresController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

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

        [HttpPost]
        public IHttpActionResult Adicionar(Revisor revisor)
        {
            return Ok(new { dados = repositorio.Criar(revisor) });
        }

        [HttpPut]
        public IHttpActionResult Alterar(int id, Revisor revisor)
        {
            return Ok(new { dados = repositorio.Alterar(id, revisor) });
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