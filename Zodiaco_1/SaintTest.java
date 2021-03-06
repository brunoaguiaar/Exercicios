import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest {
    
    @After
    public void tearDown(){
        System.gc();
    }
    
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Armadura illuminati = new Armadura(new Constelacao("Touro"), Categoria.OURO);
        GoldSaint alcemar = new GoldSaint("Alcemar", "Touro");        
        // 2. Act - Invocar a ação a ser testada
        alcemar.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = alcemar.getArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception{
        BronzeSaint hyoga = new BronzeSaint("Hyoga", "Touro");
        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado()throws Exception {
        GoldSaint shaka = new GoldSaint("Shaka", "Touro");
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void aoCriaSaintStatusVivo()throws Exception {
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        assertEquals(Status.VIVO, bruno.getStatus());
    }

    @Test
    public void vidaInicialDeveSer100()throws Exception {
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        assertEquals(100.0, bruno.getVida(), 0.01);
    }

    @Test
    public void testeDePerderVidaComValor10()throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        bruno.perderVida(10);
        assertEquals(90.0, bruno.getVida(), 0.01);
    }

    @Test
    public void testeDePerderVidaComValor90()throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        bruno.perderVida(90);
        assertEquals(10, bruno.getVida(), 0.01);
    }

    @Test
    public void testeDePerderVidaComValor1000()throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        bruno.perderVida(1000);
        assertEquals(Status.MORTO, bruno.getStatus());
    }

    @Test(expected=InvalidParameterException.class)
    public void testeDePerderVidaComValorMenos2000()throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        bruno.perderVida(-2000);
        assertEquals(1900, bruno.getVida(), 0.01);
    }

    @Test
    public void aoCriarOSaintBronzeEleNasceCom5SentidosDespertados()throws Exception {
        BronzeSaint bruno = new BronzeSaint("Bruno", "Touro");
        assertEquals(5, bruno.getSentidosDespertados());
    }

    @Test
    public void aoCriarOSaintPrataEleNasceCom6SentidosDespertados() throws Exception{
        SilverSaint bruno = new SilverSaint("Bruno", "Touro");
        assertEquals(6, bruno.getSentidosDespertados());
    }

    @Test
    public void aoCriarOSaintOuroEleNasceCom7SentidosDespertados() throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        assertEquals(7, bruno.getSentidosDespertados());
    }

    @Test
    public void aoFicarComVida0StatusMudaParaMorto() throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        bruno.perderVida(101);
        assertEquals(Status.MORTO, bruno.getStatus());
    }

    @Test
    public void verificaSeOProximoGolpeÉOProximoMesmo() throws Exception {
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        Golpe soco = new Golpe("Soco", 5);
        Golpe chute = new Golpe("voadora", 10);
        Golpe cotovelada = new Golpe("cotovelada", 3);
        Golpe shape = new Golpe("shape", 8);
        bruno.aprenderGolpe(soco);             
        assertEquals(soco, bruno.getProximoGolpe());
        bruno.aprenderGolpe(chute);
        assertEquals(chute, bruno.getProximoGolpe());
        bruno.aprenderGolpe(cotovelada);
        assertEquals(cotovelada, bruno.getProximoGolpe());
        bruno.aprenderGolpe(shape);             
        assertEquals(shape, bruno.getProximoGolpe());
        assertEquals(soco, bruno.getProximoGolpe());
    }
    
    @Test
    public void criarUmSaintIncrementaId() throws Exception{
        //getAcumuladorId
        int idAntes = Saint.getAcumuladorId();
        assertEquals(idAntes + 1, new GoldSaint("Bruno", "Touro").getId());
    }
    
    @Test
    public void criarDoisSaintIncrementaId() throws Exception{
        //getAcumuladorId
        int idAntes = Saint.getAcumuladorId();
        new GoldSaint("Bruno", "Touro");
        Saint fabi = new GoldSaint("Fabi", "Touro");
        assertEquals(idAntes + 2, fabi.getId());
    }
    
    @Test
    public void criarTresSaintIncrementaId() throws Exception{
        //getAcumuladorId
        int idAntes = Saint.getAcumuladorId();
        new GoldSaint("Bruno", "Touro");
        Saint fabi = new GoldSaint("Fabi", "Touro");
        Saint odin = new GoldSaint("Odin", "Touro");
        assertEquals(idAntes + 3, odin.getId());
    }
    
    @Test
    public void criarUmSaintEDepoisLimparEDeveIncrementaId() throws Exception{
        //getAcumuladorId
        int idAntes = Saint.getAcumuladorId();
        Saint fabi = new GoldSaint("Fabi", "Touro");
        fabi = (null);
        System.gc();
        Saint odin = new GoldSaint("Odin", "Touro");
        assertEquals(idAntes + 2, odin.getId());
    }
}




