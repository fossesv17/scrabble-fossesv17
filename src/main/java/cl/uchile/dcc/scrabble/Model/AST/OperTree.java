package cl.uchile.dcc.scrabble.Model.AST;

import cl.uchile.dcc.scrabble.Model.Tipos.IStype;

public interface OperTree extends AST {
    int getNullOperands();
    void addVar(IStype variable);
    void addOp(AST op);
}
