using EditoraCrescer.Infreaestrutura.Entidade;
using EditoraCrescer.Infreaestrutura.Mappings;
using SpeedLocadora.Infraestrutura.Entidade;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infreaestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("ExemploEFSP")
        { }

        public DbSet<Console> Consoles { get; set; }
        public DbSet<Jogo> Jogos { get; set; }
        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Acessorio> Acessorios { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ConsoleMap());
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new AcessorioMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
        }

    }
}