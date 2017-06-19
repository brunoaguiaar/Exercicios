using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Repositorio
{
    public class ClienteRepositorio : IDisposable
    {
        Contexto contexto = new Contexto();

        public List<Cliente> Listar()
        {
            return contexto.Clientes.ToList();
        }

        public Cliente Obter(int id)
        {
            return contexto.Clientes.Where(x => x.IdCliente == id).FirstOrDefault();
        }

        public Cliente ObterPorCpf(string cpf)
        {
            return contexto.Clientes.Where(x => x.CPF == cpf).FirstOrDefault();
        }

        public Cliente Adicionar(Cliente cliente)
        {
            contexto.Clientes.Add(cliente);
            contexto.SaveChanges();
            return ObterPorCpf(cliente.CPF);
        }

        public void Deletar(int Id)
        {
            var autor = contexto.Clientes.FirstOrDefault(x => x.IdCliente == Id);
            contexto.Clientes.Remove(autor);
            contexto.SaveChanges();
        }

        public Cliente Alterar(int id, Cliente cliente)
        {
            contexto.Entry(cliente).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return Obter(id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}