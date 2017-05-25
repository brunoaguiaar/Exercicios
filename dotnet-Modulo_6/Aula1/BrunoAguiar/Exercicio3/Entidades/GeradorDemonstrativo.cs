using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolhaPagamento
{
    class GeradorDemonstrativo : IFolhaPagamento
    {
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            double SalarioBase = salarioBase;
            double HorasCat = horasCategoria;
            double HorasExtras = horasExtras;
            double HorasDescontadas = horasDescontadas;

            var TotalHorasExtras      = new HorasCalculadas(HorasExtras, SalarioBase / HorasCat);
            var TotalHorasDescontadas = new HorasCalculadas(HorasDescontadas, SalarioBase / HorasCat);


            double SalarioTotal = (SalarioBase + TotalHorasExtras.CalcularHoras() - TotalHorasDescontadas.CalcularHoras());

            var aliquota = 0.0;

            if (SalarioTotal < 1000)
            {
                aliquota = 8.0;
            }

            else if (SalarioTotal < 1500)
            {
                aliquota = 9.0;
            }

            else
            {
                aliquota = 10.0;
            }

            var INSS = new Desconto(aliquota, SalarioTotal);
            double valorIRRF = SalarioTotal - INSS.CalcularDesconto();

            if (valorIRRF < 1710.18)
            {
                aliquota = 0;
            }

            else if (valorIRRF < 2563.91)
            {
                aliquota = 7.5;
            }

            else if (valorIRRF < 3418.59)
            {
                aliquota = 15.0;
            }

            else if (valorIRRF < 4271.59)
            {
                aliquota = 22.5;
            }

            else
            {
                aliquota = 27.5;
            }

            Desconto IRRF = new Desconto(aliquota, valorIRRF);

            double totalDescontos = INSS.CalcularDesconto() + IRRF.CalcularDesconto();
            double totalLiquido = SalarioTotal - totalDescontos;

            Desconto FGTS = new Desconto(11, SalarioTotal);

            return new Demonstrativo(SalarioBase, HorasCat, TotalHorasExtras, TotalHorasDescontadas,
            SalarioTotal, INSS, IRRF, totalDescontos, totalLiquido, FGTS);
        }
    }
}
