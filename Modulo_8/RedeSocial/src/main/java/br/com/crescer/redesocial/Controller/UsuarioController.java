package br.com.crescer.redesocial.Controller;

import br.com.crescer.redesocial.Entity.Usuario;
import br.com.crescer.redesocial.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value="/Usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService service;
    
    @GetMapping
    public Iterable<Usuario> listarUsuarios(){
        return service.listar();
    }
    
    @PostMapping(value = "/api/usuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        service.cadastrar(usuario);
        return usuario;
    }
    
    @DeleteMapping
    public Usuario deletarUsuario(@RequestBody Usuario usuario){
        service.Excluir(usuario);
        return usuario;
    }
    
    @PutMapping
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        service.cadastrar(usuario);
        return usuario;
    }
    
    @GetMapping(value="/{nome}")
    public Usuario buscarUsuarioPorNome(@PathVariable("nome") String nome){
        return service.buscarPorNome(nome);
    }
    
    @GetMapping(value="/{email}")
    public Usuario buscarUsuarioPorEmail(@PathVariable("email") String email){
        return service.buscarPorEmail(email);
    }
}









