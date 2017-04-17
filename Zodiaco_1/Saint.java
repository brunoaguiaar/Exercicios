public class Saint {
    private String nome;
    protected Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int sentidosDespertados = 5;
    
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
    
    public void perderVida(double dano){
        this.vida -= dano;
    }
    
    public int getSentidosDespertados(){
        return this.sentidosDespertados;
    }
}
