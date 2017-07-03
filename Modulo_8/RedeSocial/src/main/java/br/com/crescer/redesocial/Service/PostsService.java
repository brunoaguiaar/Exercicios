package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Repositorio.PostsRepositorio;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author bruno.aguiar
 */
@Service
public class PostsService {
        
    @Autowired
    private UsuarioService service;
    
    @Autowired
    private PostsRepositorio repositorio;
    
    public Iterable<Post> findAll(){
        return repositorio.findAll();
    }
    
//    public Page<Post> findAll(Pageable pageable) {
//        return repositorio.findAll(pageable);
//    }
    
    public Post findById(Long id) {
        return repositorio.findOne(id);
    }
    
    public Post cadastrarPost(Post post, User user){
        Usuario usuarioLogado = service.buscarPorEmail(user.getUsername());
        post.setUsuario(usuarioLogado);
        return repositorio.save(post);
    }
    
    public void excluirPost(Long id){
        repositorio.delete(id);
    }
    
    public List<Post> getFeedPosts(User user) {
        List<Usuario> amigos = 
                service.buscarPorEmail(user.getUsername()).getAmigos();
        return repositorio.findByUsuarioInOrderByIdDesc(amigos);
    }
    
    public List<Post> getPostsByIdUsuario(Long id) {
        return service.findById(id).getPosts();
    }
    
}
