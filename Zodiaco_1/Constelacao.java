import java.util.ArrayList;

public class Constelacao{
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int ultimaPosicaoPreenchida = 0;
    
    public Constelacao(String nome){
        this.nome = nome;
    }
    
    public Golpe[] getGolpes() {
        return this.golpes;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void adicionarGolpe(Golpe golpe) {
        golpes[ultimaPosicaoPreenchida++] = golpe;
    }

}