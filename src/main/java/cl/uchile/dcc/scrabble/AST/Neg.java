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
        IStype res = Node.eval();
        if (res == null) {
            return null;
        } else {
            return res.neg();
        }
    }

}
