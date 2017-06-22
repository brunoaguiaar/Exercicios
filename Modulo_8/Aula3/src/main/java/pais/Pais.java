package pais;

/**
 *
 * @author bruno.aguiar
 */
public class Pais {
    
    private long Id;
    private String Nome;
    private String Sigla;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }
    
}
