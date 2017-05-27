using ChatCrescer.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ChatCrescer.Controllers
{
    public class UsuarioController : ApiController
    {
        private static List<Usuario> usuarios = new List<Usuario>();
        private object locker = new object();

        public IEnumerable<Usuario> Get()
        {
            return usuarios;
        }

        public IHttpActionResult Post(Usuario usuario)
        {
            if (usuario == null)
            {
                return BadRequest();
            }
            else
            {
                lock (locker)
                {
                    usuarios.Add(usuario);
                }

                return Ok(usuario);
            }
        }
    }
}
