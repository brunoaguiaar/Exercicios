using Dominio.Entidades;
using SpeedLocadora.Infraestrutura.Mappings;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("ExemploEFSP")
        { }

        public DbSet<VideoGame> VideoGames { get; set; }
        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Acessorio> Acessorios { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }
        public DbSet<Permissao> Permissoes { get; set; }
        public DbSet<Locacao> Locacoes { get; set; }
        public DbSet<Pacote> Pacotes { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new VideoGameMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new AcessorioMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            modelBuilder.Configurations.Add(new LocacaoMap());
            modelBuilder.Configurations.Add(new PacoteMap());
        }
    }
}
