package br.com.crescer.aula7.service;

import br.com.crescer.aula7.entity.Video;
import br.com.crescer.aula7.repositorio.VideoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bruno
 */

@Service
public class VideoService {
    @Autowired
    VideoRepositorio repositorio;    
    
    public Iterable<Video> listar() {
        return repositorio.findAll();
    }

    public Video cadastrar(Video video) {
        return repositorio.save(video);
    }

    public void excluir(Video video) {
        repositorio.delete(video);
    }

    public Video buscarPorID(Long id) {
        return repositorio.findById(id);
    }  
}
