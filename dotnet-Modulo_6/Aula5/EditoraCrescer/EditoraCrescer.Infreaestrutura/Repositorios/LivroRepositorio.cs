using EditoraCrescer.Infreaestrutura.Entidade;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infreaestrutura.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();
        
        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public void Adicionar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public Livro Deletar(int Id)
        {
            var livroDeletado = contexto.Livros.FirstOrDefault(x => x.Isbn == Id);
            contexto.Livros.Remove(livroDeletado);
            return livroDeletado;
        }
    }
}
