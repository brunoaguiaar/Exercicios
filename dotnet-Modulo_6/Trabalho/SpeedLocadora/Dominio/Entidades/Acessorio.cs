using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Acessorio : EntidadeBasica
    {
        public int IdAcessorio { get; set; }
        public string NomeAcessorio { get; set; }
        public int Quantidade { get; set; }
        public double Valor { get; set; }
        public virtual List<PacoteAcessorio> Pacotes { get; set; }
        public virtual List<LocacaoAcessorio> Locacoes { get; set; }

        public Acessorio()
        { }

        public void Alugar(int quantidade)
        {
            Quantidade -= quantidade;
        }

        public void Devolver(int quantidade)
        {
            Quantidade += quantidade;
        }

        public bool Validar(int quantidade)
        {
            if (Quantidade <= 0)
                Mensagens.Add("Saldo em estoque insuficiênte para locação!");
            return Quantidade >= quantidade && Quantidade > 0;
        }

        public override bool Validar()
        {
            throw new NotImplementedException();
        }
    }
}
