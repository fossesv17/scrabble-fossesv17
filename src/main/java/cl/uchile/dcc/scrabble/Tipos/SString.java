package cl.uchile.dcc.scrabble.Tipos;

import java.util.Objects;

public class SString implements ISString{
    private String string = "";
    SString(){}
    SString(String string){
        this.string = string;
    }

    /**
     * string getter for Scrabble String class
     */
    public String getString(){
        return string;
    }

    @Override
    public SString Sconcat(ISString a) {
        return a.SStringCon(this);
    }

    @Override
    public SString SStringCon(SString S) {
        String s1 = S.getString();
        String s2 = string;
        return new SString(s1.concat(s2));
    }

    @Override
    public SString elseCon(ISString Ec) {
        return null;
    }

    @Override
    public SString StoString() {
        return new SString(string);
    }


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
        return "SString{" + string + "}";
    }
}
