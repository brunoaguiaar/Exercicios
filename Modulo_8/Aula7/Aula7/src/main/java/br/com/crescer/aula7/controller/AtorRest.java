/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Ator;
import br.com.crescer.aula7.service.AtorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bruno.aguiar
 */
@RestController
public class AtorRest {
    
    @Autowired AtorService serviceAtor;
    
    @GetMapping("/atores")
    public List<Ator> list() {
        return serviceAtor.list();
    }
    
    @GetMapping("/atores/{id}")
    public Ator getById(long id){
        return serviceAtor.findById(id);
    }
    
    @PostMapping("/atores")
    public void Adicionar(@RequestBody Ator ator) {
        serviceAtor.addAtor(ator);
    }
    
    @DeleteMapping("/atores")
    public void Deletar(long id){
        serviceAtor.Delete(id);
    }
}
