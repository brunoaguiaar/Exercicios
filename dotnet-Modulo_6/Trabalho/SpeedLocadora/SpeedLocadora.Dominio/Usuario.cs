using System;
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;

namespace SpeedLocadora.Dominio
{
    public class Usuario : EntidadeBasica
    {

        static readonly char[] _caracteresNovaSenha = "abcdefghijklmnopqrstuvwxyz1234567890*-_".ToCharArray();
        static readonly int _numeroCaracteresNovaSenha = 10;

        public Guid IdUsuario { get; private set; }
        public string NomeUsuario { get; private set; }
        public string Username { get; private set; }
        public string Senha { get; private set; }
        public string Cargo { get; private set; }
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
            AtribuirPermissoes("Gerente");
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
