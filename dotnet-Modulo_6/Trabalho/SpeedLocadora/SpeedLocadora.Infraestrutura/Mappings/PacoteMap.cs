using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Mappings
{
    public class PacoteMap : EntityTypeConfiguration<Pacote>
    {
        public PacoteMap()
        {
            ToTable("Pacotes");

            HasKey(x => x.IdPacote);

            Property(p => p.Tipo).HasMaxLength(300);

            HasMany(x => x.Acessorios).WithMany().Map(x =>
            {
                x.MapLeftKey("IdPacote");
                x.MapRightKey("IdAcessorio");
                x.ToTable("PacoteAcessorio");
            });
        }
    }
}
