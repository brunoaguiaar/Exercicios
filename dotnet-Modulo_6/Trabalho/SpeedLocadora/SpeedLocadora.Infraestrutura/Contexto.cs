using SpeedLocadora.Dominio;
using SpeedLocadora.Infraestrutura.Mappings;
using System.Data.Entity;

namespace EditoraCrescer.Infreaestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("ExemploEFSP")
        { }

        public DbSet<VideoGame> VideoGames { get; set; }
        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Acessorio> Acessorios { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new VideoGameMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new AcessorioMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
        }

    }
}