import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SorteDoDiaTest{
    @Test
    public void jogarODadoEOResultadoSerVerdadeiro(){
        SorteDoDia sorte = new SorteDoDia(new DadoD6());
        boolean sortudo = false;
        
        for (int i=0; i < 100; i++){
            if (sorte.estouComSorte() == true){
                sortudo = true;
            } else {
                sortudo = false;
            }
        }
        
        assertEquals(true, sortudo);
    }
}
