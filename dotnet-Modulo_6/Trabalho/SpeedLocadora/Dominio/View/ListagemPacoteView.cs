using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.View
{
    public class ListagemPacoteView
    {
        public int IdPacote { get; set; }
        public int IdAcessorio { get; set; }
        public string Tipo { get; set; }
        public int DiasDeDuracao { get; set; }
        public string NomeAcessorio { get; set; }
        public decimal Valor { get; set; }
        public int Quantidade { get; set; }
    }
}
