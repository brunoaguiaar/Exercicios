using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ChatCrescer.Models
{
    public class Mensagem
    {
        public int IdMensagem { get; set; }
        public Usuario usuario { get; set; }
        public string Texto { get; set; }
        public DateTime DataEnvio { get; set; }
    }
}