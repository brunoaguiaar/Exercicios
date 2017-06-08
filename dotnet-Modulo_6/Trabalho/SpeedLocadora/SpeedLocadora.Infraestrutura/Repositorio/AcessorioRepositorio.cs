using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Repositorio
{
    public class AcessorioRepositorio
    {
        private Contexto contexto = new Contexto();

        public IEnumerable<Acessorio> Listar()
        {
            return contexto.Acessorios.ToList();
        }

        public Acessorio Alugar(Acessorio acessorio, int quantidade)
        {
            acessorio.Alugar(quantidade);

            contexto.Entry(acessorio).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return acessorio;
        }

        public Acessorio Devolver(Acessorio acessorio, int quantidade)
        {
            acessorio.Devolver(quantidade);

            contexto.Entry(acessorio).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return acessorio;
        }

        public Acessorio Obter(int id)
        {
            return contexto.Acessorios.Where(u => u.IdAcessorio == id).FirstOrDefault();
        }


    }
}
