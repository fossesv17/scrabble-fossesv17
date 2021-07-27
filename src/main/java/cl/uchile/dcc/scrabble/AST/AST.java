package cl.uchile.dcc.scrabble.AST;

import cl.uchile.dcc.scrabble.Tipos.IStype;

import java.util.HashMap;

/**
 * interface for Abstract Syntax Trees
 */
public interface AST {
    /**
     * evaluates the tree
     *
     * @return value to which the tree reduces
     */
    IStype eval();

    default void addVar(HashMap<String,IStype> cache, String id){};
    default void addOp(AST op){};
}
