import java.util.ArrayList;
import java.util.stream.Collectors;

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
        for (Saint saint : this.listaSaints){
            if (saint.getNome().equals(nome)){
                return saint;
            }
        }
        return null;
        /*return this.listaSaints.stream()
        .filter(s -> s.getNome().equals(nome))
        .findFirst()
        .orElse(null);*/
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){
        /*ArrayList<Saint> categoriaSaints = new ArrayList<>();
        for(Saint saint : this.listaSaints){
            if(categoria.equals(saint.getCatArmadura())){
                categoriaSaints.add(saint);
            }
        }
        return categoriaSaints;*/
        
        return (ArrayList<Saint>)this.listaSaints.stream()
            .filter(s -> s.getArmadura().getCatArmadura().equals(categoria))
            .collect(Collectors.toList());
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status){
         return (ArrayList<Saint>)this.listaSaints.stream()
            .filter(s -> s.getStatus().equals(status))
            .collect(Collectors.toList());
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
    /*
         * BubbleSort
         * Complexidade: O(n^2)
         * 
         * 
         *     [4] [3] [60] [17] [10]
         * i0: [3] [4] [17] [10] [60]
         * i1: [3] [4] [10] [17] [60]
         */
        
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.listaSaints.size() - 1; i++) {
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i + 1);
                boolean precisaTrocar = atual.getVida() > proximo.getVida();
                if (precisaTrocar) {
                    this.listaSaints.set(i, proximo);
                    this.listaSaints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);   
    
    }

    public void ordenar(TipoOrdenacao tipoOrdenacao){
        if(tipoOrdenacao.equals(tipoOrdenacao.ASCENDENTE)){
            this.ordenar();
        } else {
             boolean posicoesSendoTrocadas;
             do {
                 posicoesSendoTrocadas = false;
                 for (int i = 0; i < this.listaSaints.size() - 1; i++) {
                     Saint atual = this.listaSaints.get(i);
                     Saint proximo = this.listaSaints.get(i + 1);
                     boolean precisaTrocar = atual.getVida() < proximo.getVida();
                     if (precisaTrocar) {
                         this.listaSaints.set(i, proximo);
                         this.listaSaints.set(i + 1, atual);
                         posicoesSendoTrocadas = true;
                        }
                 }
             } while (posicoesSendoTrocadas);  
        }
    }
    
    private void adicionarTodos(ListaSaints lista) {
        this.listaSaints.addAll(lista.todos());
    }
    
    public ListaSaints unir(ListaSaints listaNova) {
        ListaSaints listaVolta = new ListaSaints();
        listaVolta.adicionarTodos(this);
        listaVolta.adicionarTodos(listaNova);
        return listaVolta;
    }
    
    public ListaSaints diff(ListaSaints listaNova){
        ListaSaints listaVolta = new ListaSaints();
        for(Saint saint : this.listaSaints) {
            if(!listaNova.todos().contains(saint)){
                listaVolta.adicionar(saint);
            }
        }
        return listaVolta;
    }
    
    public ListaSaints intersec(ListaSaints listaNova){
        ListaSaints listaVolta = new ListaSaints();
        for(Saint saint : this.listaSaints) {
            if(listaNova.todos().contains(saint)){
                listaVolta.adicionar(saint);
            }
        }
        return listaVolta;
    }
    
    public String getCSV() {
        if (this.listaSaints.isEmpty()) {
            return "";
        }

        String separador = System.getProperty("line.separator");
        StringBuilder builder = new StringBuilder(512);

        builder.append(this.listaSaints.get(0).getCSV());
        for (int i = 1; i < this.listaSaints.size(); i++) {
            Saint saint = this.listaSaints.get(i);
            //resultado += separador + saint.getCSV();
            //builder.append(String.format("%s%s", separador, saint.getCSV()));
            builder.append(separador);
            builder.append(saint.getCSV());
        }

        return builder.toString();
    }

}



















