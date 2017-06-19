using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SpeedLocadora.api.Models
{
    public class RegistrarLocacaoModel
    {
        public Cliente Cliente { get; set; }
        public VideoGame VideoGame { get; set; }
        public Pacote Pacote { get; set; }
        public List<Acessorio> Acessorios { get; set; }
    }
}