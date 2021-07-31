package cl.uchile.dcc.scrabble.Model;

import cl.uchile.dcc.scrabble.Model.AST.Add;
import cl.uchile.dcc.scrabble.Model.AST.Sub;
import cl.uchile.dcc.scrabble.Model.Builder.TreeBuilder;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TreeBuilderTest {
    private TreeBuilder tb = new TreeBuilder();

    @Test
    void awa(){
        tb.addOperation(new Add());
        tb.addVariable(new SInt(2));
        tb.addVariable(new SInt(3));
        var expected1 = new Add(new SInt(2),new SInt(3)).eval();
        assertEquals(expected1,tb.opTree().eval());
        tb.clear();
        tb.addOperation(new Sub());
        tb.addOperation(new Add());
        tb.addVariable(new SInt(3));
        tb.addVariable(new SInt(4));
        tb.addVariable(new SInt(1));
        var expected2 = new Sub(new Add(new SInt(3),new SInt(4)),new SInt(1)).eval();
        assertEquals(expected2,tb.opTree().eval());
    }
}
