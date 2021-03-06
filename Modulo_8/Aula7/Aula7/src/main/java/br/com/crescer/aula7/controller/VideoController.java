package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.entity.Video;
import br.com.crescer.aula7.service.VideoService;
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
@RequestMapping(value = "/Video")
public class VideoController {
    @Autowired
    VideoService service;

    @GetMapping
    public Iterable<Video> listarVideos() {
        return service.listar();
    }

    @PostMapping
    public Video cadastrarVideo(@RequestBody Video v) {
        service.cadastrar(v);
        return v;
    }

    @DeleteMapping
    public Video deletarVideo(@RequestBody Video v){
        service.excluir(v);
        return v;
    }
    
    @PutMapping
    public Video atualizarVideo(@RequestBody Video v){
        service.cadastrar(v);
        return v;
    }
    
    @GetMapping(value="/{id}")
    public Video buscarVideoPorID(@PathVariable("id") Long id) {
        return service.buscarPorID(id);
    }
}