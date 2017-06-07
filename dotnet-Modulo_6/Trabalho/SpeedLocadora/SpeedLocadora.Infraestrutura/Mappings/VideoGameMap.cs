using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Mappings
{
    public class VideoGameMap : EntityTypeConfiguration<VideoGame>
    {
        public VideoGameMap()
        {
            ToTable("VideoGame");

            HasKey(x => x.IdVideoGame);
        }
    }
}
