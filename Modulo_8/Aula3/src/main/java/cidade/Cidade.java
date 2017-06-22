package cidade;

import estado.Estado;

/**
 *
 * @author bruno.aguiar
 */
public class Cidade {
    
    private long Id;
    private String Nome;
    private Estado Estado;

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

    public Estado getEstado() {
        return Estado;
    }

    public void setEstado(Estado Estado) {
        this.Estado = Estado;
    }
}
