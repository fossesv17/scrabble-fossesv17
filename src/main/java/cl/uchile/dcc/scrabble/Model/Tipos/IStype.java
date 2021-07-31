package cl.uchile.dcc.scrabble.Model.Tipos;

import cl.uchile.dcc.scrabble.Model.AST.AST;
import cl.uchile.dcc.scrabble.Model.Tipos.DefaultOper.DefaultOper;

/**
 * Interface to represent Scrabble String type
 */
public interface IStype extends DefaultOper,AST  {
    /**
     * Method to convert any Scrabble type into an Scrabble String
     */
    SString StoString();

    /**
     * method to concatenate Scrabble Strings with every other Scrabble type
     * receives the Scrabble type to concatenate and returns a new Scrabble String
     */
    SString SumString(IStype S);

    /**
     * addition method for scrabble types
     * @param o addend
     * @return IStype object containing the result of the addition
     */
    IStype Suma(IStype o);

    /**
     * subtraction method for scrabble types
     * @param o subtrahend
     * @return IStype result of the subtraction
     */
    IStype Resta(IStype o);

    /**
     * multiplication method
     * @param o multiplicator
     * @return IStype object result of the multiplication
     */
    IStype Multi(IStype o);

    /**
     * division
     * @param o divisor
     * @return Object result of the division
     */
    IStype Divn(IStype o);

    /**
     * Logical and operation for bool and binary numbers
     * @param o 2nd argument for the and operation
     * @return IStype object that results from the operation
     */
    IStype and(IStype o);

    /**
     * Logical or operation for bool and binary numbers
     * @param o 2nd argument for the or operation
     * @return IStype object result of the or operation.
     */
    IStype or(IStype o);

    /**
     * Logical negation
     * @return the value negated
     */
    IStype neg();

    /**
     * method to convert to binary
     * @return
     */
}
