public class Batalha {
    private Saint saint1;
    private Saint saint2;
    
    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
    public void iniciarBatalha(){
        saint2.getPerderVida();
    }
}
