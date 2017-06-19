using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Mappings
{
    public class LocacaoMap : EntityTypeConfiguration<Locacao>
    {
        public LocacaoMap()
        {
            ToTable("Locacao");

            HasKey(x => x.IdLocacao);

            HasRequired(x => x.Cliente)
                .WithMany()
                .Map(x => x.MapKey("IdCliente"));

            HasOptional(x => x.Pacote)
                .WithMany()
                .Map(x => x.MapKey("IdPacote"));

            HasRequired(x => x.VideoGame)
                .WithMany()
                .Map(x => x.MapKey("IdVideoGame"));

            HasMany(x => x.Acessorios)
                .WithMany()
                .Map(x =>
                {
                    x.MapLeftKey("IdLocacao");
                    x.MapRightKey("IdAcessorio");
                    x.ToTable("LocacaoAcessorio");

                });
        }
    }
}
