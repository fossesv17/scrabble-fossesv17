package cl.uchile.dcc.scrabble.Tipos.Logical;

import cl.uchile.dcc.scrabble.Tipos.AbstractSScrable;
import cl.uchile.dcc.scrabble.Tipos.IStype;
import cl.uchile.dcc.scrabble.Tipos.Numbers.SBin;
import cl.uchile.dcc.scrabble.Tipos.SString;

import java.util.Objects;

/**
 * Scrabble bool class
 */
public class SBool extends AbstractSScrable implements ISLogic{
    private boolean val = true;

    public SBool(){}
    public SBool(boolean bool){
        val=bool;
    }

    /**
     * value getter for SBool
     */
    public boolean getVal(){
        return val;
    }

    @Override
    public SString StoString() {
        return new SString(Boolean.toString(val));
    }

    /**
     * transformation to bool method
     */
    @Override
    public SBool toBool(){
        return new SBool(val);
    }

    //Invalid Operations
    @Override
    public IStype Suma(IStype o){return o.BoolSum(this);}
    @Override
    public IStype Resta(IStype o){return o.BoolResta(this);}
    @Override
    public IStype Multi(IStype o){return o.BoolMul(this);}
    @Override
    public IStype Divn(IStype o){return o.BoolDiv(this);}

    @Override
    public IStype neg() {
        if(val){
            return new SBool(false);
        }
        else {
            return new SBool(true);
        }
    }

    @Override
    public IStype and(IStype a) {
        return a.boolAnd(this);
    }

    @Override
    public IStype boolAnd(SBool Sb) {
        if (Sb.getVal()==val){
            return new SBool(val);
        }
        else {
            return new SBool(false);
        }
    }

    @Override
    public IStype binAnd(SBin Sb) {
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
    public IStype or(IStype a) {
        return a.boolOr(this);
    }

    @Override
    public IStype boolOr(SBool Sb) {
        if (Sb.getVal()==val){
            return new SBool(val);
        }
        else {
            return new SBool(true);
        }
    }

    @Override
    public IStype binOr(SBin Sb) {
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
        return Boolean.toString(val);
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
