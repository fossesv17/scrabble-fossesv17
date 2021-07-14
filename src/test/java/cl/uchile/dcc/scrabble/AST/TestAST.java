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
    private IStype SS;
    private IStype SI;
    private IStype SF;
    private IStype SB;
    private IStype SBL;

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
        var f = new Add(SB.toInt(),SI);
        var fac = f.eval();

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

    @Test
    void DivTest(){
        var a = new Div(SI,SI);
        var aac = a.eval();
        var aex = new SInt(1);
        assertEquals(aex,aac);
        var b = new Div(SF,SI);
        var bac = b.eval();
        var bex = new SFloat(1.0);
        assertEquals(bex,bac);
        var c = new Div(SS,SI);
        assertNull(c.eval());
    }

    @Test
    void AndTest(){
        var a = new And(SBL,SBL);
        var aac = a.eval();
        var aex = new SBool(true);
        assertEquals(aex,aac);
        var b = new And(SBL,new SBool(false));
        var bac = b.eval();
        var bex = new SBool(false);
        assertEquals(bex,bac);
        var c = new And(SS,SF);
        assertNull(c.eval());
    }

    @Test
    void OrTest(){
        var a = new Or(SBL,SBL);
        var aac = a.eval();
        var aex = new SBool(true);
        assertEquals(aex,aac);
        var b = new Or(SBL, new SBool(false));
        var bac = b.eval();
        var bex = new SBool(true);
        assertEquals(bex,bac);
        var c = new Or(SS,SF);
        assertNull(c.eval());
    }

    @Test
    void NegTest(){
        var a = new Neg(SBL);
        var aac = a.eval();
        var aex = new SBool(false);
        assertEquals(aex,aac);
        var b = new Neg(SB);
        var bac = b.eval();
        var bex = new SBin("101");
        assertEquals(bex,bac);
        var c = new Neg(SS);
        assertNull(c.eval());
    }

    @Test
    void CombinedOpTest(){
        var a = new Add(new Sub(new SBin("1010").neg().toInt(),new SInt(1)),new SInt(10));
        var aac = a.eval();
        var aex = new SInt(14);
        assertEquals(aex,aac);
        var b = new Add(SBL,new Mul(SS,SF));
        assertNull(b.eval());
    }
}
