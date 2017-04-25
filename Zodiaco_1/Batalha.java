public class Batalha {
    private Saint desafiado, desafiante;
    //private double dano = 10;
    
    public Batalha(Saint saint1, Saint saint2){
        this.desafiado = saint1;
        this.desafiante = saint2;
    }
    
    public void iniciar() throws Exception{
        final double dano = 10;
        Saint saintEmAcao = null;
        if ((desafiado.getArmadura().getCatArmadura().getValor()) >= (desafiante.getArmadura().getCatArmadura().getValor())) {
            desafiante.perderVida(dano);
        } else if((desafiante.getArmadura().getCatArmadura().getValor()) > (desafiado.getArmadura().getCatArmadura().getValor())){
            desafiado.perderVida(dano);
        } else if ((desafiado.getArmadura().getCatArmadura().getValor()) == (desafiante.getArmadura().getCatArmadura().getValor())) {
            desafiado.perderVida(dano);
        }
        
        boolean nenhumMorto = true;
        while (nenhumMorto) {
            // 1. definindo quem vai atuar no round
            saintEmAcao = saintEmAcao == this.desafiado ? this.desafiante : this.desafiado;
            // 2. executando próximo movimento
            Movimento proximoMovimento = saintEmAcao.getProximoMovimento();
            proximoMovimento.executar();
            // 3. verificando se a batalha acabou
            nenhumMorto = this.desafiado.getStatus() != Status.MORTO &&
            this.desafiante.getStatus() != Status.MORTO;
        }
        
    }
    
}
