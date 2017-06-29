package br.com.crescer.aula7.repositorio;

import br.com.crescer.aula7.entity.Funcionario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Bruno
 */
public interface FuncionarioRepositorio extends CrudRepository<Funcionario, Long>{
    public Funcionario findById(Long id);
}
