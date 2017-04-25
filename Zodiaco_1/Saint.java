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
    private ArrayList<Movimento> movimentos = new ArrayList<>();
    private int golpeAtual, acumuladorProximoMovimento = 0;;

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

    public void perderVida(double dano) {

        if (dano < 0) {
            throw new InvalidParameterException("dano");
            //throw new IllegalArgumentException("dano");
        }

        if (vida - dano < 1) {
            this.status = Status.MORTO;
            this.vida = 0;
        } else {
            //this.vida = this.vida - dano;
            this.vida -= dano;
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
        return String.format(
            "%s,%s,%s,%s,%s,%s,%s",
            this.nome,
            this.vida,
            this.getConstelacao().getNome(),
            this.armadura.getCatArmadura(),
            this.status,
            this.genero,
            this.armaduraVestida
        );
        /*String resultado = 
            this.nome + "," +
            this.vida + "," +
            this.getConstelacao().getNome() + "," +
            this.armadura.getCatArmadura() + "," +
            this.status + "," +
            this.genero + "," +
            this.armaduraVestida;                   
        return resultado;*/
    }
    
    public void adicionarMovimento(Movimento movimento) {
        this.movimentos.add(movimento);
    }
    
    public Movimento getProximoMovimento() {
        int posicao = this.acumuladorProximoMovimento % this.movimentos.size();
        this.acumuladorProximoMovimento++;
        return movimentos.get(posicao);
    }
    

    // "agendando" execução do golpe no saint passado por parâmetro
    // o golpe de fato só será executado na batalha.
    public void golpear(Saint golpeado) {
        this.adicionarMovimento(new Golpear(this, golpeado));
    }
}
