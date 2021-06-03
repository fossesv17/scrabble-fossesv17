package cl.uchile.dcc.scrabble.Tipos;

import java.util.Objects;

/**
 * Scrabble binary class
 */
public class SBin implements ISNum, ISLogic, ISString{
    private String bin = "0";
    SBin(){}
    SBin(String binary){
        bin = binary;
    }

    /**
     * binary string getter for SBin
     */
    public String getBin() {
        return bin;
    }

    @Override
    public SString Sconcat(ISString a) {
        return a.elseCon(this);
    }

    @Override
    public SString SStringCon(SString S) {
        String s1 = S.getString();
        String s2 = bin;
        return new SString(s1.concat(s2));
    }

    @Override
    public SString elseCon(ISString Ec) {
        return null;
    }

    @Override
    public ISLogic neg() {
        String nb = "";
        for (int i=0;i<bin.length();i++){
            nb=nb.concat(Character.toString(bin.charAt(i)=='1'? 0:1));
        }
        return new SBin(nb);
    }

    @Override
    public ISLogic and(ISLogic a) {
        return a.binAnd(this);
    }

    @Override
    public ISLogic binAnd(SBin Sb) {
        String ret = "";
        String bin1 = Sb.getBin();
        String bin2 = this.getBin();
        int MinLen = Math.min(bin1.length(), bin2.length());
        int MaxLen = Math.max(bin1.length(),bin2.length());
        int offset1=0;
        int offset2=0;
        if (MinLen==bin1.length()){
            offset1=MaxLen-MinLen;
        }
        else {
            offset2=MaxLen-MinLen;
        }
        for (int i=0;i<MaxLen-MinLen;i++){
            ret=ret.concat(Character.toString((bin1.length()==MaxLen ? bin1.charAt(i) : bin2.charAt(i))));
        }
        for (int i = MaxLen-MinLen; i < MaxLen; i++) {
            int ind1=i-offset1;
            int ind2=i-offset2;
            if (bin1.charAt(ind1) == bin2.charAt(ind2)) {
                ret = ret.concat(Character.toString(bin1.charAt(ind1)));
            } else {
                ret = ret.concat("0");
            }
        }
        return new SBin(ret);
    }

    @Override
    public ISLogic boolAnd(SBool Sb) {

        if (Sb.getVal()){
            return new SBin(bin);
        }
        else {
            String ret = "";
            for (int i=0;i<bin.length();i++){
                ret=ret.concat("0");
            }
            return new SBin(ret);
        }
    }

    @Override
    public ISLogic or(ISLogic a) {
        return a.binOr(this);
    }

    @Override
    public ISLogic binOr(SBin Sb) {
        String ret = "";
        String bin1 = Sb.getBin();
        String bin2 = this.getBin();
        int MinLen = Math.min(bin1.length(), bin2.length());
        int MaxLen = Math.max(bin1.length(),bin2.length());
        int offset1=0;
        int offset2=0;
        if (MinLen==bin1.length()){
            offset1=MaxLen-MinLen;
        }
        else {
            offset2=MaxLen-MinLen;
        }
        for (int i=0;i<MaxLen-MinLen;i++){
            ret=ret.concat(Character.toString((bin1.length()==MaxLen ? bin1.charAt(i) : bin2.charAt(i))));
        }
        for (int i = MaxLen-MinLen; i < MaxLen; i++) {
            int ind1=i-offset1;
            int ind2=i-offset2;
            if (bin1.charAt(ind1) == bin2.charAt(ind2)) {
                ret = ret.concat(Character.toString(bin1.charAt(ind1)));
            } else {
                ret = ret.concat("1");
            }
        }
        return new SBin(ret);
    }

    @Override
    public ISLogic boolOr(SBool Sb) {
        if (Sb.getVal()){
            String ret = "";
            for (int i=0;i<bin.length();i++){
                ret=ret.concat("1");
            }
            return new SBin(ret);
        }
        else {
            return new SBin(bin);
        }
    }

    @Override
    public SString StoString() {
        return new SString(bin);
    }

    @Override
    public SBin toBin() {
        return this;
    }

    @Override
    public SFloat toFloat() {
        SInt i = this.toInt();
        return new SFloat(i.getVal()+0.0);
    }

    @Override
    public SInt toInt() {
        int num;
        if(bin.charAt(0)=='0') {
            num = positiveBinToInt(bin);
        }
        else{
            num = negativeBinaryToInt(bin);
        }
        return new SInt(num);
    }

    /**
     * Aux method for conversion from binary to int
     * specifically for positive Binaries
     * receives an String of bits to convert to Integer
     * and returns the number that represents
     */
    private static int positiveBinToInt(String b){
        int n = b.length() - 1;
        int w = 0;
        for (int i = n,j=0; i>0 ; i--,j++){
            w+= (int) Math.pow(2,j)*(b.charAt(i)=='0' ? 0:1);
        }
        return w;
    }

    /**
     * Aux method to convert negative binaries to int
     * receives a String of bits to convert to Integer
     * and returns the number that represents
     */
    private static int negativeBinaryToInt(String b){
        int n = b.length() - 1;
        int w = -(b.charAt(0)=='0'?0:1)* (int) Math.pow(2,n);
        for (int i=n,j=0;i>0;i--,j++){
            w+= (int) Math.pow(2,j) * (b.charAt(i)=='1'?1:0);
        }
        return w;
    }

    @Override
    public ISNum Suma(ISNum a) {
        return a.BinSum(this);
    }

    @Override
    public ISNum BinSum(SBin Ba) {
        int b1 = this.toInt().getVal();
        int b2 = Ba.toInt().getVal();
        SInt b = new SInt(b1+b2);
        return b.toBin();
    }

    @Override
    public ISNum FloatSum(SFloat Fa) {
        double v1 = Fa.getVal();
        double v2 = this.toFloat().getVal();
        return new SFloat(v1+v2);
    }

    @Override
    public ISNum IntSum(SInt Ia) {
        int b1 = this.toInt().getVal();
        int b2 = Ia.getVal();
        return new SInt(b1+b2);
    }

    @Override
    public ISNum Resta(ISNum a) {
        return a.BinResta(this);
    }

    @Override
    public ISNum IntResta(SInt Ia) {
        int v1 = Ia.getVal();
        int v2 = this.toInt().getVal();
        return new SInt(v1-v2);
    }

    @Override
    public ISNum FloatResta(SFloat Fa) {
        double v1 = Fa.getVal();
        double v2 = this.toFloat().getVal();
        return new SFloat(v1-v2);
    }
    @Override
    public ISNum BinResta(SBin Ba){
        int v1 = Ba.toInt().getVal();
        int v2 = this.toInt().getVal();
        SInt r = new SInt(v1-v2);
        return r.toBin();
    }

    @Override
    public ISNum Multi(ISNum a) {
        return a.BinMul(this);
    }

    @Override
    public ISNum IntMul(SInt Ia) {
        int v1 = Ia.getVal();
        int v2 = this.toInt().getVal();
        return new SInt(v1*v2);
    }

    @Override
    public ISNum FloatMul(SFloat Fa) {
        double v1 = Fa.getVal();
        double v2 = this.toFloat().getVal();
        return new SFloat(v1*v2);
    }

    @Override
    public ISNum BinMul(SBin Ba) {
        int v1 = Ba.toInt().getVal();
        int v2 = this.toInt().getVal();
        SInt r = new SInt(v1*v2);
        return r.toBin();
    }

    @Override
    public ISNum Div(ISNum a) {
        return a.BinDiv(this);
    }

    @Override
    public ISNum IntDiv(SInt Ia) {
        int v1 = Ia.getVal();
        int v2 = this.toInt().getVal();
        return new SInt(v1/v2);
    }

    @Override
    public ISNum FloatDiv(SFloat Fa) {
        double v1 = Fa.getVal();
        double v2 = this.toFloat().getVal();
        return new SFloat(v1/v2);
    }

    @Override
    public ISNum BinDiv(SBin Ba) {
        int v1 = Ba.toInt().getVal();
        int v2 = this.toInt().getVal();
        SInt r = new SInt(v1/v2);
        return r.toBin();
    }

    /**
     * method that returns a string representation of an object
     */
    @Override
    public String toString() {
        return "SBin{"+bin+"}";
    }

    /**
     * equals method for Scrabble binaries
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SBin) {
            var other = (SBin) obj;
            return bin.equals(other.getBin());
        }
        else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(SBin.class,bin);
    }
}
