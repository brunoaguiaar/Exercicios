public class GoldSaint extends Saint {
    public GoldSaint(String nome, Armadura armadura) throws Exception{
        super(nome, armadura);
        this.sentidosDespertados = 7;
        /*s emudar os sentidos despertados para 4
        int valorCategoria = this.armadura.getCategoria().getValor();
        this.sentidosDespertados += valorCategoria;
        */
                
        if (this.armadura.getCatArmadura() == Categoria.OURO){
            String constelacao = armadura.getConstelacao();
            if (!constelacao.equals("Leao") 
            && !constelacao.equals("Touro")
            && !constelacao.equals("Áries")
            && !constelacao.equals("Gêmeos")
            && !constelacao.equals("Câncer")
            && !constelacao.equals("Virgem")
            && !constelacao.equals("Libra")
            && !constelacao.equals("Escorpião")
            && !constelacao.equals("Sagitário")
            && !constelacao.equals("Capricórneo")
            && !constelacao.equals("Aquário")
            && !constelacao.equals("Peixes")){
                //dar erro
                throw new Exception("Constelação inválida");
            }
        }
    }
}