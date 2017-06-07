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

            HasKey(x => x.Id);

            HasRequired(x => x.Locacao)
                .WithMany(p => p.Acessorios)
                .Map(x => x.MapKey("IdLocacao"));

            HasRequired(x => x.Acessorio)
                .WithMany(p => p.Locacoes)
                .Map(x => x.MapKey("IdAcessorio"));
        }
    }
}
