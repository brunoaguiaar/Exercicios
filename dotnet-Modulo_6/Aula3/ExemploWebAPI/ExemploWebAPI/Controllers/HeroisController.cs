using ExemploWebAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebAPI.Controllers
{
    public class HeroisController : ApiController
    {
        private static int idHeroi = 0;
        private static object objetoLock = new object();
        private static List<Heroi> herois = new List<Heroi>()
        {
            new Heroi(){Id = ++idHeroi, Nome = "Goku", poder = new Poder(){ Nome = "Genki Dama", Dano = 8000 } },
            new Heroi(){Id = ++idHeroi, Nome = "Ronaldinho", poder = new Poder(){ Nome = "Dibrar", Dano = 10000 } },
            new Heroi(){Id = ++idHeroi, Nome = "Batman", poder = new Poder(){ Nome = "Morcegao", Dano = 20000 } },
            new Heroi(){Id = ++idHeroi, Nome = "Spider Man", poder = new Poder(){ Nome = "Teia do mal", Dano = 15000 } },
        };

        public IEnumerable<Heroi> Get(string nome = null, int? id = null)
        {
            
            return herois.Where(x =>
            (id == null || x.Id == id) &&
            (nome == null || x.Nome == nome)
            );
        }
        public IHttpActionResult Post(Heroi heroi)
        {
            if(heroi == null)
            {
                return BadRequest();
            }
            else
            {
                lock (objetoLock)
                {
                    heroi.Id = ++idHeroi;
                    herois.Add(heroi);
                }
                // Salva no banco de dados
                return Ok(heroi);
            }
        }
    }
}
