package cl.uchile.dcc.scrabble.Tipos;

/**
 * Interface that holds every operation a Scrabble Num type can do
 */
public interface ISNum {
    /**
     * transformation to an Scrabble Float
     */
    SFloat toFloat();
    /**
     * transformation to an Scrabble Int
     */
    SInt toInt();
    /**
     * transformation to an Scrabble binary
     */
    SBin toBin();
    /**
     * Addition operation for Scrabble Number types
     */
    ISNum Suma(ISNum a);
    /**
     * addition method with Scrabble Int for double dispatch
     */
    ISNum IntSum(SInt Ia);
    /**
     * addition method with Scrabble FLoat for double dispatch
     */
    ISNum FloatSum(SFloat Fa);
    /**
     * addition method with Scrabble Binary for double dispatch
     */
    ISNum BinSum(SBin Ba);
    /**
     * subtraction operation for Scrabble Num types
     */
    ISNum Resta(ISNum a);
    /**
     * subtraction method with Scrabble Int for double dispatch
     */
    ISNum IntResta(SInt Ia);
    /**
     * subtraction method with Scrabble FLoat for double dispatch
     */
    ISNum FloatResta(SFloat Fa);
    /**
     * subtraction method with Scrabble Binary for double dispatch
     */
    ISNum BinResta(SBin Ba);
    /**
     * Multiplication Operation for Scrabble Num Types
     */
    ISNum Multi(ISNum a);
    /**
     * multiplication method with Scrabble Int for double dispatch
     */
    ISNum IntMul(SInt Ia);
    /**
     * multiplication method with Scrabble Float for double dispatch
     */
    ISNum FloatMul(SFloat Fa);
    /**
     * multiplication method with Scrabble Binary for double dispatch
     */
    ISNum BinMul(SBin Ba);
    /**
     * Division operation for Scrabble Num Types
     */
    ISNum Div(ISNum a);
    /**
     * division method with Scrabble Int for double dispatch
     */
    ISNum IntDiv(SInt Ia);
    /**
     * division method with Scrabble Float for double dispatch
     */
    ISNum FloatDiv(SFloat Fa);
    /**
     * division method with Scrabble Binary for double dispatch
     */
    ISNum BinDiv(SBin Ba);

}
