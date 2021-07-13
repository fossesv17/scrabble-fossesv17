package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

public class And extends AbstractBinTree{
    public And(AST I, AST D){
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
            return l.and(r);
        }
    }
}
