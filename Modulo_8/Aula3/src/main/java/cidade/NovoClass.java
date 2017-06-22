/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidade;

/**
 *
 * @author bruno.aguiar
 */
public class NovoClass {
    public static void main(String[] args){
        final CidadeDao cidadeDao = new CidadeDaoImpl();
        
        final Cidade cidade = new Cidade();
        
        cidade.setId(5565l);
        cidade.setNome("Cidade Das Cidades Feras");
        
        cidadeDao.delete(cidade);
    }
}
