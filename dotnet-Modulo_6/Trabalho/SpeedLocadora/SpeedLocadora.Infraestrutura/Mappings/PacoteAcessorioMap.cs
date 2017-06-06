using SpeedLocadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Mappings
{
    class PacoteAcessorioMap : EntityTypeConfiguration<PacoteAcessorio>
    {
        public PacoteAcessorioMap()
        {
            HasRequired(x => x.Pacote)
                .WithMany()
                .Map(x => x.MapKey("IdPacote"));

            HasRequired(x => x.Acessorio)
                .WithMany()
                .Map(x => x.MapKey("IdAcessorio"));
        }
    }
}
