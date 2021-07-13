package cl.uchile.dcc.scrabble.Tipos;

import cl.uchile.dcc.scrabble.Tipos.Logical.SBool;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SBin;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SFloat;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SStringTest {
    private SString sStringMt;
    private SString sString;

    @BeforeEach
    void setUp(){
        sStringMt = new SString();
        sString = new SString("hola");
    }
    @Test
    void EmptyConstructorTest(){
        var expectedSString = new SString();
        assertEquals(expectedSString,sStringMt,"awebo no son iwales");
        assertEquals(expectedSString.hashCode(),sStringMt.hashCode(),"Hashes don't match");
    }
    @Test
    void ConstructorTest(){
        var expectedSString = new SString("hola");
        var diffSString = new SString("ola");
        assertEquals(expectedSString,sString);
        assertEquals(expectedSString.hashCode(),sString.hashCode());
        assertNotEquals(diffSString,sString);
        assertNotEquals(diffSString.hashCode(),sString.hashCode());
    }
    @Test
    void StoStringTest(){
        var result = sString.StoString();
        var expectedSString = new SString("hola");
        var diffSString = new SString("ola");
        assertEquals(expectedSString,result);
        assertEquals(expectedSString.hashCode(),result.hashCode());
        assertNotEquals(diffSString,result);
        assertNotEquals(diffSString.hashCode(),result.hashCode());
    }
    @Test
    void StringSumTest(){
        //Concatenation with an SString
        var concatSString = new SString(" mundo");
        var result = sString.Suma(concatSString);
        var expectedSString = new SString("hola mundo");
        assertEquals(expectedSString,result);
        assertEquals(expectedSString.hashCode(),result.hashCode());
        assertNotEquals(concatSString,result);
        assertNotEquals(concatSString.hashCode(),result.hashCode());
        //Concatenation with every other type
        IStype[] con = {new SFloat(1.5),new SBin("101"),new SInt(2), new SBool(true)};
        for (int i=0;i<con.length;i++){
            var res = sString.Suma(con[i]);
            var expectedSS = new SString(sString.getString().concat(con[i].StoString().getString()));
            assertEquals(expectedSS,res);
            assertEquals(expectedSS.hashCode(),res.hashCode());
        }
    }
}
