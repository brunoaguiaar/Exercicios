package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Repositorio.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author bruno.aguiar
 */

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    public Iterable<Usuario> listar(){
        return usuarioRepositorio.findAll();
    }
    
//    public Page<Usuario> findAll(Pageable pageable) {
//        return usuarioRepositorio.findAll(pageable);
//    }
    
    public Usuario findById(Long id) {
        return usuarioRepositorio.findOne(id);
    }
    
    public Usuario cadastrar(Usuario u)throws Exception {
        if (buscarPorEmail(u.getEmail()) != null) {
            throw new Exception("Email já cadastrado!");
        }
        u.setSenha(new BCryptPasswordEncoder().encode(u.getSenha()));
        return usuarioRepositorio.save(u);
    }
    
    public void Excluir(Usuario u){
        usuarioRepositorio.delete(u);
    }
    
    public Usuario buscarPorNome(String nome){
        return usuarioRepositorio.findOneByNomeContainingIgnoreCase(nome);
    }
    
    public Usuario update(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
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
        return usuarioRepositorio.findByEmail(email);
    }
}
