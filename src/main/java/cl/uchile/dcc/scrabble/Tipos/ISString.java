package cl.uchile.dcc.scrabble.Tipos;

/**
 * Interface to represent Scrabble String type
 */
public interface ISString {
    /**
     * Method to convert any Scrabble type into an Scrabble String
     */
    SString StoString();

    /**
     * method to concatenate Scrabble Strings with every other Scrabble type
     * receives the Scrabble type to concatenate and returns a new Scrabble String
     */
    SString Sconcat(ISString a);

    /**
     * method for Sconcat with double dispatch so that only when an Scrabble Strings
     * executes the method, the concatenation is done.
     */
    SString SStringCon(SString S);

    /**
     * method for Sconcat with double dispatch
     * for every other type that isn't a Scrabble String
     */
    SString elseCon(ISString Ec);

}
