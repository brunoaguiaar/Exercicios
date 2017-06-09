using Dominio.Entidades;
using SpeedLocadora.api.App_Start;
using SpeedLocadora.Infraestrutura.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace SpeedLocadora.api.Controllers
{
    [RoutePrefix("api/locacao"), BasicAuthorization(Roles = "Gerente")]
    public class LocacaoController : ControllerBasica
    {
        private LocacaoRepositorio repositorio = new LocacaoRepositorio();

        [HttpGet, Route("pacotes")]
        public IHttpActionResult ListarPacote()
        {
            return Ok(new { dados = repositorio.Listar() });
        }

        [HttpPost]
        public IHttpActionResult Incluir()
        {
            return Ok(new { dados = repositorio.Listar() });
        }
    }
}
