package cl.uchile.dcc.scrabble.Tipos;


/**
 * Intarface that represent every logical operation for Scrabble Types
 */
public interface ISLogic {
    /**
     * logical negation operation for Scrabble Booleans and Binaries
     */
    ISLogic neg();
    /**
     * logical AND operation for Scrabble booleans and binaries
     */
    ISLogic and(ISLogic a);
    /**
     * AND operation when a scrabble bool executes the method AND for double dispatch
     */
    ISLogic boolAnd(SBool Sb);
    /**
     * AND operation when a scrabble binary executes the method AND for double dispatch
     */
    ISLogic binAnd(SBin Sb);
    /**
     * logical OR operation for scrabble booleans and binaries
     */
    ISLogic or(ISLogic a);
    /**
     * OR operation when a scrabble bool executes the method OR for double dispatch
     */
    ISLogic boolOr(SBool Sb);
    /**
     * OR operation when a scrabble binary executes the method OR for double dispatch
     */
    ISLogic binOr(SBin Sb);

}
