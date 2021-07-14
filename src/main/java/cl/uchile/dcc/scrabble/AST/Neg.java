package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

public class Neg implements AST{
    private AST Node;
    public Neg(AST N){
        Node=N;
    }
    public AST getNode() {
        return Node;
    }

    public IStype eval() {
        IStype res = Node.eval();
        if (res == null) {
            return null;
        } else {
            return res.neg();
        }
    }

}
