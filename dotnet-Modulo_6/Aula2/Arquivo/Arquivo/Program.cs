using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Arquivo
{
    class Program
    {
        static void Main(string[] args)
        {
            const string arquivo = @"C:\Users\bruno.aguiar\Desktop\teste.txt";

            List <String> linhas = new List<String>();

            using (var reader = new StreamReader(arquivo))
           {
                var linha = reader.ReadLine();

                Console.WriteLine(linhas);
                
                Console.ReadKey();
           }
        }
    }
}
