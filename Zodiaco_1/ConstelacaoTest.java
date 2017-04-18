import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.lang.ArrayIndexOutOfBoundsException;

public class ConstelacaoTest
{
    @Test
    public void adidionarUmGolpe(){
        Constelacao gemeos = new Constelacao("Gemeos");
        Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
        gemeos.adicionarGolpe(outraDimensao);
        Golpe[] golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes[0]);
        assertNull(golpes[1]);
        assertNull(golpes[2]);
    }
    @Test
    public void adicionarDoisGolpes(){
        Constelacao gemeos = new Constelacao("Gemeos");
        Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
        Golpe gremio = new Golpe("Gremio", 13);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(gremio);
        Golpe[] golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes[0]);
        assertEquals(gremio, golpes[1]);
        assertNull(golpes[2]);
    
    }
    @Test
    public void adicionarTresolpes() {
        Constelacao gemeos = new Constelacao("Gemeos");
        Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
        Golpe gremio = new Golpe("Gremio", 13);
        Golpe inter = new Golpe("Inter", 1);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(gremio);
        gemeos.adicionarGolpe(inter);
        Golpe[] golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes[0]);
        assertEquals(gremio, golpes[1]);
        assertEquals(inter, golpes[2]);        
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void adicionarQuatroGolpes() {
        Constelacao gemeos = new Constelacao("Gemeos");
        Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
        Golpe gremio = new Golpe("Gremio", 13);
        Golpe inter = new Golpe("Inter", 1);
        Golpe cafe = new Golpe("cafe", 30);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(gremio);
        gemeos.adicionarGolpe(inter);
        gemeos.adicionarGolpe(cafe);
        Golpe[] golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes[0]);
        assertEquals(gremio, golpes[1]);
        assertEquals(inter, golpes[2]);
        assertEquals(cafe, golpes[3]);
    }
}