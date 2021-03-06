package br.com.crescer.redesocial.Repositorio;

import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Entity.Usuario;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author bruno.aguiar
 */

public interface PostsRepositorio extends PagingAndSortingRepository<Post, Long> {
    List<Post> findByUsuarioInOrderByIdDesc(List<Usuario> usuarios);
}

