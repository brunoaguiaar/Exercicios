﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    public class CalculoIMC
    {
        public double Altura { get; set; }

        public double Peso { get; set; }

        public CalculoIMC(double peso, double altura)
        {
            Altura = altura;
            Peso = peso;
        }

        public double CalcularIMC()
        {
            return Peso/(Math.Pow(Altura, 2));
        }
    }
}
