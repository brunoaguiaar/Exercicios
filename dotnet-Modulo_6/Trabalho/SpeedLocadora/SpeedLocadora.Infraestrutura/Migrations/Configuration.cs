namespace SpeedLocadora.Infraestrutura.Migrations
{
    using Dominio.Entidades;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<SpeedLocadora.Infraestrutura.Contexto>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(SpeedLocadora.Infraestrutura.Contexto context)
        {
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            //    context.People.AddOrUpdate(
            //      p => p.FullName,
            //      new Person { FullName = "Andrew Peters" },
            //      new Person { FullName = "Brice Lambson" },
            //      new Person { FullName = "Rowan Miller" }
            //    );
            //

            if (!context.Usuarios.Where(x => x.Email == "bruno@cwi.com.br").Any())
            {
                var usuario = new Usuario("bruno@cwi.com.br", "123456");
                usuario.AtribuirPermissoes("Colaborador");
                context.Usuarios.Add(usuario);
                context.SaveChanges();
            }

            if (!context.Usuarios.Where(i => i.Email == "bruno.aguiar@cwi.com.br").Any())
            {
                var usuario = new Usuario("bruno.aguiar@cwi.com.br", "123456");
                usuario.AtribuirPermissoes("Gerente");
                context.Usuarios.Add(usuario);
                context.SaveChanges();
            }
        }
    }
}
