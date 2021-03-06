package cl.uchile.dcc.scrabble.Model.AST;

import cl.uchile.dcc.scrabble.Model.Tipos.IStype;
import cl.uchile.dcc.scrabble.Model.Tipos.Logical.SBool;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SBin;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SFloat;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SInt;
import cl.uchile.dcc.scrabble.Model.Tipos.SString;
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
    void transOnTreesTest(){
        var a = new Add(new SBin("01"),new SBin("01")).toInt();
        var aexp = new SInt(2);
        assertEquals(aexp,a);
        var b = new Add(new SFloat(1.0),new SInt(1)).toBool();
        assertNull(b);
        var c = new Sub(new Add(SI,SF).toBool(),SI);
        assertNull(c.eval());
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
        var f = new Add(new Add(SBL,SS),SBL);
        assertNull(f.eval());
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
        var d = new Sub(new Sub(SBL,SS),SS);
        assertNull(d.eval());
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
        var d = new Mul(SBL,new Mul(SS,SB));
        assertNull(d.eval());
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
        var d = new Div(new Div(SS,SBL),SB);
        assertNull(d.eval());
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
        var d = new And(new And(SF,SI),new SBool(true));
        assertNull(d.eval());
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
        var d = new Or(new Or(SF,SI),SF);
        assertNull(d.eval());
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
        var d = new Neg(new Add(SBL,SS));
        assertNull(d.eval());
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

    @Test
    void getNullOperandsTest(){
        var a = new Add();
        var b = new Add();
        var c = new Add(SI,SB);
        var d = new Neg();
        var e = new Neg(SBL);
        b.addVar(SI);
        assertEquals(2,a.getNullOperands());
        assertEquals(1,b.getNullOperands());
        assertEquals(0,c.getNullOperands());
        assertEquals(1,d.getNullOperands());
        assertEquals(0,e.getNullOperands());
    }
}
