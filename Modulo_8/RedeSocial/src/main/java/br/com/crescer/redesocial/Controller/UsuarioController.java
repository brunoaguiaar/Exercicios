package br.com.crescer.redesocial.Controller;

import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Service.UsuarioService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value="/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService service;
    
    @GetMapping(value = "/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PostMapping(value = "/api/usuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) throws Exception{
        service.cadastrar(usuario);
        return usuario;
    }
    
    @PostMapping(value = "/convite/{id}")
    public void enviarConvite(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Usuario usuarioLogado = service.buscarPorEmail(user.getUsername());
        Usuario usuarioSolicitado = service.findById(id);
        service.enviarConviteAmizade(usuarioLogado, usuarioSolicitado);
    }
    
    @PostMapping(value = "/aceitar/{id}")
    public void aceitarConvite(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Usuario usuarioLogado = service.buscarPorEmail(user.getUsername());
        Usuario usuarioAceitar = service.findById(id);
        service.aceitarConviteAmizade(usuarioLogado, usuarioAceitar);
    }
    
    @DeleteMapping(value = "/deletar")
    public Usuario deletarUsuario(@RequestBody Usuario usuario){
        service.Excluir(usuario);
        return usuario;
    }
    
    @PutMapping(value = "/editar")
    public Usuario editarUsuario(@RequestBody Usuario usuario) throws Exception{
        service.update(usuario);
        return usuario;
    }
    
    @GetMapping(value = "/amigos")
    public List<Usuario> getAmigosUsuario(@AuthenticationPrincipal User user) {
        return service.buscarPorEmail(user.getUsername()).getAmigos();
    }
    
    @GetMapping
    public Map<String, Object> listarUsuarios(Authentication authentication) {
        User u = Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", u);
        return hashMap;
    }
  
    @GetMapping(value = "/convites")
    public Set<Usuario> getConvites(@AuthenticationPrincipal User user) {
        return (Set<Usuario>) service.buscarPorEmail(user.getUsername()).getConvites();
    }
    
    @GetMapping(value = "/amigos/{id}")
    public Set<Usuario> getAmigosByIdUsuario(@PathVariable Long id) {
        return (Set<Usuario>) service.findById(id).getAmigos();
    }
    
    @GetMapping("/usuarioLogado")
    public Map<String, Usuario> listarUsuarios(@AuthenticationPrincipal User user) {
        final Map<String, Usuario> hashMap = new HashMap<>();
        hashMap.put("dados", service.buscarPorEmail(user.getUsername()));
        return hashMap;
    }
    
    @GetMapping(value = "/nome/{nome}")
    public Usuario buscarUsuarioPorNome(@PathVariable("nome") String nome){
        return (Usuario) service.buscarPorNome(nome);
    }
    
    @GetMapping(value = "/email/{email}")
    public Usuario buscarUsuarioPorEmail(@PathVariable("email") String email){
        return service.buscarPorEmail(email);
    }
}









