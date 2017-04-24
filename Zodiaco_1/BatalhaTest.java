
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
    @Test
    public void categoriaDesafiadoMaiorQueDefafiante()throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", new Armadura(new Constelacao("Leao"), Categoria.OURO));
        SilverSaint shaka = new SilverSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        Batalha batalha = new Batalha(bruno, shaka);

        batalha.iniciar();

        assertEquals(100, bruno.getVida(), 0.01);
        assertEquals(90, shaka.getVida(), 0.01);
    }

    @Test
    public void categoriaDesafianteMaiorQueDesafiado() throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", new Armadura(new Constelacao("Leao"), Categoria.OURO));
        SilverSaint shaka = new SilverSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        Batalha batalha = new Batalha(bruno, shaka);

        batalha.iniciar();

        assertEquals(100, bruno.getVida(), 0.01);
        assertEquals(90, shaka.getVida(), 0.01);
    }

    @Test
    public void categoriaDesafianteIgualODesafiado()throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", new Armadura(new Constelacao("Leao"), Categoria.OURO));
        SilverSaint shaka = new SilverSaint("Shaka", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        Batalha batalha = new Batalha(bruno, shaka);

        batalha.iniciar();

        assertEquals(100, bruno.getVida(), 0.01);
        assertEquals(90, shaka.getVida(), 0.01);
    }
}
