package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;
import cl.uchile.dcc.scrabble.Tipos.Logical.SBool;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SBin;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SFloat;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SInt;
import cl.uchile.dcc.scrabble.Tipos.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestAST {
    private AST SS;
    private AST SI;
    private AST SF;
    private AST SB;
    private AST SBL;

    @BeforeEach
    void setUp(){
        SS = new SString("hola");
        SI = new SInt(2);
        SF = new SFloat(2.0);
        SB = new SBin("010");
        SBL = new SBool(true);
    }

    @Test
    void addTest(){
        var a = new Add(SI,SF);
        var aactual = a.eval();
        var aexpected = new SFloat(4.0);
        assertEquals(aexpected,aactual);
        var b = new Add(SS,SS);
        var bactual = b.eval();
        var bexpected = new SString("holahola");
        assertEquals(bexpected,bactual);
        var c = new Add(SI,SS);
        assertNull(c.eval());
        var d = new Add(SBL,SF);
        assertNull(d.eval());
        var e = new Add(SB,SF);
        assertNull(e.eval());
    }
    @Test
    void subTest(){
        var a = new Sub(new SInt(2),new SInt(1));
        var aactual = a.eval();
        var aexpected = new SInt(1);
        assertEquals(aexpected,aactual);
        var b = new Sub(SI,new SFloat(1.0));
        var bactual = b.eval();
        var bexpected = new SFloat(1.0);
        assertEquals(bexpected,bactual);
        var c = new Sub(SS,SI);
        assertNull(c.eval());
    }

    @Test
    void MulTest(){
        var a = new Mul(SI,SI);
        var aac = a.eval();
        var aex = new SInt(4);
        assertEquals(aex,aac);
        var b = new Mul(SF,SI);
        var bac = b.eval();
        var bex = new SFloat(4.0);
        assertEquals(bex,bac);
        var c = new Mul(SS,SF);
        assertNull(c.eval());
    }
}
