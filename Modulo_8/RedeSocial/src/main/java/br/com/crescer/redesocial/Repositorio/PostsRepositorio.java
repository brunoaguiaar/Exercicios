package br.com.crescer.redesocial.Repositorio;

import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Entity.Usuario;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author bruno.aguiar
 */

public interface PostsRepositorio extends PagingAndSortingRepository<Post, Long> {
    List<Post> findByUsuarioInOrder(Set<Usuario> usuarios, Pageable pageable);

    public Page<Post> findAll(Pageable pageable);
}

