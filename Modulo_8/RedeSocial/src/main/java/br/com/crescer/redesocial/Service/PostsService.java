package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Repositorio.PostsRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bruno.aguiar
 */
@Service
public class PostsService {
    
    @Autowired
    PostsRepositorio repositorio;
    
    public Iterable<Post> listarPostsDoUsuario(){
        return repositorio.findAll();
    }
    
    public Post cadastrarPost(Post post){
        return repositorio.save(post);
    }
    
    public void excluirPost(Post post){
        repositorio.delete(post);
    }
    
}
