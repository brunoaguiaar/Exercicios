package br.com.crescer.aula7.repositorio;

import br.com.crescer.aula7.entity.Locacao;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Bruno
 */
public interface LocacaoRepositorio extends CrudRepository<Locacao, Long> {
    public Locacao findById(Long id);
}
