using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
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

        public Usuario Criar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
            return usuario;
        }

        public void Alterar(Usuario usuario)
        {
            contexto.Entry(usuario).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
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
            var usuario = contexto.Usuarios.Where(x => x.Email == email).Include(x => x.Permissoes).FirstOrDefault();

            return usuario;
        }
    }
}
