package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

/**
 * Subtraction Operation tree
 */
public class Sub extends AbstractBinTree{
    public Sub(AST I, AST D){
        super(I,D);
    }

    /**
     * method to apply Subtraction method on the tree nodes
     * @return leftNode - rightNode
     */
    @Override
    public IStype oper(){
        IStype l = getLeftNode().eval();
        IStype r = getRightNode().eval();
        if (l==null || r==null){
            return null;
        }
        else {
            return l.Resta(r);
        }
    }
}
