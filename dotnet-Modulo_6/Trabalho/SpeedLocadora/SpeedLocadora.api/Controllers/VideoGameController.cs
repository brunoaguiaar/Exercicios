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

        [HttpPut, Route("alugar/{id:int}"), BasicAuthorization(Roles = "Colaborador")]
        public HttpResponseMessage Alugar(int id)
        {
            var videoGame = repositorio.Obter(id);

            if (videoGame.Validar())
                return ResponderErro(videoGame.Mensagens);

            return ResponderOK(new { dados = repositorio.Alugar(videoGame) });
        }

        [HttpPut, Route("devolver/{id:int}"), BasicAuthorization(Roles = "Colaborador")]
        public HttpResponseMessage Devolver(int id)
        {
            var videoGame = repositorio.Obter(id);

            return ResponderOK(new { dados = repositorio.Devolver(videoGame) });
        }
    }
}
