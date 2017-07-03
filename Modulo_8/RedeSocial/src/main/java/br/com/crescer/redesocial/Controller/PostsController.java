package br.com.crescer.redesocial.Controller;

import br.com.crescer.redesocial.Entity.Post;
import br.com.crescer.redesocial.Service.PostsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bruno.aguiar
 */

@RestController
@RequestMapping(value="/post")
public class PostsController {
    
    @Autowired
    PostsService service;
    
    @GetMapping(value = "/{id}")
     public List<Post> getPostsByUser(@PathVariable Long id) {
        return service.getPostsByIdUsuario(id);
    }
    
    @PostMapping
    public Post cadastrarPost(@RequestBody Post post, @AuthenticationPrincipal User user){
        service.cadastrarPost(post, user);
        return post;
    }
    
    @GetMapping(value = "/feed")
    public List<Post> getFeedPosts(@AuthenticationPrincipal User user) {
        return service.getFeedPosts(user);
    }
}
