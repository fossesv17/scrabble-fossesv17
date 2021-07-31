package cl.uchile.dcc.scrabble.Model.AST;

import cl.uchile.dcc.scrabble.Model.Tipos.IStype;



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

}
