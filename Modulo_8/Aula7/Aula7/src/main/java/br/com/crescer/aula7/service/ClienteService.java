package br.com.crescer.aula7.service;

import br.com.crescer.aula7.entity.Cliente;
import br.com.crescer.aula7.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bruno
 */

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepositorio repositorio;  
    
    public Iterable<Cliente> listar() {
        return repositorio.findAll();
    }

    public Cliente cadastrar(Cliente c) {
        return repositorio.save(c);
    }

    public void excluir(Cliente c) {
        repositorio.delete(c);
    }

    public Cliente buscarPorID(Long id) {
        return repositorio.findById(id);
    }  
}
