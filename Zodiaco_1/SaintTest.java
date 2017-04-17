import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    @Test
    public void vestirArmaduraDeixaArmaduraVestida(){
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Armadura illuminati = new Armadura("Illuminati", Categoria.OURO);
        Saint alcemar = new Saint("Alcemar", illuminati);        
        // 2. Act - Invocar a ação a ser testada
        alcemar.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = alcemar.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    @Test
    public void aoCriarSaintGeneroENaoInformado() {
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    @Test
    public void aoCriaSaintStatusVivo() {
        Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.OURO));
        assertEquals(Status.VIVO, bruno.getStatus());
    }
    @Test
    public void vidaInicialDeveSer100() {
        Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.OURO));
        assertEquals(100.0, bruno.getVida(), 0.01);
    }
    @Test
    public void testeDePerderVidaComValor10(){
        Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.OURO));
        bruno.perderVida(10);
        assertEquals(90.0, bruno.getVida(), 0.01);
    }
    
    @Test
    public void testeDePerderVidaComValor100(){
        Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.OURO));
        bruno.perderVida(100);
        assertEquals(0, bruno.getVida(), 0.01);
    }
    
    @Test
    public void testeDePerderVidaComValor1000(){
        Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.OURO));
        bruno.perderVida(1000);
        assertEquals(-900, bruno.getVida(), 0.01);
    }
    
    @Test
    public void testeDePerderVidaComValorMenos1000(){
        Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.OURO));
        bruno.perderVida(-1000);
        assertEquals(1100, bruno.getVida(), 0.01);
    }
    
    @Test
    public void aoCriarOSaintBronzeEleNasceCom5SentidosDespertados() {
         Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.BRONZE));
         assertEquals(5, bruno.getSentidosDespertados());
    }
    
    @Test
    public void aoCriarOSaintPrataEleNasceCom6SentidosDespertados() {
         Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.PRATA));
         assertEquals(6, bruno.getSentidosDespertados());
    }
    
    @Test
    public void aoCriarOSaintOuroEleNasceCom7SentidosDespertados() {
         Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.OURO));
         assertEquals(7, bruno.getSentidosDespertados());
    }
}













