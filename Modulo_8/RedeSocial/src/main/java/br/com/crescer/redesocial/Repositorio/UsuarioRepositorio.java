package br.com.crescer.redesocial.Repositorio;

import br.com.crescer.redesocial.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bruno.aguiar
 */

public interface UsuarioRepositorio extends CrudRepository<Usuario, String> {

    public Usuario findByNome(String nome);
    public Usuario findByEmail(String email);
    
}
