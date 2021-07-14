package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

/**
 * Division operation tree
 */
public class Div extends AbstractBinTree {

    public Div(AST I, AST D){
        super(I,D);
    }

    /**
     * method for division operation on the leaves
     * @return division of left leaf by right leaf
     */
    @Override
    public IStype oper(){
        IStype l = getLeftNode().eval();
        IStype r = getRightNode().eval();
        if (l==null || r==null){
            return null;
        }
        else {
            return l.Divn(r);
        }
    }

}
