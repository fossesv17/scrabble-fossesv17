package cl.uchile.dcc.scrabble.Tipos;

import java.util.Objects;

public class SString extends AbstractSScrable implements IStype {
    private String string = "";
    public SString(){}
    public SString(String string){
        this.string = string;
    }

    /**
     * string getter for Scrabble String class
     */
    public String getString(){
        return string;
    }



    @Override
    public SString StoString() {
        return new SString(string);
    }

    /**
     * String sum or concatenation
     * @param S addend
     * @return returns a SString with the result of the concatenation
     */
    public SString Suma(IStype S) {
        return S.SumString(this);
    }

    //Invalid operations

    public IStype Resta(IStype o){return o.RestaString(this); }
    public IStype Multi(IStype o){return o.MulString(this);}
    public IStype Divn(IStype o){return o.DivString(this);}
    public IStype or(IStype o){return o.orString(this);}
    public IStype and(IStype o){return o.andString(this);}


    /**
     * equals method for SString class
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SString){
            var other = (SString) obj;
            return string.equals(other.getString());
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(SString.class,string);
    }

    @Override
    public String toString() {
        return string;
    }
}
