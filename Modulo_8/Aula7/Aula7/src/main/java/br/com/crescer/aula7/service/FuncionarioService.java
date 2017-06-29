package br.com.crescer.aula7.service;

import br.com.crescer.aula7.entity.Funcionario;
import br.com.crescer.aula7.repositorio.FuncionarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bruno
 */

@Service
public class FuncionarioService {
    @Autowired
    FuncionarioRepositorio repositorio;    
    
    public Iterable<Funcionario> listar() {
        return repositorio.findAll();
    }

    public Funcionario cadastrar(Funcionario funcionario) {
        return repositorio.save(funcionario);
    }

    public void excluir(Funcionario funcionario) {
        repositorio.delete(funcionario);
    }

    public Funcionario buscarPorID(Long id) {
        return repositorio.findById(id);
    }  
}
