package br.com.crescer.redesocial.Controller;

import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bruno.aguiar
 */

@RestController
@RequestMapping(value="/Post")
public class PostsController {
    
    @Autowired
    PostsService service;
    
    @GetMapping
    public Iterable<Post> listarPostsDoUsuarios(){
        return service.listarPostsDoUsuario();
    }
    
    @PostMapping
    public Post cadastrarPost(@RequestBody Post post){
        service.cadastrarPost(post);
        return post;
    }
    
    @DeleteMapping
    public Post deletarUsuario(@RequestBody Post post){
        service.excluirPost(post);
        return post;
    }
    
    @PutMapping
    public Post editarPost(@RequestBody Post post){
        service.cadastrarPost(post);
        return post;
    }
    
}
