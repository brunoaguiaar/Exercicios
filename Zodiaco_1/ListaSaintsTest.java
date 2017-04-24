import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
    @Test
    public void adicionarSaintNaLista () throws Exception {
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        GoldSaint izadora = new GoldSaint("Izadora", "Touro");
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
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        GoldSaint izadora = new GoldSaint("Izadora", "Touro");
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
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi","Touro");
        GoldSaint izadora = new GoldSaint("Izadora", "Touro");
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(bruno);
        listaSaints.adicionar(fabi);
        listaSaints.adicionar(izadora);
        Saint saint = listaSaints.buscarPorNome ("Fabi");
        assertEquals(saint, fabi);
    }

    @Test
    public void retornarOPrimeiroSaintComNome () throws Exception {
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        GoldSaint izadora = new GoldSaint("Izadora", "Touro");
        GoldSaint izadora2 = new GoldSaint("Izadora", "Touro");
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
        SilverSaint bruno = new SilverSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        SilverSaint izadora = new SilverSaint("Izadora", "Touro");
        GoldSaint lucas = new GoldSaint("Lucas", "Touro");
        SilverSaint paulo = new SilverSaint("Paulo", "Touro");
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
        SilverSaint bruno = new SilverSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        SilverSaint izadora = new SilverSaint("Izadora", "Touro");
        GoldSaint lucas = new GoldSaint("Lucas", "Touro");
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
        SilverSaint bruno = new SilverSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        SilverSaint izadora = new SilverSaint("Izadora", "Touro");
        GoldSaint lucas = new GoldSaint("Lucas", "Touro");
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

    @Test
    public void ordenarOrdenaOsElementosEmOrdemAscendenteDeVida () throws Exception {
        SilverSaint bruno = new SilverSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        SilverSaint izadora = new SilverSaint("Izadora", "Touro");
        GoldSaint lucas = new GoldSaint("Lucas", "Touro");
        ListaSaints listaSaints = new ListaSaints();
        bruno.perderVida(15.0);//2
        fabi.perderVida(80.0);//4
        izadora.perderVida(50.0);//3
        lucas.perderVida(5.0);//1
        listaSaints.adicionar(bruno);
        listaSaints.adicionar(fabi);
        listaSaints.adicionar(izadora);
        listaSaints.adicionar(lucas);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(listaSaints.get(0), fabi);
        assertEquals(listaSaints.get(1), izadora);
        assertEquals(listaSaints.get(2), bruno);
        assertEquals(listaSaints.get(3), lucas);
    }

    @Test
    public void tipoOrdenacaoAscendenteOrdenaAscendente() throws Exception {
        SilverSaint bruno = new SilverSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        SilverSaint izadora = new SilverSaint("Izadora", "Touro");
        GoldSaint lucas = new GoldSaint("Lucas", "Touro");
        ListaSaints listaSaints = new ListaSaints();
        bruno.perderVida(15.0);//3
        fabi.perderVida(80.0);//1
        izadora.perderVida(50.0);//2
        lucas.perderVida(5.0);//4
        listaSaints.adicionar(bruno);
        listaSaints.adicionar(fabi);
        listaSaints.adicionar(izadora);
        listaSaints.adicionar(lucas);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(listaSaints.get(0), fabi);
        assertEquals(listaSaints.get(1), izadora);
        assertEquals(listaSaints.get(2), bruno);
        assertEquals(listaSaints.get(3), lucas);
    }

    @Test
    public void tipoOrdenacaoDescendenteOrdenaDescendente() throws Exception {
        SilverSaint bruno = new SilverSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        SilverSaint izadora = new SilverSaint("Izadora", "Touro");
        GoldSaint lucas = new GoldSaint("Lucas", "Touro");
        ListaSaints listaSaints = new ListaSaints();
        bruno.perderVida(15.0);//2
        fabi.perderVida(80.0);//4
        izadora.perderVida(50.0);//3
        lucas.perderVida(5.0);//1
        listaSaints.adicionar(bruno);
        listaSaints.adicionar(fabi);
        listaSaints.adicionar(izadora);
        listaSaints.adicionar(lucas);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(listaSaints.get(0), lucas);
        assertEquals(listaSaints.get(1), bruno);
        assertEquals(listaSaints.get(2), izadora);
        assertEquals(listaSaints.get(3), fabi);
    }
    
    @Test
    public void unirListasComUMSaint() throws Exception {
        SilverSaint bruno = new SilverSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        ListaSaints lista1 = new ListaSaints();
        lista1.adicionar(bruno);
        ListaSaints lista2 = new ListaSaints();
        lista2.adicionar(fabi);
        ListaSaints novaLista = lista1.unir(lista2);
        assertEquals(2, novaLista.todos().size());
        assertEquals(bruno, novaLista.get(0));
        assertEquals(fabi, novaLista.get(1));
    }

    @Test
    public void unirListasComDoisSaint() throws Exception {
        SilverSaint bruno = new SilverSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        SilverSaint izadora = new SilverSaint("Izadora", "Touro");
        GoldSaint lucas = new GoldSaint("Lucas", "Touro");
        ListaSaints lista1 = new ListaSaints();
        lista1.adicionar(bruno);
        lista1.adicionar(izadora);
        ListaSaints lista2 = new ListaSaints();
        lista2.adicionar(fabi);
        lista2.adicionar(lucas);
        ListaSaints novaLista = lista1.unir(lista2);
        assertEquals(4, novaLista.todos().size());
        assertEquals(bruno, novaLista.get(0));
        assertEquals(izadora, novaLista.get(1));
        assertEquals(fabi, novaLista.get(2));
        assertEquals(lucas, novaLista.get(3));
    }
    
    @Test
    public void diffListasComSaintIgual() throws Exception {
        SilverSaint bruno = new SilverSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        SilverSaint izadora = new SilverSaint("Izadora", "Touro");
        ListaSaints lista1 = new ListaSaints();
        lista1.adicionar(bruno);
        lista1.adicionar(fabi);
        ListaSaints lista2 = new ListaSaints();
        lista2.adicionar(bruno);
        lista1.adicionar(izadora);
        ListaSaints novaLista = lista1.diff(lista2);
        assertEquals(2, novaLista.todos().size());
        assertEquals(fabi, novaLista.get(0));
        assertEquals(izadora, novaLista.get(1));
    }
    
    @Test
    public void intersecListasComSaintIgual() throws Exception {
        SilverSaint bruno = new SilverSaint("Bruno", "Touro");
        GoldSaint fabi = new GoldSaint("Fabi", "Touro");
        SilverSaint izadora = new SilverSaint("Izadora", "Touro");
        ListaSaints lista1 = new ListaSaints();
        lista1.adicionar(bruno);
        lista1.adicionar(fabi);
        ListaSaints lista2 = new ListaSaints();
        lista2.adicionar(bruno);
        lista1.adicionar(izadora);
        ListaSaints novaLista = lista1.intersec(lista2);
        assertEquals(1, novaLista.todos().size());
        assertEquals(bruno, novaLista.get(0));
    }
}