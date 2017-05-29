using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Demo1.Dominio.Entidades;

namespace Demo1.Infraestrutura.Repositorios
{
    class PedidoRepositorio : IPedidoRepositorio
    {
        public void Alterar(Pedido pedido)
        {
            throw new NotImplementedException();
        }

        public void Criar(Pedido pedido)
        {
            //realizar o insert do pedido
            //obter o ultimo id do pedido (SELECT @@IDENTYTI)

            //para cada item do pedido, realizar o insert do ItemPedido
            //obter o ultimo id do ItemPedido (SELECT @@IDENTYTI)
        }

        public void Excluir(int id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Pedido> Listar()
        {
            throw new NotImplementedException();
        }

        public Pedido Obter(int id)
        {
            throw new NotImplementedException();
        }
    }
}
