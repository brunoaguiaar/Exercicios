package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Genero;
import br.com.crescer.aula7.service.GeneroService;
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
@RequestMapping(value = "/Genero")
public class GeneroController {
    
    @Autowired
    GeneroService service;
    
    @GetMapping
    public Iterable<Genero> listarGeneros() {
        return service.listar();
    }

    @PostMapping
    public Genero cadastrarGenero(@RequestBody Genero genero) {
        service.cadastrar(genero);
        return genero;
    }

    @DeleteMapping
    public Genero deletarGenero(@RequestBody Genero genero){
        service.excluir(genero);
        return genero;
    }
    
    @PutMapping
    public Genero atualizarGenero(@RequestBody Genero genero){
        service.cadastrar(genero);
        return genero;
    }
    
    @GetMapping(value="/{id}")
    public Genero buscarGeneroPorID(@PathVariable("id") Long id) {
        return service.buscarPorID(id);
    }
}
