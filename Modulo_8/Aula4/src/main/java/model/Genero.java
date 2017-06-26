package model;

import java.util.List;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "GENERO")
public class Genero {
    @Id 
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO", allocationSize=1)
    private Long id;
    
    @Column(name = "DESCRICAO")
    @Basic(optional = false)
    private String descricao;
    
    @OneToMany(mappedBy="genero", cascade=CascadeType.ALL)
    private List<Video> videos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
