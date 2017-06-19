using Dominio.Entidades;
using SpeedLocadora.api.App_Start;
using SpeedLocadora.api.Models;
using SpeedLocadora.Infraestrutura.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace SpeedLocadora.api.Controllers
{
    // Permite usuário não autenticados acessarem a controller
    [AllowAnonymous]
    [RoutePrefix("api/acessos")]
    public class UsuarioController : ApiController
    {
        readonly UsuarioRepositorio _usuarioRepositorio;

        public UsuarioController()
        {
            _usuarioRepositorio = new UsuarioRepositorio();
        }

        [HttpGet, Route("usuario")]
        [BasicAuthorization]
        public IHttpActionResult Obter()
        {
            var usuarioDaSessao = _usuarioRepositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (usuarioDaSessao == null)
            {
                return BadRequest("Usuario não encontrado");
            }
            var usuario = new { Email = usuarioDaSessao.Email, Permissoes = usuarioDaSessao.Permissoes };
            return Ok(new { dados = usuario });
        }
    }
}
