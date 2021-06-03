package cl.uchile.dcc.scrabble.Tipos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SIntTest {
    private SInt sIntMt;
    private SInt sInt;
    private SInt negSInt;

    @BeforeEach
    void setUp(){
        sIntMt = new SInt();
        sInt = new SInt(5);
        negSInt = new SInt(-5);
    }
    @Test
    void EmptyConstructorTest(){
        var expectedSInt = new SInt();
        assertEquals(expectedSInt,sIntMt);
        assertEquals(expectedSInt.hashCode(),sIntMt.hashCode());
    }

    @Test
    void ConstructorTest(){
        var expectedSInt = new SInt(5);
        var diffSInt = new SInt(2);
        assertEquals(expectedSInt,sInt);
        assertEquals(expectedSInt.hashCode(),sInt.hashCode());
        assertNotEquals(diffSInt,sInt);
        assertNotEquals(diffSInt.hashCode(),sInt.hashCode());
    }

    @Test
    void SconcatTest(){
        ISString[] con = {new SString("ola"),new SInt(3),new SFloat(1.5),
                          new SBin("101"), new SBool(true)};
        for (ISString isString : con) {
            var res = sInt.Sconcat(isString);
            assertNull(res);
        }
    }

    @Test
    void TransformationTest(){
        //transformation to string
        var IntToString = sInt.StoString();
        var expectedTrans = new SString("5");
        var diffTrans = new SString("2");
        assertEquals(expectedTrans,IntToString);
        assertEquals(expectedTrans.hashCode(),IntToString.hashCode());
        assertNotEquals(diffTrans,IntToString);
        assertNotEquals(diffTrans.hashCode(),IntToString.hashCode());
        //transformation to other Num Types
        ISNum[] res = {sInt.toInt(),sInt.toFloat(),sInt.toBin(),
                       negSInt.toInt(),negSInt.toFloat(),negSInt.toBin()};
        ISNum[] expected = {new SInt(5),new SFloat(5.0),new SBin("0101"),
                            new SInt(-5),new SFloat(-5.0),new SBin("1011")};
        for (int i=0;i<res.length;i++){
            assertEquals(expected[i],res[i]);
            assertEquals(expected[i].hashCode(),res[i].hashCode());
        }

    }

    @Test
    void OperationsTest(){
        ISNum[] Operand = {new SInt(2),new SFloat(2.0),new SBin("010")};
        ISNum[] SumExpected = {new SInt(7),new SFloat(7.0),new SInt(7)};
        ISNum[] SubExpected = {new SInt(3),new SFloat(3.0),new SInt(3)};
        ISNum[] MulExpected = {new SInt(10),new SFloat(10.0),new SInt(10)};
        ISNum[] DivExpected = {new SInt(2),new SFloat(2.5),new SInt(2)};

        for (int i=0;i<3;i++){
            var addRes = sInt.Suma(Operand[i]);
            var subRes = sInt.Resta(Operand[i]);
            var mulRes = sInt.Multi(Operand[i]);
            var divRes = sInt.Div(Operand[i]);
            //asserts for Suma
            assertEquals(SumExpected[i],addRes,"Add Failed" + i);
            assertEquals(SumExpected[i].hashCode(),addRes.hashCode());
            //asserts for Resta
            assertEquals(SubExpected[i],subRes,"Sub Failed" + i);
            assertEquals(SubExpected[i].hashCode(),subRes.hashCode());
            //asserts for Multiplicacion
            assertEquals(MulExpected[i],mulRes,"Mult Failed"+i);
            assertEquals(MulExpected[i].hashCode(),mulRes.hashCode());
            //asserts for Division
            assertEquals(DivExpected[i],divRes, "Div Failed"+i);
            assertEquals(DivExpected[i].hashCode(),divRes.hashCode());
        }
    }


}
