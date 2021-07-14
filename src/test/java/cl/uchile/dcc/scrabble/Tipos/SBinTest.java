package cl.uchile.dcc.scrabble.Tipos;

import cl.uchile.dcc.scrabble.Tipos.Logical.ISLogic;
import cl.uchile.dcc.scrabble.Tipos.Logical.SBool;
import cl.uchile.dcc.scrabble.Tipos.Numbers.ISNum;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SBin;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SFloat;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SBinTest {
    private SBin sbinMt;
    private SBin sbin;

    @BeforeEach
    void setup(){
        sbinMt=new SBin();
        sbin = new SBin("0101");
    }

    @Test
    void emptyConstructorTest(){
        var bin = new SBin();
        assertEquals(bin,sbinMt);
        assertEquals(bin.hashCode(),sbinMt.hashCode());
        assertNotEquals(sbin,sbinMt);
        assertNotEquals(sbin.hashCode(),sbinMt.hashCode());
    }

    @Test
    void constructorTest(){
        var bin1 = new SBin("0101");
        var bin2 = new SBin("010");
        assertEquals(bin1,sbin);
        assertEquals(bin1.hashCode(),sbin.hashCode());
        assertNotEquals(bin2,sbin);
        assertNotEquals(bin2.hashCode(),sbin.hashCode());
    }



    @Test
    void TransformationTest(){
        //StoString Transformation
        var StoStringRes = sbin.StoString();
        var expected = new SString("0101");
        assertEquals(expected,StoStringRes);
        assertEquals(expected.hashCode(),StoStringRes.hashCode());
        //transformation to Num types
        ISNum[] trans = {sbin.toBin(),sbin.toInt(),sbin.toFloat()};
        ISNum[] expec = {new SBin("0101"),new SInt(5),new SFloat(5.0)};
        for (int i=0;i<trans.length;i++){
            assertEquals(expec[i],trans[i]);
            assertEquals(expec[i].hashCode(),trans[i].hashCode());
        }
    }

    @Test
    void NegTest(){
        var binN = new SBin("010");
        var NegBin = binN.neg();
        var exp = new SBin("101");
        assertEquals(exp, NegBin);
    }
    @Test
    void OperationsTest(){
        //logical op
        ISLogic[] lop = {new SBool(false),new SBin("0110")};
        ISLogic[] andExp = {new SBin("0000"),new SBin("0100")};
        ISLogic[] orExp = {new SBin("0101"),new SBin("0111")};
        for (int i=0;i<lop.length;i++){
            var andRes = sbin.and(lop[i]);
            var orRes = sbin.or(lop[i]);
            assertEquals(andExp[i],andRes);
            assertEquals(andExp[i].hashCode(),andRes.hashCode());
            assertEquals(orExp[i],orRes);
            assertEquals(orExp[i].hashCode(),orRes.hashCode());
        }
        //num op

        ISNum[] aop = {new SBin("01"),new SInt(2)};
        ISNum[] sumExp = {new SBin("0110"),new SBin("0111")};
        ISNum[] subExp = {new SBin("0100"),new SBin("011")};
        ISNum[] mulExp = {new SBin("0101"),new SBin("01010")};
        ISNum[] divExp = {new SBin("0101"),new SBin("010")};
        var opFloat = new SFloat(1.0);
        IStype[] binWithFloatOp = {sbin.Suma(opFloat),sbin.Resta(opFloat),sbin.Multi(opFloat),sbin.Divn(opFloat)};
        for (IStype num : binWithFloatOp) {
            assertNull(num);
        }
        for (int i=0;i< aop.length;i++){
            var sumRes = sbin.Suma(aop[i]);
            var subRes = sbin.Resta(aop[i]);
            var mulRes = sbin.Multi(aop[i]);
            var divRes = sbin.Divn(aop[i]);
            //suma asserts
            assertEquals(sumExp[i],sumRes);
            assertEquals(sumExp[i].hashCode(),sumRes.hashCode());
            //resta asserts
            assertEquals(subExp[i],subRes);
            assertEquals(subExp[i].hashCode(),subRes.hashCode());
            //multi asserts
            assertEquals(mulExp[i],mulRes);
            assertEquals(mulExp[i].hashCode(),mulRes.hashCode());
            //div asserts
            assertEquals(divExp[i],divRes);
            assertEquals(divExp[i].hashCode(),divRes.hashCode());
        }
    }

}
