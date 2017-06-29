package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Funcionario;
import br.com.crescer.aula7.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bruno
 */

@RestController
@RequestMapping(value="/Funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioService service;
    
    @GetMapping
    public Iterable<Funcionario> listaarFuncionario(){
        return service.listar();
    }
    
    @PostMapping
    public Funcionario cadastrarCliente(@RequestBody Funcionario funcionario) {
        service.cadastrar(funcionario);
        return funcionario;
    }
    
    @DeleteMapping
    public Funcionario deletarCliente(@RequestBody Funcionario funcionario){
        service.excluir(funcionario);
        return funcionario;
    }
    
    @PutMapping
    public Funcionario atualizarCliente(@RequestBody Funcionario funcionario){
        service.cadastrar(funcionario);
        return funcionario;
    }
    
    @GetMapping(value="/{id}")
    public Funcionario buscarFuncionarioPorID(@PathVariable("id") Long id) {
        return service.buscarPorID(id);
    }
}
