using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Dominio
{
    public class Cliente
    {
        public int IdCliente { get; set; }
        public string Endereco { get; set; }
        public int CPF { get; set; }
        public string Genero { get; set; }
        public DateTime DataNascimento { get; set; }
    }
}
