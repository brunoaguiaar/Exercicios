using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Cliente : EntidadeBasica
    {
        public int IdCliente { get; set; }
        public string NomeClie { get; set; }
        public string Endereco { get; set; }
        public string CPF { get; set; }
        public string Genero { get; set; }
        public DateTime DataNascimento { get; set; }

        public Cliente()
        { }


        public Cliente(string nome, string endereco, string cpf, string genero, DateTime dataNascimento)
        {
            NomeClie = nome;
            Endereco = endereco;
            CPF = cpf;
            Genero = genero;
            DataNascimento = dataNascimento;
        }

        public override bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(NomeClie))
                Mensagens.Add("Nome do cliente é inválido.");

            return Mensagens.Count == 0;
        }
    }
}
