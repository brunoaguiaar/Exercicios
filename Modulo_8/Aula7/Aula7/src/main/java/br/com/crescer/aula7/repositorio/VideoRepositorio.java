package br.com.crescer.aula7.repositorio;

import br.com.crescer.aula7.entity.Video;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Bruno
 */
public interface VideoRepositorio extends CrudRepository<Video, Long> {
    public Video findById(Long id);
}
