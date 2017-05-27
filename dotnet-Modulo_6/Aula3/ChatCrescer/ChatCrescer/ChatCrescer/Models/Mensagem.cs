using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ChatCrescer.Models
{
    public class Mensagem
    {
        private int IdMensagem { get; set; }
        private Usuario usuario { get; set; }
        private string Texto { get; set; }
        private DateTime DataEnvio { get; set; }
    }
}