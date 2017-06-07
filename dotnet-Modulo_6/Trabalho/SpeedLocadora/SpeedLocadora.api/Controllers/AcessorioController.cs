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
    [RoutePrefix("api/acessorio")]
    public class AcessorioController : ApiController
    {
        private AcessorioRepositorio repositorio = new AcessorioRepositorio();

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
        public IHttpActionResult GetPorNome(string nome)
        {
            return Ok(new { dados = repositorio.ObterPorCpf(nome) });
        }

        [HttpPost]
        public IHttpActionResult Adicionar(Acessorio acessorio)
        {
            return Ok(new { dados = repositorio.Adicionar(acessorio) });
        }

        [HttpPut]
        public IHttpActionResult Alterar(int id, Acessorio acessorio)
        {
            return Ok(new { dados = repositorio.Alterar(id, acessorio) });
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
