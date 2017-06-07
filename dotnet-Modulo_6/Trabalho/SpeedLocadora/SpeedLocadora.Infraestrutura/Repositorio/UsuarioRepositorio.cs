using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Repositorio
{
    public class UsuarioRepositorio
    {
        Contexto contexto = new Contexto();

        public UsuarioRepositorio()
        {

        }

        public Usuario Obter(int id)
        {
            return contexto.Usuarios.FirstOrDefault(x => x.IdUsuario == id);
        }

        public Usuario Criar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
            return usuario;
        }

        public Usuario Alterar(Usuario usuario)
        {
            contexto.Entry(usuario).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return Obter(usuario.IdUsuario);
        }
        public void Excluir(Usuario usuario)
        {
            var deletado = contexto.Usuarios.FirstOrDefault(x => x.NomeUsuario.Contains(usuario.NomeUsuario));
            contexto.Usuarios.Remove(deletado);
            contexto.SaveChanges();
        }

        public IEnumerable<Usuario> Listar()
        {
            return contexto.Usuarios.ToList();
        }

        public Usuario Obter(string email)
        {
            var usuario = contexto.Usuarios.FirstOrDefault(x => x.Email.Contains(email));

            return usuario;
        }
    }
}
