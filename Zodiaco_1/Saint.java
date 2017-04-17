public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    private int sentidosDespertados = 5;
    
    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
        
        if (this.armadura.getCatArmadura() == Categoria.PRATA) {
            this.sentidosDespertados = 6;
        } else if (this.armadura.getCatArmadura() == Categoria.OURO){
            this.sentidosDespertados = 7;
        } else {
            this.sentidosDespertados = 5;
        }
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
