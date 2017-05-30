using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Demo1.Dominio.Entidades;
using System.Data.SqlClient;

namespace Demo1.Infraestrutura.Repositorios
{
    class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao = "Server=13.65.101.67; User Id=bruno.aguiar; Password=123456; Database=aluno15db";

        public void Alterar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =@"UPDATE Pedido SET NomeCliente = @NomeCliente WHERE Id = @Id";
                    comando.Parameters.AddWithValue("@NomeCliente", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("@Id", pedido.Id);

                    comando.ExecuteNonQuery();
                }
                foreach (ItemPedido item in pedido.Itens)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"UPDATE ItemPedido SET PedidoId = @PedidoId,
                                              ProdutoId = @ProdutoId, Quantidade = @Quantidade 
                                              WHERE Id = @Id";

                        comando.Parameters.AddWithValue("@PedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@ProdutoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@Quantidade", item.Quantidade);
                        comando.Parameters.AddWithValue("@Id", item.Id);

                        comando.ExecuteNonQuery();
                    }
                }
            }
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"insert into pedido(NomeCliente) values(@NomeCliente)";

                    comando.Parameters.AddWithValue("@NomeCliente", pedido.NomeCliente);

                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";

                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }

                foreach(ItemPedido item in pedido.Itens)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"insert into ItemPedido(PedidoId, ProdutoId, Quantidade)
                                                values(@PedidoId, @ProdutoId, @Quantidade)";

                        comando.Parameters.AddWithValue("@PedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@ProdutoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@Quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();
                        using (var comandoInterno = conexao.CreateCommand())
                        {
                            comandoInterno.CommandText = "SELECT @@IDENTITY";
                            var result = (decimal)comandoInterno.ExecuteScalar();
                            item.Id = (int)result;
                        }
                    }
                }
            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE Pedido WHERE Id = @Id";
                    comando.Parameters.AddWithValue("@Id", id);
                    comando.ExecuteNonQuery();
                }
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE ItemPedido WHERE PedidoID = @Id";
                    comando.Parameters.AddWithValue("@Id", id);
                    comando.ExecuteNonQuery();
                }
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT Id, NomeCliente FROM Pedido";

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var pedido = new Pedido();

                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];

                        pedidos.Add(pedido);
                    }
                    dataReader.Close();
                }

                foreach (Pedido pedido in pedidos)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"SELECT Id, ProdutoId, Quantidade 
                                              FROM ItemPedido WHERE PedidoId = @PedidoId";

                        comando.Parameters.AddWithValue("@PedidoId", pedido.Id);

                        var dataReader = comando.ExecuteReader();
                        while (dataReader.Read())
                        {
                            var itemPedido = new ItemPedido();

                            itemPedido.Id = (int)dataReader["Id"];
                            itemPedido.ProdutoId = (int)dataReader["ProdutoId"];
                            itemPedido.Quantidade = (int)dataReader["Quantidade"];
                            pedido.Itens.Add(itemPedido);
                        }
                        dataReader.Close();
                    }

                }
            }
            return pedidos;
        }

        public Pedido Obter(int id)
        {
            Pedido pedido = null;

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT Id, NomeCliente FROM Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    if (dataReader.Read() != false)
                    {
                        pedido = new Pedido();
                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        dataReader.Close();
                    }
                    else
                    {
                        return null;
                    }
                }
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT Id, PedidoId, ProdutoId, Quantidade 
                                          FROM ItemPedido WHERE PedidoId = @PedidoId";

                    comando.Parameters.AddWithValue("@PedidoId", pedido.Id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var itemPedido = new ItemPedido();

                        itemPedido.Id = (int)dataReader["Id"];
                        itemPedido.ProdutoId = (int)dataReader["ProdutoId"];
                        itemPedido.Quantidade = (int)dataReader["Quantidade"];
                        pedido.Itens.Add(itemPedido);
                    }
                    dataReader.Close();
                }
            }
            return pedido;
        }
    }
}
