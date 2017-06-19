using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SpeedLocadora.api.Models
{
    public class RegistrarClienteModel
    {
        public int IdCliente { get; set; }
        public string NomeClie { get; set; }
        public string Endereco { get; set; }
        public string CPF { get; set; }
        public string Genero { get; set; }
        public DateTime DataNascimento { get; set; }
    }
}