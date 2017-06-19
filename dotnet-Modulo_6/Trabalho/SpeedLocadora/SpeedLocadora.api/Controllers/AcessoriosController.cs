using SpeedLocadora.api.App_Start;
using SpeedLocadora.Infraestrutura.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Http;

namespace SpeedLocadora.api.Controllers
{
    [RoutePrefix("api/acessorios"), BasicAuthorization(Roles = "Colaborador")]
    public class AcessoriosController : ControllerBasica
    {
        private AcessorioRepositorio repositorio = new AcessorioRepositorio();

        public HttpResponseMessage Get(int id)
        {
            return ResponderOK(repositorio.ObterPorId(id));
        }

        [HttpGet, Route("disponiveis")]
        public HttpResponseMessage ListaDisponiveis()
        {
            return ResponderOK(repositorio.ListarDisponiveis());
        }
    }
}