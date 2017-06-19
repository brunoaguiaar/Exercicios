using Dominio.Entidades;
using Dominio.View;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpeedLocadora.Infraestrutura.Repositorio
{
    public class LocacaoRepositorio
    {
        private Contexto contexto = new Contexto();

        public dynamic ListarPacotes()
        {
            return contexto.Database
                .SqlQuery<ListagemPacoteView>(
                @"SELECT p.Id AS IdPacote, p.Tipo as TipoPacote, p.DiasDeDuracao, e.NomeAcessorio AS NomeAcessorio, e.Valor, ap.Quantidade 
                    FROM acessorio a  JOIN PacoteAcessorio ep ON a.Id = ap.IdAcessorio
                    JOIN Pacote p on p.Id = ap.IdPacote ")
                    .GroupBy(x => x.IdPacote)
                    .Select(a => new {
                        IdPacote = a.FirstOrDefault().IdPacote,
                        Tipo = a.FirstOrDefault().Tipo,
                        DiasDeDuracao = a.FirstOrDefault().DiasDeDuracao,
                        Acessorio = a.Select(x => new {
                            IdAcessorio = x.IdAcessorio,
                            Nome = x.NomeAcessorio,
                            Quantidade = x.Quantidade,
                            Valor = x.Valor })
                    });
        }

        public Locacao Incluir(Locacao locacao)
        {
            locacao.DataLocacao = DateTime.Now;
            contexto.Entry(locacao.Cliente).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(locacao.VideoGame).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(locacao.Pacote).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Locacoes.Add(locacao);
            contexto.SaveChanges();
            return locacao;
        }

        public List<Locacao> Listar()
        {
            return contexto.Locacoes.ToList();
        }

        public Acessorio ObterAcessorio(int id)
        {
            return contexto.Acessorios.FirstOrDefault(x => x.IdAcessorio == id);
        }

        public Pacote ObterPacote(int id)
        {
            return contexto.Pacotes.FirstOrDefault(x => x.IdPacote == id);
        }
    }
}
