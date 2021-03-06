package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Locacao;
import br.com.crescer.aula7.service.LocacaoService;
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
@RequestMapping(value = "/Locacao")
public class LocacaoController {
    
    @Autowired
    LocacaoService service;

    @GetMapping
    public Iterable<Locacao> listarLocacoes() {
        return service.listar();
    }

    @PostMapping
    public Locacao cadastrarLocacao(@RequestBody Locacao l) {
        service.cadastrar(l);
        return l;
    }

    @DeleteMapping
    public Locacao deletarLocacao(@RequestBody Locacao l){
        service.excluir(l);
        return l;
    }
    
    @PutMapping
    public Locacao atualizarLocacao(@RequestBody Locacao l){
        service.cadastrar(l);
        return l;
    }
    
    @GetMapping(value="/{id}")
    public Locacao buscarLocacaoPorID(@PathVariable("id") Long id) {
        return service.buscarPorID(id);
    }
}
