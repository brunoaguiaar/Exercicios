package br.com.crescer.redesocial.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author bruno.aguiar
 */

@Entity
@Table(name = "POST")
public class Post implements Serializable{
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_POST")
    @SequenceGenerator(name = "SEQ_POST", sequenceName = "SEQ_POST", allocationSize = 1)
    @Column(name = "ID_POST")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
    @Size(min = 1, max = 200, message = "os caracteres do post devem ser entre {min} e {max} caracteres.")
    @Basic(optional = false)
    @Column(name = "TITULO_POST")
    private String tituloPost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTituloPost() {
        return tituloPost;
    }

    public void setTituloPost(String tituloPost) {
        this.tituloPost = tituloPost;
    }
       
}