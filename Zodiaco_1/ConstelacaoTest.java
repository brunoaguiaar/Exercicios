import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.lang.ArrayIndexOutOfBoundsException;

public class ConstelacaoTest
{
    @Test
    public void adidionarUmGolpe(){
        Constelacao gemeos = new Constelacao("Gemeos");
        Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
        gemeos.adicionarGolpe(outraDimensao);
        ArrayList <Golpe> golpes = gemeos.getGolpes();
        assertEquals(golpes.get(0), new Golpe("Outra Dimensao", 10));
    }

    @Test
    public void adicionarDoisGolpes(){
        Constelacao gemeos = new Constelacao("Gemeos");
        Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
        Golpe gremio = new Golpe("Gremio", 13);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(gremio);
        ArrayList <Golpe> golpes = gemeos.getGolpes();
        assertEquals(golpes.get(0), new Golpe("Outra Dimensao", 10));
        assertEquals(golpes.get(1), new Golpe("Gremio", 13));
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
        ArrayList <Golpe> golpes = gemeos.getGolpes();
        assertEquals(golpes.get(0), new Golpe("Outra Dimensao", 10));
        assertEquals(golpes.get(1), new Golpe("Gremio", 13));
        assertEquals(golpes.get(2), new Golpe("Inter", 1));
    }

    @Test
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
        ArrayList <Golpe> golpes = gemeos.getGolpes();
        assertEquals(golpes.get(0), new Golpe("Outra Dimensao", 10));
        assertEquals(golpes.get(1), new Golpe("Gremio", 13));
        assertEquals(golpes.get(2), new Golpe("Inter", 1));
        assertEquals(golpes.get(3), new Golpe("cafe", 30));
    }
}