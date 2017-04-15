public enum Status
{
    VIVO(100), 
    MORTO(0), 
    DESACORDADO(1);
    
    private int valor;
    private Status(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return this.valor;
    }
}
