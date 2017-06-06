using System;
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;

namespace SpeedLocadora.Dominio
{
    public class Usuario
    {
        public Guid IdUsuario { get; private set; }
        public string NomeUsuario { get; private set; }
        public string Username { get; private set; }
        public string Senha { get; private set; }
        public string Cargo { get; private set; }
        
        protected Usuario()
        {
        }
    }

}
