package br.com.crescer.aula7.service;

import br.com.crescer.aula7.entity.Ator;
import br.com.crescer.aula7.repositorio.AtorRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bruno.aguiar
 */

@Service
public class AtorService {
    
    @Autowired AtorRepositorio repositorioAtor;
    
    public List<Ator> list() {
        return (List)repositorioAtor.findAll();
    }
    
    public Ator findById(long id){
        return repositorioAtor.findOne(id);
    }
    
    public void addAtor(Ator ator){
        repositorioAtor.save(ator);
    }
    
    public void Delete(long id){
        repositorioAtor.delete(id);
    }
}
