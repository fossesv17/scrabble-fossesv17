package cl.uchile.dcc.scrabble.Tipos;

import java.util.Objects;

/**
 * Scrabble bool class
 */
public class SBool implements ISLogic, ISString{
    private boolean val = true;

    SBool(){}
    SBool(boolean bool){
        val=bool;
    }

    /**
     * value getter for SBool
     */
    boolean getVal(){
        return val;
    }

    @Override
    public SString StoString() {
        return new SString(Boolean.toString(val));
    }

    /**
     * transformation to bool method
     */
    public SBool toBool(){
        return new SBool(val);
    }

    @Override
    public SString Sconcat(ISString a) {
        return a.elseCon(this);
    }

    @Override
    public SString SStringCon(SString S) {
        String s1 = S.getString();
        String s2 = Boolean.toString(val);
        return new SString(s1.concat(s2));
    }

    @Override
    public SString elseCon(ISString Ec) {
        return null;
    }
    @Override
    public ISLogic neg() {
        if(val){
            return new SBool(false);
        }
        else {
            return new SBool(true);
        }
    }

    @Override
    public ISLogic and(ISLogic a) {
        return a.boolAnd(this);
    }

    @Override
    public ISLogic boolAnd(SBool Sb) {
        if (Sb.getVal()==val){
            return new SBool(val);
        }
        else {
            return new SBool(false);
        }
    }

    @Override
    public ISLogic binAnd(SBin Sb) {
        String bin = Sb.getBin();
        if (val){
            return new SBin(bin);
        }
        else{
            String ret="";
            for (int i=0;i<bin.length();i++){
                ret=ret.concat("0");
            }
            return new SBin(ret);
        }
    }

    @Override
    public ISLogic or(ISLogic a) {
        return a.boolOr(this);
    }

    @Override
    public ISLogic boolOr(SBool Sb) {
        if (Sb.getVal()==val){
            return new SBool(val);
        }
        else {
            return new SBool(true);
        }
    }

    @Override
    public ISLogic binOr(SBin Sb) {
        String bin = Sb.getBin();
        if (val){
            String ret="";
            for (int i=0;i<bin.length();i++){
                ret=ret.concat("1");
            }
            return new SBin(ret);
        }
        else {
            return new SBin(bin);
        }
    }

    /**
     * method that returns a string representation for SBool class
     */
    @Override
    public String toString() {
        return "SBool{" + val + "}";
    }

    /**
     * equals method for SBool class
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SBool){
            var other = (SBool) obj;
            return this.val== other.getVal();
        }
        else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(val,SBool.class);
    }
}
