import java.security.*;
import java.util.ArrayList;

public class Saint {
    private String nome;
    protected Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int sentidosDespertados = 5;
    private int golpeAtual;

    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
    }

    public void vestirArmadura(){
        this.armaduraVestida = true;
    }

    // camelCase
    public boolean getArmaduraVestida(){
        return this.armaduraVestida; 
    }

    public Genero getGenero(){
        return genero;
    }

    public void setGenero(Genero genero){
        this.genero = genero;
    }

    public Armadura getArmadura(){
        return armadura;
    }

    public Status getStatus(){
        return status;
    }

    public double getVida(){
        return this.vida;
    }

    public void perderVida(double dano) throws Exception{
        if ((getVida() > 0) && (getVida() <= 100)){
            if ((dano > 0) && (dano > getVida())){
                status = Status.MORTO;
                vida = 0;
            } else if ((dano > 0) && (dano < getVida())){
                this.vida -= dano;
            }
        } else if(getVida() <= 0){
            status = Status.MORTO;
            throw new Exception("Impossivel Perder Vida, Saint esta morto");
        }
    }

    public int getSentidosDespertados(){
        return this.sentidosDespertados;
    }
    
    public ArrayList<Golpe> getGolpes() {
        return this.armadura.getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe) {
        this.armadura.getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe() {
        if(this.golpeAtual >= getGolpes().size()) {
            this.golpeAtual = 0;
        }
        return getGolpes().get(golpeAtual++);
    }

}
