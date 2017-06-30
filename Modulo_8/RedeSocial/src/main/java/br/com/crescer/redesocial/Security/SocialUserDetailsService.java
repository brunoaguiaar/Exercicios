package br.com.crescer.redesocial.Security;

import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 *
 * @author bruno.aguiar
 */

@Service
public class SocialUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio repositorio;
            
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repositorio.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario nao cadastrado!");
        }
        final List<GrantedAuthority> grants = new ArrayList<>();
        return new User(username, user.getSenha(), grants);
    }
}