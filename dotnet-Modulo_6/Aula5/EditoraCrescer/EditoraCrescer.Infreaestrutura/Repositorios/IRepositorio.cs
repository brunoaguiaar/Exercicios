using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public interface IRepositorio<R> where R : class
    {
        List<R> Listar();
        R Obter(int id);
        R Criar(R objeto);
        R Alterar(int id, R objeto);
        void Deletar(int id);

    }
}
