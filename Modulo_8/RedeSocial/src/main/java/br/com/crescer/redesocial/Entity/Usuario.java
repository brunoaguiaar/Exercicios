package br.com.crescer.redesocial.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author bruno.aguiar
 */

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{
    @Id
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    private Long id;
    
    @Size(min = 1, max = 50, message = "o nome deve ter entre {min} e {max} caracteres.")
    @Basic(optional = false)
    @Column(name = "NOME_USUARIO")
    private String nome;
    
    @Size(min = 1, max = 50, message = "o email deve ter entre {min} e {max} caracteres.")
    @Basic(optional = false)
    @Column(name = "EMAIL_USUARIO")
    private String email;
    
    @Size(min = 1, max = 100, message = "a senha deve ter entre {min} e {max} caracteres.")
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;
    
    @Basic(optional = false)
    @Column(name = "SEXO")
    private String sexo;
    
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Post> posts;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> amigos;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> convites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo(){
        return sexo;
    }
    
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public List<Usuario> getConvites() {
        return convites;
    }

    public void setConvites(List<Usuario> convites) {
        this.convites = convites;
    }
    
    @Override
    public boolean equals(Object user) {
        return this.id.equals(((Usuario)user).id);
    }
    
}








