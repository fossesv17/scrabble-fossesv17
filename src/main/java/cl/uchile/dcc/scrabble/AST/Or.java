package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

/**
 * Logical Or operation tree
 */
public class Or extends AbstractBinTree {
    public Or(AST I, AST D){
        super(I,D);
    }

    /**
     * method to apply Or operation on the tree leaves
     * @return leftNode || rightNode
     */
    @Override
    public IStype oper(){
        IStype l = getLeftNode().eval();
        IStype r = getRightNode().eval();
        if (l==null || r==null){
            return null;
        }
        else {
            return l.or(r);
        }
    }
}

