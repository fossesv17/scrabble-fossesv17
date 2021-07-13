package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

public class AbstractBinTree implements AST {
    private AST leftNode;
    private AST rightNode;

    public AbstractBinTree(AST LeftNode, AST RightNode){
        leftNode=LeftNode;
        rightNode=RightNode;
    }
    AST getLeftNode(){
        return leftNode;
    }
    AST getRightNode(){
        return rightNode;
    }
    public IStype eval(){
        return this.oper();
    }
    public IStype oper(){
        return null;
    }



}
