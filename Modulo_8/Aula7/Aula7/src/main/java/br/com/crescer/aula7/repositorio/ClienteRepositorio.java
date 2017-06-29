package br.com.crescer.aula7.repositorio;

import br.com.crescer.aula7.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Bruno
 */
public interface ClienteRepositorio extends CrudRepository<Cliente, Long>{
    public Cliente findById(Long id);
}
