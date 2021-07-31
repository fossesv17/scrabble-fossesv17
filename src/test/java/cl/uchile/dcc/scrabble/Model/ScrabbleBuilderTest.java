package cl.uchile.dcc.scrabble.Model;

import cl.uchile.dcc.scrabble.Model.Builder.ScrabbleBuilder;
import cl.uchile.dcc.scrabble.Model.Tipos.Logical.SBool;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SBin;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SFloat;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SInt;
import cl.uchile.dcc.scrabble.Model.Tipos.SString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScrabbleBuilderTest {
    private ScrabbleBuilder SB = new ScrabbleBuilder();

    @Test
    void SBTest(){
        SB.createSBin("01");
        SB.createSBool(true);
        SB.createSFloat(1.0);
        SB.createSInt(1);
        SB.createSString("wena");
        var cache = SB.getCache();
        assertEquals(new SBin("01"),cache.get("01B"));
        assertEquals(new SFloat(1.0),cache.get("1.0F"));
        assertEquals(new SInt(1),cache.get("1I"));
        assertEquals(new SBool(true),cache.get("trueBL"));
        assertEquals(new SString("wena"),cache.get("wenaS"));
        assertNull(cache.get("20F"));
    }
}
