package br.com.crescer.redesocial.Repositorio;

import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Entity.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bruno.aguiar
 */

public interface PostsRepositorio extends CrudRepository<Post, Long>{
    List<Post> findByUsuario(List<Usuario> usuarios);
}
