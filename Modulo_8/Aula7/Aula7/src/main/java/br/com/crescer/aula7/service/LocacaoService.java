package br.com.crescer.aula7.service;

import br.com.crescer.aula7.entity.Locacao;
import br.com.crescer.aula7.repositorio.LocacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bruno
 */
@Service
public class LocacaoService {
    
    @Autowired
    LocacaoRepositorio repositorio;    
    
    public Iterable<Locacao> listar() {
        return repositorio.findAll();
    }

    public Locacao cadastrar(Locacao locacao) {
        return repositorio.save(locacao);
    }

    public void excluir(Locacao locacao) {
        repositorio.delete(locacao);
    }

    public Locacao buscarPorID(Long id) {
        return repositorio.findById(id);
    }  
}