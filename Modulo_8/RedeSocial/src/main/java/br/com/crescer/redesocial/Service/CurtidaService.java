/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.Service;

import br.com.crescer.redesocial.Entity.Curtida;
import br.com.crescer.redesocial.Repositorio.CurtidaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bruno
 */

@Service
public class CurtidaService {
    
    @Autowired
    private CurtidaRepositorio repositorio;
    
    @Autowired
    private PostsService postService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public Curtida save(Curtida like, User user, Long idPost) {
        like.setPost(postService.findById(idPost));
        like.setUsuarioCurtida(usuarioService.buscarPorEmail(user.getUsername()));
        return repositorio.save(like);
    }
    
    public void delete(Long id) {
        repositorio.delete(id);
    }
}
