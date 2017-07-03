package br.com.crescer.redesocial.Repositorio;

import br.com.crescer.redesocial.Entity.Usuario;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author bruno.aguiar
 */

public interface UsuarioRepositorio extends PagingAndSortingRepository<Usuario, String> {

    public Usuario findByEmail(String email);
    public List<Usuario> findByNomeContainingIgnoreCase(String nome);

    public Page<Usuario> findAll(Pageable pageable);

    public Usuario findOne(Long id);
    
}
