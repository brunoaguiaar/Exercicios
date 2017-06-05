using AutDemo.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Entidade
{
    public class Usuario : EntidadeBasica
    {
        public int IdUsuario { get; set; }
        public string NomeUsuario { get; private set; }
        public string Username { get; private set; }
        public string Senha { get; private set; }
        public string Cargo { get; set; }
        public List<Permissao> Permissoes { get; private set; }

        protected Usuario()
        {
        }

        public Usuario(string nome, string username, string senha)
        {
            NomeUsuario = nome;
            Username = username;
            IdUsuario = Guid.NewGuid();
            if (!string.IsNullOrWhiteSpace(senha))
                Senha = CriptografarSenha(senha);
            Permissoes = new List<Permissao>();
            AtribuirPermissoes("Colaborador");
        }

        public string ResetarSenha()
        {
            var senha = string.Empty;
            for (int i = 0; i < _numeroCaracteresNovaSenha; i++)
            {
                senha += new Random().Next(0, _caracteresNovaSenha.Length);
            }

            Senha = CriptografarSenha(senha);

            return senha;
        }

        private string CriptografarSenha(string senha)
        {
            MD5 md5 = MD5.Create();
            byte[] inputBytes = Encoding.Default.GetBytes(Username + senha);
            byte[] hash = md5.ComputeHash(inputBytes);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.Length; i++)
                sb.Append(hash[i].ToString("x2"));

            return sb.ToString();
        }

        public bool ValidarSenha(string senha)
        {
            return CriptografarSenha(senha) == Senha;
        }

        public void AtribuirPermissoes(params string[] nomes)
        {
            foreach (var nome in nomes)
                Permissoes.Add(new Permissao(nome));
        }

        public override bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(NomeUsuario))
                Mensagens.Add("Nome é inválido.");

            if (string.IsNullOrWhiteSpace(Username))
                Mensagens.Add("Email é inválido.");

            if (string.IsNullOrWhiteSpace(Senha))
                Mensagens.Add("Senha é inválido.");

            return Mensagens.Count == 0;
        }
    }

}
