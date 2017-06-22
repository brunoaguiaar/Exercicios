package pessoa;

/**
 *
 * @author bruno.aguiar
 */
public class Pessoa {
    
    private long Id;
    
    private String Nome;

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public long getId() {
        return Id;
    }
    
}
