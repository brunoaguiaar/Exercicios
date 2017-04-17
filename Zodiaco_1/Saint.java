public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    private int sentidosDespertados = 5;
    
    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        
        /*s emudar os sentidos despertados para 4
        int valorCategoria = this.armadura.getCategoria().getValor();
        this.sentidosDespertados += valorCategoria;
        */
                
        if (this.armadura.getCatArmadura() == Categoria.PRATA) {
            this.sentidosDespertados = 6;
        } else if (this.armadura.getCatArmadura() == Categoria.OURO){
            this.sentidosDespertados = 7;
            String constelacao = armadura.getConstelacao();
            if (!constelacao.equals("Leao") && !constelacao.equals("Touro")){
                //dar erro
                throw new Exception("Constelação inválida");
            }
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
