package cl.uchile.dcc.scrabble.Model.AST;

import cl.uchile.dcc.scrabble.Model.Tipos.IStype;

/**
 * Operation Tree that represents the addition
 */
public class Add extends AbstractBinTree{
    /**
     * Add tree constructor without arguments
     */

    public Add(){
        super();
    }

    /**
     * Constructor for Addition Tree
     * @param I left leaf
     * @param D right leaf
     */
    public Add(AST I, AST D){
        super(I,D);
    }

    /**
     * method that applies addition method on the leaves
     * @return sum of the leaves
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
                return le.Suma(re);
            }
        }
    }

    @Override
    public String toString() {
        if (getLeftNode()==null){
            return "Add()";
        }
        else if (getRightNode()==null){
            return "Add("+getLeftNode().toString()+", )";
        }
        return "Add("+ getLeftNode().toString() + ", "+ getRightNode().toString() +")";
    }
}
