using ChatCrescer.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ChatCrescer.Controllers
{
    public class MensagemController : ApiController
    {
        private static List<Mensagem> mensagens = new List<Mensagem>();
        private static int Ids = 0;
        private static object @lock = new object();

        public IEnumerable<Mensagem> Get()
        {
            return mensagens;           
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                lock (@lock)
                {
                    mensagem.DataEnvio = DateTime.Now;
                    mensagem.IdMensagem = ++Ids;
                    mensagens.Add(mensagem);
                }

                return Ok(mensagem);
            }
        }
    }
}
