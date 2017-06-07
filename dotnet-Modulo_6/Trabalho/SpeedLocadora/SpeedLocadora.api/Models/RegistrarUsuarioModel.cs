using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SpeedLocadora.api.Models
{
    public class RegistrarUsuarioModel
    {
        public string Email { get; set; }
        public string Nome { get; set; }
        public string Senha { get; set; }
    }
}