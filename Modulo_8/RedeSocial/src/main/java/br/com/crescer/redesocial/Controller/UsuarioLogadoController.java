package br.com.crescer.redesocial.Controller;

import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bruno
 */

@RestController
@RequestMapping(UsuarioLogadoController.PATH)
public class UsuarioLogadoController {
    
    public static final String PATH = "/usuario-logado";

    @GetMapping
    public User getUserDetails(Authentication authentication) {
        return Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
    }
}
