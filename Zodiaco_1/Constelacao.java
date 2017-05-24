import java.util.ArrayList;

public class Constelacao{
    private String nome;
    private ArrayList <Golpe> golpes = new ArrayList<> ();
    
    public Constelacao(String nome){
        this.nome = nome;
    }
    
    public ArrayList <Golpe> getGolpes() {
        return this.golpes;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void adicionarGolpe(Golpe golpe) {
        golpes.add(golpe);
    }

}