package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Cliente;
import br.com.crescer.aula7.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bruno
 */

@RestController
@RequestMapping(value="/Cliente")
public class ClienteController {
    @Autowired
    ClienteService service;
    
    @GetMapping
    public Iterable<Cliente> listaarCliente(){
        return service.listar();
    }
    
    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        service.cadastrar(cliente);
        return cliente;
    }
    
    @DeleteMapping
    public Cliente deletarCliente(@RequestBody Cliente cliente){
        service.excluir(cliente);
        return cliente;
    }
    
    @PutMapping
    public Cliente atualizarCliente(@RequestBody Cliente cliente){
        service.cadastrar(cliente);
        return cliente;
    }
    
    @GetMapping(value="/{id}")
    public Cliente buscarClientePorID(@PathVariable("id") Long id) {
        return service.buscarPorID(id);
    }
}
