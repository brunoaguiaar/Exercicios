using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Pacote : EntidadeBasica
    {
        public int IdPacote { get; set; }
        public string Tipo { get; set; }
        public double Valor { get; set; }
        public VideoGame VideoGame { get; set; }
        public Acessorio Acessorio { get; set; }

        public Pacote()
        {

        }

        public override bool Validar()
        {
            throw new NotImplementedException();
        }
    }
}
