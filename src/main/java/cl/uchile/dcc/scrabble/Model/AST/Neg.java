package cl.uchile.dcc.scrabble.Model.AST;

import cl.uchile.dcc.scrabble.Model.Tipos.IStype;

/**
 * Logical Negation Operation Unary tree
 */
public class Neg implements OperTree {
    private AST Node=null;
    public Neg(){};

    /**
     * Negation tree constructor
     * @param N Node/leaf/value to be negated
     */
    public Neg(AST N){
        Node=N;
    }

    /**
     * method to apply the negation operation on the tree leaf
     * @return tree node negated
     */
    public IStype eval() {
        AST node = Node;
        if (node == null) {
            return null;
        } else {
            IStype evnod = node.eval();
            if (evnod==null){
                return null;
            }
            else {
                return evnod.neg();
            }
        }
    }

    /**
     * to Integer transformation for trees
     * @return evaluated tree transformed to int
     */
    public IStype toInt() {
        return this.eval().toInt();
    }

    /**
     * to float transformation for trees
     * @return evaluated tree transformed to float
     */
    public IStype toFloat() {
        return this.eval().toFloat();
    }

    /**
     * to  binary transformation for trees
     * @return evaluated tree transformed to binary number
     */
    public IStype toBin() {
        return this.eval().toBin();
    }

    /**
     * to scrabble string transformation for trees
     * @return evaluated tree transformed to a scrabble string
     */
    public IStype StoString() {
        return this.eval().StoString();
    }

    /**
     * to boolean transformation for trees
     * @return evaluated tree transformed to a bool
     */
    public IStype toBool() {
        return this.eval().toBool();
    }

    /**
     * method to add a variable to a Neg tree
     */
    public void addVar(IStype variable){
        if (Node==null){
            Node=variable;
        }
    }

    /**
     * method to add a operation tree to a Neg tree
     */
    public void addOp(AST op){
        if (Node==null){
            Node=op;
        }
    }

    /**
     * method to check how many not null operands the tree has
     * @return how many not null operands the tree has
     */
    public int getNullOperands(){
        if (Node==null){
            return 1;
        }
        else {
            return 0;
        }
    }
    @Override
    public String toString() {
        if (Node==null){
            return "Neg()";
        }
        return "Neg("+ Node.toString() +")";
    }

}
