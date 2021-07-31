package cl.uchile.dcc.scrabble.Model.AST;

import cl.uchile.dcc.scrabble.Model.Tipos.IStype;

/**
 * Logical And operation tree
 */
public class And extends AbstractBinTree{
    /**
     * And tree constructor without arguments
     */

    public And(){
        super();
    }

    /**
     * Constructor
     * @param I left leaf
     * @param D right leaf
     */
    public And(AST I, AST D){
        super(I,D);
    }

    /**
     * method to apply the logical and operation on the leaves
     * @return left leaf && right leaf
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
                return le.and(re);
            }
        }
    }
    @Override
    public String toString() {
        if (getLeftNode()==null){
            return "And()";
        }
        else if (getRightNode()==null){
            return "And("+getLeftNode().toString()+", )";
        }
        return "And("+ getLeftNode().toString() + ", "+ getRightNode().toString() +")";
    }
}
