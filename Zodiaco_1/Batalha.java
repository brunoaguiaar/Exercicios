public class Batalha {
    private Saint desafiado, desafiante;
    //private double dano = 10;
    
    public Batalha(Saint saint1, Saint saint2){
        this.desafiado = saint1;
        this.desafiante = saint2;
    }
    public void iniciar(){
        final double dano = 10;
        if ((desafiado.getArmadura().getCatArmadura().getValor()) >= (desafiante.getArmadura().getCatArmadura().getValor())) {
            desafiante.perderVida(dano);
        } else if((desafiante.getArmadura().getCatArmadura().getValor()) > (desafiado.getArmadura().getCatArmadura().getValor())){
            desafiado.perderVida(dano);
        } else if ((desafiado.getArmadura().getCatArmadura().getValor()) == (desafiante.getArmadura().getCatArmadura().getValor())) {
            desafiado.perderVida(dano);
        }
    }
}
