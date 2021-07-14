package cl.uchile.dcc.scrabble.Tipos.Numbers;

import cl.uchile.dcc.scrabble.Tipos.AbstractSScrable;
import cl.uchile.dcc.scrabble.Tipos.IStype;
import cl.uchile.dcc.scrabble.Tipos.SString;

import java.util.Objects;

public class SFloat extends AbstractSScrable implements ISNum {
    private double val = 0;
    public SFloat(){}
    public SFloat(double value){
        val = value;
    }

    /**
     * value getter for SFloat class
     */
    public double getVal() {
        return val;
    }

    @Override
    public SFloat toFloat() {
        return this;
    }

    @Override
    public SString StoString() {
        return new SString(Double.toString(this.val));
    }



    @Override
    public SInt toInt() {
        return null;
    }

    @Override
    public SBin toBin() {
        return null;
    }

    //invalid op
    public IStype and(IStype a){ return a.FloatAnd(this);}
    public IStype or(IStype a){ return a.FloatOr(this);}

    @Override
    public IStype Suma(IStype a) {
        return a.FloatSum(this);
    }

    @Override
    public ISNum FloatSum(SFloat Fa) {
        double retV = val + Fa.getVal();
        return new SFloat(retV);
    }

    @Override
    public ISNum IntSum(SInt Ia) {
        double retV = val + Ia.getVal();
        return new SFloat(retV);
    }

    @Override
    public ISNum BinSum(SBin Ba) {
        return null;
    }

    @Override
    public IStype Resta(IStype a) {
        return a.FloatResta(this);
    }

    @Override
    public ISNum FloatResta(SFloat Fa) {
        double v1 = Fa.getVal();
        double v2 = val;
        return new SFloat(v1-v2);
    }

    @Override
    public ISNum BinResta(SBin Ba) {
        return null;
    }

    @Override
    public ISNum IntResta(SInt Ia) {
        int v1 = Ia.getVal();
        double v2 = val;
        return new SFloat(v1-v2);
    }

    @Override
    public IStype Multi(IStype a) {
        return a.FloatMul(this);
    }

    @Override
    public ISNum FloatMul(SFloat Fa) {
        double v1 = Fa.getVal();
        double v2 = val;
        return new SFloat(v1*v2);
    }

    @Override
    public ISNum BinMul(SBin Ba) {
        return null;
    }

    @Override
    public ISNum IntMul(SInt Ia) {
        int v1 = Ia.getVal();
        double v2 = val;
        return new SFloat(v1*v2);
    }

    @Override
    public IStype Divn(IStype a) {
        return a.FloatDiv(this);
    }

    @Override
    public ISNum FloatDiv(SFloat Fa) {
        double v1 = Fa.getVal();
        double v2 = val;
        return new SFloat(v1/v2);
    }

    @Override
    public ISNum BinDiv(SBin Ba) {
        return null;
    }

    @Override
    public ISNum IntDiv(SInt Ia) {
        int v1 = Ia.getVal();
        double v2 = val;
        return new SFloat(v1/v2);
    }

    /**
     * Equals method for SFloat class
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SFloat) {
            var other = (SFloat) obj;
            return val== other.getVal();
        }
        else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(SFloat.class,val);
    }

    @Override
    public String toString() {
        return Double.toString(val);
    }

}
