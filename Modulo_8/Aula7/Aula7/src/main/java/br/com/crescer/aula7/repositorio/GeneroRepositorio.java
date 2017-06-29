package br.com.crescer.aula7.repositorio;


import br.com.crescer.aula7.entity.Genero;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Bruno
 */
public interface GeneroRepositorio extends CrudRepository<Genero, Long>{
    public Genero findById(Long id);
}
