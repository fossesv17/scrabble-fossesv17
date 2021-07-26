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
                return le.or(re);
            }
        }
    }
}

