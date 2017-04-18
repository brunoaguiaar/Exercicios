import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Armadura illuminati = new Armadura("Touro", Categoria.OURO);
        GoldSaint alcemar = new GoldSaint("Alcemar", illuminati);        
        // 2. Act - Invocar a ação a ser testada
        alcemar.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = alcemar.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception{
        BronzeSaint hyoga = new BronzeSaint("Hyoga", new Armadura("Touro", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    @Test
    public void aoCriarSaintGeneroENaoInformado()throws Exception {
        GoldSaint shaka = new GoldSaint("Shaka", new Armadura("Touro", Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    @Test
    public void aoCriaSaintStatusVivo()throws Exception {
        GoldSaint bruno = new GoldSaint("Bruno", new Armadura("Leao", Categoria.OURO));
        assertEquals(Status.VIVO, bruno.getStatus());
    }
    @Test
    public void vidaInicialDeveSer100()throws Exception {
        GoldSaint bruno = new GoldSaint("Bruno", new Armadura("Leao", Categoria.OURO));
        assertEquals(100.0, bruno.getVida(), 0.01);
    }
    @Test
    public void testeDePerderVidaComValor10()throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", new Armadura("Leao", Categoria.OURO));
        bruno.perderVida(10);
        assertEquals(90.0, bruno.getVida(), 0.01);
    }
    
    @Test
    public void testeDePerderVidaComValor90()throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", new Armadura("Leao", Categoria.OURO));
        bruno.perderVida(90);
        assertEquals(10, bruno.getVida(), 0.01);
    }
    
    @Test
    public void testeDePerderVidaComValor1000()throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", new Armadura("Leao", Categoria.OURO));
        bruno.perderVida(1000);
        assertEquals(Status.MORTO, bruno.getStatus());
    }
    
    @Test
    public void testeDePerderVidaComValorMenos1000()throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", new Armadura("Leao", Categoria.OURO));
        bruno.perderVida(-1000);
        assertEquals(1100, bruno.getVida(), 0.01);
    }
    
    @Test
    public void aoCriarOSaintBronzeEleNasceCom5SentidosDespertados()throws Exception {
         BronzeSaint bruno = new BronzeSaint("Bruno", new Armadura("Leao", Categoria.BRONZE));
         assertEquals(5, bruno.getSentidosDespertados());
    }
    
    @Test
    public void aoCriarOSaintPrataEleNasceCom6SentidosDespertados() throws Exception{
         SilverSaint bruno = new SilverSaint("Bruno", new Armadura("Leao", Categoria.PRATA));
         assertEquals(6, bruno.getSentidosDespertados());
    }
    
    @Test
    public void aoCriarOSaintOuroEleNasceCom7SentidosDespertados() throws Exception{
         GoldSaint bruno = new GoldSaint("Bruno", new Armadura("Leao", Categoria.OURO));
         assertEquals(7, bruno.getSentidosDespertados());
    }
    
    @Test
    public void aoFicarComVida0StatusMudaParaMorto() throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", new Armadura("Leao", Categoria.OURO));
        bruno.perderVida(101);
        assertEquals(Status.MORTO, bruno.getStatus());
    }
}













