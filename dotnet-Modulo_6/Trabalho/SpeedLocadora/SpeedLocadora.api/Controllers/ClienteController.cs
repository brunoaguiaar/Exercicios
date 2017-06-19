using Dominio.Entidades;
using SpeedLocadora.api.App_Start;
using SpeedLocadora.api.Models;
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
    public class ClienteController : ControllerBasica
    {
        private ClienteRepositorio repositorio = new ClienteRepositorio();

        [HttpGet, BasicAuthorization(Roles = "Colaborador")]
        public IHttpActionResult GetTodos()
        {
            return Ok(new { dados = repositorio.Listar() });
        }

        [HttpGet, Route("{id:int}"), BasicAuthorization(Roles = "Colaborador")]
        public IHttpActionResult GetPorId(int id)
        {
            return Ok(new { dados = repositorio.Obter(id) });
        }

        [HttpGet, Route("cpf/{cpf}"), BasicAuthorization(Roles = "Colaborador")]
        public IHttpActionResult GetPorCpf(string cpf)
        {
            return Ok(new { dados = repositorio.ObterPorCpf(cpf) });
        }

        [HttpPost, Route("registrar"), BasicAuthorization(Roles = "Colaborador")]
        public HttpResponseMessage Registrar([FromBody]RegistrarClienteModel model)
        {
            if (repositorio.ObterPorCpf(model.CPF) == null)
            {
                var cliente = new Cliente(model.NomeClie, model.Endereco, model.CPF, model.Genero, model.DataNascimento);

                if (cliente.Validar())
                {
                    repositorio.Adicionar(cliente);
                }
                else
                {
                    return ResponderErro(cliente.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Cliente já existe.");
            }

            return ResponderOK();
        }

        [HttpPut, Route("{id:int}"), BasicAuthorization(Roles = "Colaborador")]
        public IHttpActionResult Alterar(int id, Cliente cliente)
        {
            return Ok(new { dados = repositorio.Alterar(id, cliente) });
        }

        [HttpDelete, Route("{id:int}"), BasicAuthorization(Roles = "Gerente")]
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
