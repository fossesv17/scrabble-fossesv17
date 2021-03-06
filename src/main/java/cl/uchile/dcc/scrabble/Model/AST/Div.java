package cl.uchile.dcc.scrabble.Model.AST;

import cl.uchile.dcc.scrabble.Model.Tipos.IStype;

/**
 * Division operation tree
 */
public class Div extends AbstractBinTree {
    /**
     * Div tree constructor without arguments
     */

    public Div(){
        super();
    }

    /**
     * Div tree constructor
     * @param I left leaf/Node
     * @param D right leaf/Node
     */
    public Div(AST I, AST D){
        super(I,D);
    }

    /**
     * method for division operation on the leaves
     * @return division of left leaf by right leaf
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
                return le.Divn(re);
            }
        }
    }
    @Override
    public String toString() {
        if (getLeftNode()==null){
            return "Div()";
        }
        else if (getRightNode()==null){
            return "Div("+getLeftNode().toString()+", )";
        }
        return "Div("+ getLeftNode().toString() + ", "+ getRightNode().toString() +")";
    }

}
