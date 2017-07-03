/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.Controller;

import br.com.crescer.redesocial.Entity.Curtida;
import br.com.crescer.redesocial.Service.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bruno
 */

@RestController
@RequestMapping(value="/curtir")
public class CurtidaController {
    
    @Autowired
    private CurtidaService service;
    
    @PostMapping(value = "/curtida/{id}")
    public void adicionarLike(@RequestBody Curtida curtida, 
            @AuthenticationPrincipal User user, @PathVariable Long id) {
        service.save(curtida, user, id);
    }
    
    @PostMapping(value = "/deslike/{id}")
    public void removerLike(@PathVariable Long id) {
        service.delete(id);
    }
}
