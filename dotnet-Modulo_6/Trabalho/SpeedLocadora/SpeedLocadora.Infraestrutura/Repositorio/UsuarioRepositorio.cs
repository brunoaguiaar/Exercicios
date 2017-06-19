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

        public Usuario Criar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
            return usuario;
        }

        public Usuario Obter(string email)
        {
            return contexto.Usuarios.Where(u => u.Email == email)
                .Include(a => a.Permissoes)
                .FirstOrDefault();
        }
    }
}
