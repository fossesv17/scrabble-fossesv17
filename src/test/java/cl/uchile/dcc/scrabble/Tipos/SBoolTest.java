package cl.uchile.dcc.scrabble.Tipos;

import cl.uchile.dcc.scrabble.Tipos.Logical.ISLogic;
import cl.uchile.dcc.scrabble.Tipos.Logical.SBool;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SBin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SBoolTest {
    private SBool tbool;
    private SBool fbool;
    private SBool mtBool;

    @BeforeEach
    void setUp(){
        mtBool = new SBool();
        tbool= new SBool(true);
        fbool = new SBool(false);
    }
    @Test
    void emptyConstructorTest(){
        var emptyB = new SBool();
        assertEquals(mtBool,emptyB);
        assertEquals(mtBool.hashCode(),emptyB.hashCode());
    }
    @Test
    void ConstructorTest(){
        var bool = new SBool(true);
        assertEquals(bool,tbool);
        assertEquals(bool.hashCode(),tbool.hashCode());
        assertNotEquals(bool,fbool);
        assertNotEquals(bool.hashCode(),fbool.hashCode());
    }

    @Test
    void TransformationTest(){
        var res = tbool.StoString();
        var expected = new SString("true");
        assertEquals(expected,res);
        assertEquals(expected.hashCode(),res.hashCode());
        var res2 = tbool.toBool();
        var expected2 = new SBool(true);
        assertEquals(expected2,res2);
        assertEquals(expected2.hashCode(),res2.hashCode());
    }

    @Test
    void OperationsTest(){
        ISLogic[] op = {new SBool(true),new SBin("0101")};
        ISLogic[] expAnd = {new SBool(true),new SBin("0101")};
        ISLogic[] expOr = {new SBool(true),new SBin("1111")};
        //assert negation
        var negRes = tbool.neg();
        var negRes2 = fbool.neg();
        var negExp = new SBool(false);
        var negExp2 = new SBool(true);
        assertEquals(negExp,negRes);
        assertEquals(negExp.hashCode(),negRes.hashCode());
        assertEquals(negExp2,negRes2);
        assertEquals(negExp2.hashCode(),negRes2.hashCode());

        for (int i=0;i<2;i++){
            var andRes = tbool.and(op[i]);
            var orRes = tbool.or(op[i]);
            //and assert
            assertEquals(expAnd[i],andRes);
            assertEquals(expAnd[i].hashCode(),andRes.hashCode());
            //or assert
            assertEquals(expOr[i],orRes);
            assertEquals(expOr[i].hashCode(),orRes.hashCode());
        }
    }
}
