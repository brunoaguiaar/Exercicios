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
    [RoutePrefix("api/cliente")]
    public class ClienteController : ApiController
    {
        private ClienteRepositorio repositorio = new ClienteRepositorio();

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
        public IHttpActionResult GetPorCpf(string cpf)
        {
            return Ok(new { dados = repositorio.ObterPorCpf(cpf) });
        }

        [HttpPost]
        public IHttpActionResult Adicionar(Cliente cliente)
        {
            return Ok(new { dados = repositorio.Adicionar(cliente) });
        }

        [HttpPut]
        public IHttpActionResult Alterar(int id, Cliente cliente)
        {
            return Ok(new { dados = repositorio.Alterar(id, cliente) });
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
