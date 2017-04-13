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
}
