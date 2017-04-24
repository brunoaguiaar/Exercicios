import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest{
    @Test
    public void vestirArmadura() throws Exception{
        GoldSaint bruno = new GoldSaint("Bruno", "Touro");
        Movimento movimento = new VestirArmadura(bruno);
        movimento.executar();
        assertTrue(bruno.getArmaduraVestida());
    }
}
