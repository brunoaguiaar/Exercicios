import java.security.*;
import java.util.ArrayList;

public abstract class Saint {
    private String nome;
    protected Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int sentidosDespertados = 5;
    private int golpeAtual;

    protected Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
    }

    public String getNome(){
        return this.nome;
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
        if (dano < 0){
            throw new InvalidParameterException("dano");
        }
        
        if ((getVida() > 0) && (getVida() <= 100)){
            if ((dano > 0) && (dano > getVida())){
                status = Status.MORTO;
                this.vida = 0;
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
    
    private  Constelacao getConstelacao(){
        return this.armadura.getConstelacao();
    }
    
    public ArrayList <Golpe> getGolpes() {
        return getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe) {
        getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe() {
        Golpe g = getConstelacao().getGolpes().get(golpeAtual++ % getGolpes().size());
        return g;
    }
    
    public int getValorCatArmadura(){
        return armadura.getValorCategoria();
    }
    
    public Categoria getCatArmadura(){
        return this.armadura.getCatArmadura();
    }
    
    public String getCSV(){
        String resultado = 
            this.nome + "," +
            this.vida + "," +
            this.getConstelacao().getNome() + "," +
            this.armadura.getCatArmadura() + "," +
            this.status + "," +
            this.genero + "," +
            this.armaduraVestida;                   
        return resultado;
    }
}
