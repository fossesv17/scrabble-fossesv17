package cl.uchile.dcc.scrabble.ControllerTest;

import cl.uchile.dcc.scrabble.Controller.CalcController;
import cl.uchile.dcc.scrabble.Model.Tipos.Logical.SBool;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SBin;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SFloat;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SInt;
import cl.uchile.dcc.scrabble.Model.Tipos.SString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ControllerTest {
    private CalcController CC = new CalcController();

    @Test
    void BasicOperationTest() {
        CC.AddOp();
        CC.addIntVar("3");
        CC.addIntVar("2");
        assertEquals(new SInt(5),CC.calculate());
        CC.setToDefault();
        CC.SubOp();
        CC.addIntVar("3");
        CC.addIntVar("2");
        assertEquals(new SInt(1),CC.calculate());
        CC.setToDefault();
        CC.MulOp();
        CC.addFloatVar("3.0");
        CC.addFloatVar("2.0");
        assertEquals(new SFloat(6.0),CC.calculate());
        CC.setToDefault();
        CC.DivOp();
        CC.addIntVar("10");
        CC.addFloatVar("2.0");
        assertEquals(new SFloat(5.0),CC.calculate());
        CC.setToDefault();
        CC.AddOp();
        CC.addStringVar("hola");
        CC.addBinVar("0101");
        assertEquals(new SString("hola0101"),CC.calculate());
        CC.setToDefault();
        CC.AndOp();
        CC.addBinVar("1010");
        CC.addBinVar("0111");
        assertEquals(new SBin("0010"),CC.calculate());
        CC.setToDefault();
        CC.OrOp();
        CC.addBoolVar("true");
        CC.addBoolVar("false");
        assertEquals(new SBool(true),CC.calculate());
        CC.setToDefault();
        CC.NegOp();
        CC.addBoolVar("true");
        assertEquals(new SBool(false), CC.calculate());
    }

}
