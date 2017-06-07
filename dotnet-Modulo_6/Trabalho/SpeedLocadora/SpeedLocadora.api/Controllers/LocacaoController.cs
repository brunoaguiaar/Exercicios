using Dominio.Entidades;
using SpeedLocadora.Infraestrutura.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace SpeedLocadora.api.Controllers
{
    [RoutePrefix("api/locacao")]
    public class LocacaoController : ApiController
    {
        private LocacaoRepositorio repositorio = new LocacaoRepositorio();

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
        public IHttpActionResult Adicionar(Locacao locacao)
        {
            return Ok(new { dados = repositorio.Adicionar(locacao) });
        }

        [HttpPut]
        public IHttpActionResult Alterar(int id, Locacao locacao)
        {
            return Ok(new { dados = repositorio.Alterar(id, locacao) });
        }

        [HttpDelete]
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
