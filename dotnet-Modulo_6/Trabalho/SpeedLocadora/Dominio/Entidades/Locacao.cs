using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Locacao
    {
        public int IdLocacao { get; set; }
        public DateTime DataLocacao { get; set; }
        public DateTime DataEntrega { get; set; }
        public DateTime PrevisaoEntrega { get; set; }
        public double PrecoFinal { get; set; }
        public double PrecoPrevisto { get; set; }
        public VideoGame VideoGame { get; set; }
        public Pacote Pacote { get; set; }
        public Cliente Cliente { get; set; }
        public virtual List<Acessorio> Acessorios { get; set; }

        public Locacao()
        { }

        public Locacao(Cliente cliente, VideoGame videoGame, Pacote pacote, List<Acessorio> Acessorios)
        {
            Cliente = cliente;
            VideoGame = videoGame;
            DataLocacao = DateTime.Now.Date;
            PrecoPrevisto = ValorLocacao();
            Pacote = pacote;
        }

        public double ValorLocacao()
        {
            double valorProduto = VideoGame.Valor * Pacote.DiasDeDuracao;
            double valorOpcional = Acessorios.Sum(x => x.Valor) * Pacote.DiasDeDuracao;
            double valorPacote = Pacote.Valor;

            return valorProduto + valorPacote + valorOpcional;
        }
    }
}
