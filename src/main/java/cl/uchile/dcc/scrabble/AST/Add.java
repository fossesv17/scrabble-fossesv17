package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

/**
 * Operation Tree that represents the addition
 */
public class Add extends AbstractBinTree{
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
        IStype l = getLeftNode().eval();
        IStype r = getRightNode().eval();
        if (l==null || r==null){
            return null;
        }
        else {
            return l.Suma(r);
        }
    }
}
