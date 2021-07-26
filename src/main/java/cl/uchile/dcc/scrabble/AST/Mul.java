package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

/**
 * Multiplication operation tree
 */
public class Mul extends AbstractBinTree{
    public Mul(AST I, AST D){
        super(I,D);
    }

    /**
     * method to apply multiplication method on the nodes
     * @return multiplication of left node with right node
     */
    @Override
    public IStype oper(){
        AST l = getLeftNode();
        AST r = getRightNode();
        if (l==null || r==null){
            return null;
        }
        else {
            IStype le = l.eval();
            IStype re = r.eval();
            if (le == null || re == null) {
                return null;
            } else {
                return le.Multi(re);
            }
        }
    }
}
