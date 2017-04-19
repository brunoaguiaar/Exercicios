import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
    @Test
    public void adicionarSaintNaLista () throws Exception {
        Saint bruno = new Saint("Bruno", new Armadura(new Constelacao("Leao"), Categoria.OURO));
        Saint fabi = new Saint("Fabi", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint izadora = new Saint("Izadora", new Armadura(new Constelacao("Gemeos"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(bruno);
        listaSaints.adicionar(fabi);
        listaSaints.adicionar(izadora);
        assertEquals(listaSaints.get(0), bruno);
        assertEquals(listaSaints.get(1), fabi);
        assertEquals(listaSaints.get(2), izadora);
    }
    
    @Test
    public void tirarSaintDaLista () throws Exception {
        Saint bruno = new Saint("Bruno", new Armadura(new Constelacao("Leao"), Categoria.OURO));
        Saint fabi = new Saint("Fabi", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint izadora = new Saint("Izadora", new Armadura(new Constelacao("Gemeos"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(bruno);
        listaSaints.adicionar(fabi);
        listaSaints.adicionar(izadora);
        listaSaints.remove(fabi);
        assertEquals(listaSaints.get(0), bruno);
        assertEquals(listaSaints.get(1), izadora);
    }
    
    @Test
    public void retornarSaintComNome () throws Exception {
        Saint bruno = new Saint("Bruno", new Armadura(new Constelacao("Leao"), Categoria.OURO));
        Saint fabi = new Saint("Fabi", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint izadora = new Saint("Izadora", new Armadura(new Constelacao("Gemeos"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(bruno);
        listaSaints.adicionar(fabi);
        listaSaints.adicionar(izadora);
        Saint saint = listaSaints.buscarPorNome ("Fabi");
        assertEquals(saint, fabi);
    }
    
    @Test
    public void retornarOPrimeiroSaintComNome () throws Exception {
        Saint bruno = new Saint("Bruno", new Armadura(new Constelacao("Leao"), Categoria.OURO));
        Saint fabi = new Saint("Fabi", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint izadora = new Saint("Izadora", new Armadura(new Constelacao("Gemeos"), Categoria.OURO));
        Saint izadora2 = new Saint("Izadora", new Armadura(new Constelacao("Gemeos"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(bruno);
        listaSaints.adicionar(fabi);
        listaSaints.adicionar(izadora);
        listaSaints.adicionar(izadora2);
        Saint saint = listaSaints.buscarPorNome ("Izadora");
        assertEquals(saint, izadora);
    }
    
    @Test
    public void buscarPorCategoriaPrata () throws Exception {
        Saint bruno = new Saint("Bruno", new Armadura(new Constelacao("Leao"), Categoria.PRATA));
        Saint fabi = new Saint("Fabi", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint izadora = new Saint("Izadora", new Armadura(new Constelacao("Gemeos"), Categoria.PRATA));
        Saint lucas = new Saint("Lucas", new Armadura(new Constelacao("Gemeos"), Categoria.OURO));
        Saint paulo = new Saint("Paulo", new Armadura(new Constelacao("Libra"), Categoria.PRATA));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(bruno);
        listaSaints.adicionar(fabi);
        listaSaints.adicionar(izadora);
        listaSaints.adicionar(paulo);
        ArrayList<Saint> goldSaints = listaSaints.buscarPorCategoria (Categoria.PRATA);
        assertEquals(goldSaints.get(0), bruno);
        assertEquals(goldSaints.get(1), izadora);
        assertEquals(goldSaints.get(2), paulo);
    }
    
    @Test
    public void getSaintMaiorVidaRetornaSaintMaiorDeVida () throws Exception {
        Saint bruno = new Saint("Bruno", new Armadura(new Constelacao("Leao"), Categoria.PRATA));
        Saint fabi = new Saint("Fabi", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint izadora = new Saint("Izadora", new Armadura(new Constelacao("Gemeos"), Categoria.PRATA));
        Saint lucas = new Saint("Lucas", new Armadura(new Constelacao("Gemeos"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(bruno);
        listaSaints.adicionar(fabi);
        listaSaints.adicionar(izadora);
        listaSaints.adicionar(lucas);
        bruno.perderVida(15.0);
        fabi.perderVida(80.0);
        izadora.perderVida(50.0);
        lucas.perderVida(5.0);
        assertEquals(listaSaints.getSaintMaiorVida(), lucas);
    }
    
    @Test
    public void getSaintMenorVidaRetornaSaintMenorDeVida () throws Exception {
        Saint bruno = new Saint("Bruno", new Armadura(new Constelacao("Leao"), Categoria.PRATA));
        Saint fabi = new Saint("Fabi", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Saint izadora = new Saint("Izadora", new Armadura(new Constelacao("Gemeos"), Categoria.PRATA));
        Saint lucas = new Saint("Lucas", new Armadura(new Constelacao("Gemeos"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(bruno);
        listaSaints.adicionar(fabi);
        listaSaints.adicionar(izadora);
        listaSaints.adicionar(lucas);
        bruno.perderVida(15.0);
        fabi.perderVida(80.0);
        izadora.perderVida(50.0);
        lucas.perderVida(5.0);
        assertEquals(listaSaints.getSaintMenorVida(), fabi);
    }
    
   
}