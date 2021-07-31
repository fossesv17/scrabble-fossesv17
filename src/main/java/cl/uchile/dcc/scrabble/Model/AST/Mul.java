package cl.uchile.dcc.scrabble.Model.AST;

import cl.uchile.dcc.scrabble.Model.Tipos.IStype;

/**
 * Multiplication operation tree
 */
public class Mul extends AbstractBinTree{

    /**
     * Mul tree constructor without arguments
     */

    public Mul(){
        super();
    }

    /**
     * Mul tree constructor
     * @param I left leaf/node
     * @param D right leaf/node
     */
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
    @Override
    public String toString() {
        if (getLeftNode()==null){
            return "Mul()";
        }
        else if (getRightNode()==null){
            return "Mul("+getLeftNode().toString()+", )";
        }
        return "Mul("+ getLeftNode().toString() + ", "+ getRightNode().toString() +")";
    }
}
