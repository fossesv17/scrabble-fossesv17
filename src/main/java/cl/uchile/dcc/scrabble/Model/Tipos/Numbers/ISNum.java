package cl.uchile.dcc.scrabble.Model.Tipos.Numbers;

import cl.uchile.dcc.scrabble.Model.Tipos.IStype;

/**
 * Interface that holds every operation a Scrabble Num type can do
 */
public interface ISNum extends IStype {
    /**
     * transformation to an Scrabble Float
     */
    @Override
    SFloat toFloat();
    /**
     * transformation to an Scrabble Int
     */
    @Override
    SInt toInt();
    /**
     * transformation to an Scrabble binary
     */
    @Override
    SBin toBin();

    /**
     * addition method with Scrabble Int for double dispatch
     */
    @Override
    ISNum IntSum(SInt Ia);
    /**
     * addition method with Scrabble FLoat for double dispatch
     */
    @Override
    ISNum FloatSum(SFloat Fa);
    /**
     * addition method with Scrabble Binary for double dispatch
     */
    @Override
    ISNum BinSum(SBin Ba);

    /**
     * subtraction method with Scrabble Int for double dispatch
     */
    @Override
    ISNum IntResta(SInt Ia);
    /**
     * subtraction method with Scrabble FLoat for double dispatch
     */
    @Override
    ISNum FloatResta(SFloat Fa);
    /**
     * subtraction method with Scrabble Binary for double dispatch
     */
    @Override
    ISNum BinResta(SBin Ba);
    /**
     * multiplication method with Scrabble Int for double dispatch
     */
    @Override
    ISNum IntMul(SInt Ia);
    /**
     * multiplication method with Scrabble Float for double dispatch
     */
    @Override
    ISNum FloatMul(SFloat Fa);
    /**
     * multiplication method with Scrabble Binary for double dispatch
     */
    @Override
    ISNum BinMul(SBin Ba);

    /**
     * division method with Scrabble Int for double dispatch
     */
    @Override
    ISNum IntDiv(SInt Ia);
    /**
     * division method with Scrabble Float for double dispatch
     */
    @Override
    ISNum FloatDiv(SFloat Fa);
    /**
     * division method with Scrabble Binary for double dispatch
     */
    @Override
    ISNum BinDiv(SBin Ba);
}
