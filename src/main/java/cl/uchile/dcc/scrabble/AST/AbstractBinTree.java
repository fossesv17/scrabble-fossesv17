package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

import java.util.HashMap;

/**
 * Abstract Binary Tree class to hold the expected behaviour of any kind of scrabble tree
 */
public class AbstractBinTree implements AST {
    private AST leftNode=null;
    private AST rightNode=null;

    /**
     * BinTree constructor without arguments
     */

    public AbstractBinTree(){};

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
     * method to add variable to a binary tree
     */
    @Override
    public void addVar(HashMap<String,IStype> cache, String id){
        if (leftNode==null && rightNode==null){
            leftNode=cache.get(id);
        }
        else if (rightNode==null){
            rightNode = cache.get(id);
        }
    }

    /**
     * method to add another operation tree to a binary tree
     */
    @Override
    public void addOp(AST op){
        if (leftNode==null){
            leftNode=op;
        }
        else if (rightNode==null) {
            rightNode = op;
        }
    }

}
