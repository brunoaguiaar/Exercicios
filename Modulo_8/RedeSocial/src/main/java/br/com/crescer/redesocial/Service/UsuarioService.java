package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Repositorio.UsuarioRepositorio;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author bruno.aguiar
 */

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepositorio repositorio;
    
    public Iterable<Usuario> listar(){
        return repositorio.findAll();
    }
    
    public Page<Usuario> findAll(Pageable pageable) {
        return repositorio.findAll(pageable);
    }
    
    public Usuario findById(Long id) {
        return repositorio.findOne(id);
    }
    
    public Usuario cadastrar(Usuario u)throws Exception {
        if (buscarPorEmail(u.getEmail()) != null) {
            throw new Exception("Email já cadastrado no 4Likes");
        }
        u.setSenha(new BCryptPasswordEncoder().encode(u.getSenha()));
        return repositorio.save(u);
    }
    
    public void Excluir(Usuario u){
        repositorio.delete(u);
    }
    
    public List<Usuario> buscarPorNome(String nome){
        return repositorio.findByNomeContainingIgnoreCase(nome);
    }
    
    public Usuario update(Usuario usuario) {
        return repositorio.save(usuario);
    }
    
    public void enviarConviteAmizade(Usuario solicitante, Usuario requisitado) {
        requisitado.getConvites().add(solicitante);
        update(requisitado);
    }
    
    public void aceitarConviteAmizade(Usuario usuario, Usuario usuarioAdicionar) {
        usuario.getConvites().remove(usuarioAdicionar);
        usuario.getAmigos().add(usuarioAdicionar);
        usuarioAdicionar.getAmigos().add(usuario);
        update(usuario);
        update(usuarioAdicionar);
    }
    
    public Usuario buscarPorEmail(String email){
        return repositorio.findByEmail(email);
    }
}
