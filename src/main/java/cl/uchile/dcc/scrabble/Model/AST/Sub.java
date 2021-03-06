package cl.uchile.dcc.scrabble.Model.AST;

import cl.uchile.dcc.scrabble.Model.Tipos.IStype;

/**
 * Subtraction Operation tree
 */
public class Sub extends AbstractBinTree{
    public Sub(){
        super();
    }

    /**
     * Substraction tree
     * @param I left leaf/node/operand
     * @param D right leaf/node/operand
     */
    public Sub(AST I, AST D){
        super(I,D);
    }

    /**
     * method to apply Subtraction method on the tree nodes
     * @return leftNode - rightNode
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
                return le.Resta(re);
            }
        }
    }
    @Override
    public String toString() {
        if (getLeftNode()==null){
            return "Sub()";
        }
        else if (getRightNode()==null){
            return "Sub("+getLeftNode().toString()+", )";
        }
        return "Sub("+ getLeftNode().toString() + ", "+ getRightNode().toString() +")";
    }
}
