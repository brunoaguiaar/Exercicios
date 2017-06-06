using SpeedLocadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Mappings
{
    class PacoteMap : EntityTypeConfiguration<Pacote>
    {
        public PacoteMap()
        {
            ToTable("Pacotes");

            HasKey(x => x.IdPacote);

            HasRequired(x => x.VideoGame)
                .WithMany()
                .Map(x => x.MapKey("IdVideoGame"));
        }
    }
}
