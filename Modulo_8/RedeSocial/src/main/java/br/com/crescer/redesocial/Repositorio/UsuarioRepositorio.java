package br.com.crescer.redesocial.Repositorio;

import br.com.crescer.redesocial.Entity.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bruno.aguiar
 */

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

    public Usuario findByEmail(String email);
    
    public Usuario findOneByNomeContainingIgnoreCase(String nome);
    
}
