using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Mappings
{
    public class LocacaoAcessorioMap : EntityTypeConfiguration<LocacaoAcessorio>
    {
        public LocacaoAcessorioMap()
        {
            ToTable("PacoteAcessorio");

            HasKey(x => x.IdLocacaoAcessorio);

            HasRequired(x => x.Locacao);

            HasRequired(x => x.Acessorio);
        }
    }
}
