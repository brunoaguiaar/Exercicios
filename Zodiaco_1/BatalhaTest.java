

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
    @Test
    public void categoriaDesafiadoMaiorQueDefafiante(){
        Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.OURO));
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.PRATA));
        Batalha batalha = new Batalha(bruno, shaka);
        
        batalha.iniciar();
        
        assertEquals(100, bruno.getVida(), 0.01);
        assertEquals(90, shaka.getVida(), 0.01);
    }
    
    @Test
    public void categoriaDesafianteMaiorQueDefafiado(){
        Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.BRONZE));
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.PRATA));
        Batalha batalha = new Batalha(bruno, shaka);
        
        batalha.iniciar();
        
        assertEquals(90, bruno.getVida(), 0.01);
        assertEquals(100, shaka.getVida(), 0.01);
    }
    
    @Test
    public void categoriaDesafianteIgualODefafiado(){
        Saint bruno = new Saint("Bruno", new Armadura("Leao", Categoria.PRATA));
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.PRATA));
        Batalha batalha = new Batalha(bruno, shaka);
        
        batalha.iniciar();
        
        assertEquals(100, bruno.getVida(), 0.01);
        assertEquals(90, shaka.getVida(), 0.01);
    }
}
