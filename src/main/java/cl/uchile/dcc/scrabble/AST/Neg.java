package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

/**
 * Logical Negation Operation Unary tree
 */
public class Neg implements AST{
    private AST Node;
    public Neg(AST N){
        Node=N;
    }

    /**
     * method to apply the negation operation on the tree leaf
     * @return tree node negated
     */
    public IStype eval() {
        AST node = Node;
        if (node == null) {
            return null;
        } else {
            IStype evnod = node.eval();
            if (evnod==null){
                return null;
            }
            else {
                return evnod.neg();
            }
        }
    }

    /**
     * to Integer transformation for trees
     * @return evaluated tree transformed to int
     */
    public IStype toInt() {
        return this.eval().toInt();
    }

    /**
     * to float transformation for trees
     * @return evaluated tree transformed to float
     */
    public IStype toFloat() {
        return this.eval().toFloat();
    }

    /**
     * to  binary transformation for trees
     * @return evaluated tree transformed to binary number
     */
    public IStype toBin() {
        return this.eval().toBin();
    }

    /**
     * to scrabble string transformation for trees
     * @return evaluated tree transformed to a scrabble string
     */
    public IStype StoString() {
        return this.eval().StoString();
    }

    /**
     * to boolean transformation for trees
     * @return evaluated tree transformed to a bool
     */
    public IStype toBool() {
        return this.eval().toBool();
    }


}
