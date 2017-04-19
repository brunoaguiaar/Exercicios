import java.util.ArrayList;

public class ListaSaints {
    private ArrayList<Saint> listaSaints = new ArrayList<> ();
    
    public void adicionar(Saint saint){
        this.listaSaints.add(saint);
    }
    
    public Saint get(int i){
        return this.listaSaints.get(i);
    }
    
    public ArrayList<Saint> todos(){
        return this.listaSaints;
    }
    
    public void remove(Saint saint){
        this.listaSaints.remove(saint);
    }
    
    public Saint buscarPorNome(String nome){
        for (Saint saint : listaSaints){
            if (nome.equals(saint.getNome())){
                return saint;
            }
        }
        return null;
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){
        ArrayList<Saint> categoriaSaints = new ArrayList<>();
        for(Saint saint : listaSaints){
            if(categoria.equals(saint.getCatArmadura())){
                categoriaSaints.add(saint);
            }
        }
        return categoriaSaints;
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status){
        ArrayList<Saint> statusSaints = new ArrayList<>();
        for(Saint saint : listaSaints){
            if(status.equals(saint.getStatus())){
                statusSaints.add(saint);
            }
        }
        return statusSaints;
    }
    
    public Saint getSaintMenorVida(){
        Saint saintComMenorVida = null;
        double menorVida = 100;
        for(Saint saint : listaSaints){
            if(saint.getVida() < menorVida){
                saintComMenorVida = saint;
                menorVida = saint.getVida();
            }
        }
        return saintComMenorVida;
    }
    
    public Saint getSaintMaiorVida(){
        Saint saintComMaiorVida = null;
        double menorVida = 0;
        for(Saint saint : listaSaints){
            if(saint.getVida() > menorVida){
                saintComMaiorVida = saint;
                menorVida = saint.getVida();
            }
        }
        return saintComMaiorVida;
    }
    
    public void ordenar(){
       
       Saint ordem = null;
       for(int i = 0;i<listaSaints.size()-1; i++){
           for(int j = 1; j<listaSaints.size(); j++){
               if(listaSaints.get(i).getVida()<listaSaints.get(j).getVida()){
                   ordem = listaSaints.get(i);
                   listaSaints.add(listaSaints.indexOf(ordem),listaSaints.get(j));
                   listaSaints.add(listaSaints.indexOf(listaSaints.get(j)),ordem);
                }
            }
        }
    }
}



















