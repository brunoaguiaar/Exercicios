using SpeedLocadora.Infraestrutura.Entidade;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Mappings
{
    class AcessorioMap : EntityTypeConfiguration<Acessorio>
    {
        public AcessorioMap()
        {
            ToTable("Acessorios");

            HasKey(x => x.IdAcessorio);
        }
    }
}
