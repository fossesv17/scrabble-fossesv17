package cl.uchile.dcc.scrabble.Model.Tipos.Logical;


import cl.uchile.dcc.scrabble.Model.Tipos.IStype;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SBin;

/**
 * Interface that represent every logical operation for Scrabble Types
 */
public interface ISLogic extends IStype {
    @Override
    IStype boolAnd(SBool Sb);
    /**
     * AND operation when a scrabble binary executes the method AND for double dispatch
     */
    @Override
    IStype binAnd(SBin Sb);

    /**
     * OR operation when a scrabble bool executes the method OR for double dispatch
     */
    @Override
    IStype boolOr(SBool Sb);
    /**
     * OR operation when a scrabble binary executes the method OR for double dispatch
     */
    @Override
    IStype binOr(SBin Sb);
}
