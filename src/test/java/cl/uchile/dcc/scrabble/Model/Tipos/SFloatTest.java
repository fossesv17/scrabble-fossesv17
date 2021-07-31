package cl.uchile.dcc.scrabble.Model.Tipos;

import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.ISNum;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SBin;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SFloat;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SFloatTest {
    private SFloat sFloatMt;
    private SFloat sFloat;

    @BeforeEach
    void setUp(){
        sFloat=new SFloat(5.0);
        sFloatMt=new SFloat();
    }

    @Test
    void EmptyConstructorTest(){
        var expectedSFloat = new SFloat();
        assertEquals(expectedSFloat,sFloatMt);
        assertEquals(expectedSFloat.hashCode(),sFloatMt.hashCode());
    }

    @Test
    void ConstructorTest(){
        var expectedSFloat = new SFloat(5.0);
        var diffSFloat = new SFloat(2.0);
        assertEquals(expectedSFloat,sFloat);
        assertEquals(expectedSFloat.hashCode(),sFloat.hashCode());
        assertNotEquals(diffSFloat,sFloat);
        assertNotEquals(diffSFloat.hashCode(),sFloat.hashCode());
    }

    @Test
    void TrasformationTest(){
        //transformation to string
        var floatToString = sFloat.StoString();
        var expectedTrans = new SString("5.0");
        var diffTrans = new SString("2.0");
        assertEquals(expectedTrans,floatToString);
        assertEquals(expectedTrans.hashCode(),floatToString.hashCode());
        assertNotEquals(diffTrans,floatToString);
        assertNotEquals(diffTrans.hashCode(),floatToString.hashCode());

        //transformation to other Num Types
        ISNum[] res = {sFloat.toFloat(),sFloat.toInt(),sFloat.toBin()};
        var expected = new SFloat(5.0);
        assertEquals(expected,res[0]);
        assertEquals(expected.hashCode(),res[0].hashCode());
        assertNull(res[1]);
        assertNull(res[2]);
    }

    @Test
    void OperationsTest(){
        ISNum[] Operand = {new SFloat(2.0),new SInt(2),new SBin("010")};
        var sumExp = new SFloat(7.0);
        var subExp = new SFloat(3.0);
        var mulExp = new SFloat(10.0);
        var divExp = new SFloat(2.5);

        for (int i=0;i<Operand.length;i++){
            var addRes = sFloat.Suma(Operand[i]);
            var subRes = sFloat.Resta(Operand[i]);
            var mulRes = sFloat.Multi(Operand[i]);
            var divRes = sFloat.Divn(Operand[i]);
            //asserts for suma
            assertEquals(sumExp,addRes);
            assertEquals(sumExp.hashCode(),addRes.hashCode());
            //asserts for resta
            assertEquals(subExp,subRes);
            assertEquals(subExp.hashCode(),subRes.hashCode());
            //asserts for multiplicacion
            assertEquals(mulExp,mulRes);
            assertEquals(mulExp.hashCode(),mulRes.hashCode());
            //asserts for division
            assertEquals(divExp,divRes);
            assertEquals(divExp.hashCode(),divRes.hashCode());
        }
    }


}
