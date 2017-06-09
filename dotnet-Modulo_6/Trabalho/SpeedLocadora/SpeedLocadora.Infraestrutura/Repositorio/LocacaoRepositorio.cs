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

        public dynamic Listar()
        {
            return contexto.Database
                .SqlQuery<ListagemPacoteView>(
                @"SELECT p.Id AS IdPacote, p.Tipo as TipoPacote, p.DiasDeDuracao, e.NomeAcessorio AS NomeAcessorio, e.Valor, ep.Quantidade 
                    FROM acessorio e  JOIN PacoteAcessorio ep ON e.Id = ep.IdAcessorio
                    JOIN Pacote p on p.Id = ep.IdPacote ")
                    .GroupBy(x => x.IdPacote)
                    .Select(e => new {
                        Tipo = e.FirstOrDefault().Tipo,
                        DiasDeDuracao = e.FirstOrDefault().DiasDeDuracao,
                        Acessorio = e.Select(x => new { Nome = x.NomeAcessorio, Quantidade = x.Quantidade, Valor = x.Valor })
                    });
        }

        public Locacao Incluir(Locacao locacao)
        {
            contexto.Locacoes.Add(locacao);
            contexto.SaveChanges();
            return locacao;
        }
    }
}
