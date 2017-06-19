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
    [AllowAnonymous]
    [RoutePrefix("api/videoGame")]
    public class VideoGameController : ControllerBasica
    {
        readonly VideoGameRepositorio repositorio;

        public VideoGameController()
        {
            repositorio = new VideoGameRepositorio();
        }

        [HttpGet]
        public IHttpActionResult Listar()
        {
            return Ok(new { dados = repositorio.Listar() });
        }

        [HttpGet, Route("disponiveis"), BasicAuthorization(Roles = "Colaborador")]
        public IHttpActionResult ListarDisponiveis()
        {
            return Ok(new { dados = repositorio.ListarDisponiveis() });
        }

        [HttpGet]
        public IHttpActionResult Obter(int id)
        {
            return Ok(new { dados = repositorio.Obter(id) });
        }
    }
}
