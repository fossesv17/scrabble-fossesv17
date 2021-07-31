package cl.uchile.dcc.scrabble.Model.Builder;

import cl.uchile.dcc.scrabble.Model.Tipos.IStype;
import cl.uchile.dcc.scrabble.Model.Tipos.Logical.SBool;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SBin;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SFloat;
import cl.uchile.dcc.scrabble.Model.Tipos.Numbers.SInt;
import cl.uchile.dcc.scrabble.Model.Tipos.SString;

import java.util.HashMap;

/**
 * Scrabble Builder class to create Scrabble types and save them in cache
 * so it saves memory.
 */
public class ScrabbleBuilder {
    private HashMap<String, IStype> cache= new HashMap<>();

    /**
     * Scrabble Builder constructor
     */
    public ScrabbleBuilder(){};

    /**
     * Cache getter
     * @return Builder cache of scrabble types
     */
    public HashMap<String,IStype> getCache(){
        return cache;
    };

    /**
     * method to create Scrabble Strings
     * @param s string to create SString
     */
    public void createSString(String s){
        IStype v = new SString(s);
        String id = s.concat("S");
        cache.putIfAbsent(id, v);
    }

    /**
     * method to create Scrabble Integers
     * @param i integer value for the SInt
     */
    public void createSInt(int i){
        IStype v = new SInt(i);
        String id = v.toString().concat("I");
        cache.putIfAbsent(id,v);
    }

    /**
     * method to create Scrabble FLoats
     * @param d float value to create the SFloat
     */
    public void createSFloat(double d){
        IStype v = new SFloat(d);
        String id = v.toString().concat("F");
        cache.putIfAbsent(id,v);
    }

    /**
     * method to create Scrabble Binary numbers
     * @param b binary string to create the SBin
     */
    public void createSBin(String b){
        IStype v = new SBin(b);
        String id = b.concat("B");
        cache.putIfAbsent(id,v);
    }

    /**
     * method to create Scrabble Bool type
     * @param b boolean value to create the SBool
     */
    public void createSBool(boolean b){
        IStype v = new SBool(b);
        String id = v.toString().concat("BL");
        cache.putIfAbsent(id,v);
    }
}
