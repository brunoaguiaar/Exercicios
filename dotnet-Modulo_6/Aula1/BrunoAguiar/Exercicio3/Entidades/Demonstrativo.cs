using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolhaPagamento
{
    public class Demonstrativo
    {
        public Demonstrativo(
            double salarioBase,
            double hrsConvencao,
            HorasCalculadas horasExtras,
            HorasCalculadas horasDescontadas,
            double totalProventos,
            Desconto inss,
            Desconto irrf,
            double totalDescontos,
            double totalLiquido,
            Desconto fgts)
        {
            SalarioBase = salarioBase;
            HrsConvencao = hrsConvencao;
            HorasExtras = horasExtras;
            HorasDescontadas = horasDescontadas;
            TotalProventos = totalProventos;
            Inss = inss;
            Irrf = irrf;
            TotalDescontos = totalDescontos;
            TotalLiquido = totalLiquido;
            Fgts = fgts;
        }


        public void ImprimeDemonstrativo()
        {
            Console.WriteLine("+---------------------------------------------------+");
            Console.WriteLine("-DEMONSTRATIVO DE FOLHA DE PAGAMENTO(CONTRA-CHEQUE)-");
            Console.WriteLine("+---------------------------------------------------+");
            Console.WriteLine("-Salário Mensalista                    " + SalarioBase);
            Console.WriteLine("-Horas Extras                          " + HorasExtras.CalcularHoras());
            Console.WriteLine("-Horas Descontadas                     " + HorasDescontadas.CalcularHoras());
            Console.WriteLine("-Total de Proventos                    " + TotalProventos);
            Console.WriteLine("-INSS                                  " + Inss.CalcularDesconto());
            Console.WriteLine("-IRRF                                  " + Irrf.CalcularDesconto());
            Console.WriteLine("-Total de Descontos                    " + TotalDescontos);
            Console.WriteLine("-Total Líquido                         " + TotalLiquido);
            Console.WriteLine("-FGTS                                  " + Fgts);
            Console.WriteLine("+---------------------------------------------------+");
            Console.WriteLine("-----------------------FIM---------------------------");
            Console.WriteLine("+---------------------------------------------------+");
        }
        

        public double SalarioBase { get; private set; }
        public double HrsConvencao { get; private set; }
        public HorasCalculadas HorasExtras { get; private set; }
        public HorasCalculadas HorasDescontadas { get; private set; }
        public double TotalProventos { get; private set; }
        public Desconto Inss { get; private set; }
        public Desconto Irrf { get; private set; }
        public double TotalDescontos { get; private set; }
        public double TotalLiquido { get; private set; }
        public Desconto Fgts { get; private set; }
    }
}
