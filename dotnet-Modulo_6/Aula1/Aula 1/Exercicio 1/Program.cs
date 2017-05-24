using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio_1
{
    class Program
    {
        static void Main(string[] args)
        {

            List<int> entradas = new List<int>();

            while (true)
            {
                Console.WriteLine("Digite um valor");
                var entrada = Console.ReadLine();

                if (entrada == "exit")
                {
                    break;
                }

                entradas.Add(int.Parse(entrada));
            }

            foreach (var entrada in entradas)
            {
                Console.WriteLine(entrada);
            }
            Console.ReadKey();
        }
    }
}
