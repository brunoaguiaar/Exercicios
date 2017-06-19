﻿using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Mappings
{
    public class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Clientes");

            HasKey(x => x.IdCliente);

            Property(x => x.IdCliente);
        }
    }
}
