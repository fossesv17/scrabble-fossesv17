package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

/**
 * Abstract Binary Tree class to hold the expected behaviour of any kind of scrabble tree
 */
public class AbstractBinTree implements AST {
    private AST leftNode;
    private AST rightNode;

    /**
     * BinTree constructor
     * @param LeftNode BinTree left leaf
     * @param RightNode BinTree right leaf
     */
    public AbstractBinTree(AST LeftNode, AST RightNode){
        leftNode=LeftNode;
        rightNode=RightNode;
    }

    /**
     * getter for left leaf
     * @return left Node
     */
    AST getLeftNode(){
        return leftNode;
    }

    /**
     * getter for right leaf
     * @return right node
     */
    AST getRightNode(){
        return rightNode;
    }

    /**
     * method to evaluate the tree and reduce it to a scrabble value.
     * @return scrabble value to which the tree reduces
     */
    public IStype eval(){
        return oper();
    }

    /**
     * method to apply the tree operation on its leafs
     * @return returns nulls here but it is overridden in the concrete classes
     * that inherit the method
     */
    public IStype oper(){
        return null;
    }



}
