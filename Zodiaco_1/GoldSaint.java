public class GoldSaint extends Saint {
    public GoldSaint(String nome, Armadura armadura) throws Exception{
        super(nome, armadura);
        this.sentidosDespertados = 7;
        /*s emudar os sentidos despertados para 4
        int valorCategoria = this.armadura.getCategoria().getValor();
        this.sentidosDespertados += valorCategoria;
        */
                
        if (this.armadura.getCatArmadura() == Categoria.OURO){
            Constelacao constelacao = armadura.getConstelacao();
            if (!constelacao.getNome().equals("Leao") 
            && !constelacao.getNome().equals("Touro")
            && !constelacao.getNome().equals("Áries")
            && !constelacao.getNome().equals("Gêmeos")
            && !constelacao.getNome().equals("Câncer")
            && !constelacao.getNome().equals("Virgem")
            && !constelacao.getNome().equals("Libra")
            && !constelacao.getNome().equals("Escorpião")
            && !constelacao.getNome().equals("Sagitário")
            && !constelacao.getNome().equals("Capricórneo")
            && !constelacao.getNome().equals("Aquário")
            && !constelacao.getNome().equals("Peixes")){
                //dar erro
                throw new Exception("Constelação inválida");
            }
        }
    }
}