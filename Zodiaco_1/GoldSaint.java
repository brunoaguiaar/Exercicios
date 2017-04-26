public class GoldSaint extends Saint {
    public GoldSaint(String nome, String constelacao) throws Exception{

        /*s emudar os sentidos despertados para 4
        int valorCategoria = this.armadura.getCategoria().getValor();
        this.sentidosDespertados += valorCategoria;
         */
        super(nome, new Armadura(new Constelacao(constelacao), Categoria.OURO));
        this.sentidosDespertados = 7;
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
            throw new ConstelacaoInvalidaException();
        }
    }
}
