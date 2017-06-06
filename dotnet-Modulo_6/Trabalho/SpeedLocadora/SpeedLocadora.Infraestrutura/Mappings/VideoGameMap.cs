using SpeedLocadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Mappings
{
    class VideoGameMap : EntityTypeConfiguration<VideoGame>
    {
        public VideoGameMap()
        {
            ToTable("VideoGames");

            HasKey(x => x.IdVideoGame);

            HasRequired(x => x.Acessorio)
                .WithMany()
                .Map(x => x.MapKey("IdAcessorio"));

            HasRequired(x => x.Jogo)
                .WithMany()
                .Map(x => x.MapKey("IdJogo"));
            
        }
    }
}
