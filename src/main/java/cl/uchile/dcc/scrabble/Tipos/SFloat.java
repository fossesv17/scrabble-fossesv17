package cl.uchile.dcc.scrabble.Tipos;

import java.util.Objects;

public class SFloat implements ISNum, ISString{
    private double val = 0;
    SFloat(){}
    SFloat(double value){
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
    public SString Sconcat(ISString a) {
        return a.elseCon(this);
    }

    @Override
    public SString SStringCon(SString S){
        String s1=S.getString();
        String s2 = Double.toString(val);
        return new SString(s1.concat(s2));
    }

    @Override
    public SString elseCon(ISString Ec) {
        return null;
    }

    @Override
    public SInt toInt() {
        return null;
    }

    @Override
    public SBin toBin() {
        return null;
    }

    @Override
    public ISNum Suma(ISNum a) {
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
    public ISNum Resta(ISNum a) {
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
    public ISNum Multi(ISNum a) {
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
    public ISNum Div(ISNum a) {
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
        return "SFloat{" + val + "}";
    }

}
