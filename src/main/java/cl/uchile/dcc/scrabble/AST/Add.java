package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

public class Add extends AbstractBinTree{
    public Add(AST I, AST D){
        super(I,D);
    }
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
