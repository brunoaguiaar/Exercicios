using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Mappings
{
    public class PacoteAcessorioMap : EntityTypeConfiguration<PacoteAcessorio>
    {
        public PacoteAcessorioMap()
        {
            ToTable("PacoteAcessorio");

            HasKey(x => x.Id);

            HasRequired(x => x.Acessorio)
               .WithMany(p => p.Pacotes)
               .Map(ep => ep.MapKey("IdPacote"));


            HasRequired(x => x.Pacote)
                .WithMany(p => p.Acessorios)
                .Map(x => x.MapKey("IdAcessorio"));
        }
    }
}
