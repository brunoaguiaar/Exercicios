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
    [RoutePrefix("api/locacao"), BasicAuthorization(Roles = "Colaborador")]
    public class LocacaoController : ControllerBasica
    {
        private LocacaoRepositorio locacaoRepositorio = new LocacaoRepositorio();
        private ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
        private VideoGameRepositorio videoGameRepositorio = new VideoGameRepositorio();
        private AcessorioRepositorio acessorioRepositorio = new AcessorioRepositorio();
        private PacoteRepositorio pacoteRepositorio = new PacoteRepositorio();

        public HttpResponseMessage Get()
        {
            return ResponderOK(locacaoRepositorio.Listar());
        }

        [HttpGet, Route("pacotes")]
        public IHttpActionResult ListarPacote()
        {
            return Ok(new { dados = locacaoRepositorio.ListarPacotes() });
        }

        [HttpPost, Route("registrar")]
        public IHttpActionResult CriarLocacao([FromBody]RegistrarLocacaoModel model)
        {
            var cliente = model.Cliente;
            var videoGame = model.VideoGame;
            var pacote = model.Pacote;

            var locacao = new Locacao(cliente, videoGame, pacote, model.Acessorios);
            locacaoRepositorio.Incluir(locacao);

            videoGameRepositorio.Alugar(videoGame.IdVideoGame);
            acessorioRepositorio.Aluga(model.Acessorios);
            acessorioRepositorio.Aluga(model.Pacote.Acessorios);

            return Ok(locacao);
        }
    }
}
