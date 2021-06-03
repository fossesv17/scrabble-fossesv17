package cl.uchile.dcc.scrabble.Tipos;

import java.util.ArrayList;
import java.util.Objects;

public class SInt implements ISNum, ISString{
    private int val = 0;
    SInt(){}
    SInt(int value){
        val=value;
    }

    /**
     * value getter for SInt class
     */
    public int getVal() {
        return val;
    }

    @Override
    public SString StoString() {
        return new SString(Integer.toString(this.val));
    }

    @Override
    public SString Sconcat(ISString a) {
        return a.elseCon(this);
    }

    @Override
    public SString SStringCon(SString S) {
        String s1 = S.getString();
        String s2 = Integer.toString(val);
        return new SString(s1.concat(s2));
    }

    @Override
    public SString elseCon(ISString Ec) {
        return null;
    }

    @Override
    public SInt toInt() {
        return this;
    }

    @Override
    public SFloat toFloat() {
        double f = this.val + 0.0;
        return new SFloat(f);
    }

    @Override
    public SBin toBin() {
        String binary;
        if (val>=0){
            binary = positiveIntToBin(val);
        }
        else {
            binary = negativeIntToBin(val);
        }
        return new SBin(binary);
    }

    /**
     * aux method to convert a positive int to a binary string
     * receives the number and returns the binary string
     * that represents said number
     */
    private static String positiveIntToBin(int v){
        String binary="";
        ArrayList<Integer> ns = new ArrayList<>();
        while (v!=0) {
            ns.add(v % 2);
            v = v / 2;
        }
        ns.add(0);
        for (int i = ns.size()-1;i>=0;i--){
            binary=binary.concat(Integer.toString(ns.get(i)));
        }
        return binary;
    }

    /**
     * aux method that receives a negative integer and returns
     * the binary string that represents said number
     */
    private static String negativeIntToBin(int v){
        String binary = "";
        ArrayList<Integer> ns = new ArrayList<>();
        int va=-v;
        while (va!=0){
           ns.add(va%2==0 ? 1:0);
           va=va/2;
        }
        ns.add(1);
        for (int i=ns.size()-1;i>=0;i--){
            binary=binary.concat(Integer.toString(ns.get(i)));
        }
        return binAdd1(binary);
    }

    /**
     * aux method that adds 1 to a binary number
     */
    private static String binAdd1(String b){
        char[] bc = b.toCharArray();
        if (bc[0]=='0'){
            bc[0]='1';
        }
        else {
            for (int i = b.length() - 1; i >= 0; i--) {
                if (i == 0) {
                    bc[i] = '0';
                    return "1".concat(String.valueOf(bc));
                }
                if (bc[i] == '0') {
                    bc[i] = '1';
                    break;
                } else {
                    bc[i] = '0';
                }
            }
        }
        return String.valueOf(bc);
    }

    @Override
    public ISNum Suma(ISNum a) {
        return a.IntSum(this);
    }

    @Override
    public ISNum FloatSum(SFloat Fa) {
        double retV = val + Fa.getVal();
        return new SFloat(retV);
    }

    @Override
    public ISNum IntSum(SInt Ia) {
        return new SInt(val + Ia.getVal());
    }

    @Override
    public ISNum BinSum(SBin Ba) {
        SInt ret = new SInt(val + Ba.toInt().getVal());
        return ret.toBin();
    }

    @Override
    public ISNum Resta(ISNum a) {
        return a.IntResta(this);
    }

    @Override
    public ISNum IntResta(SInt Ia) {
        int v1 = Ia.getVal();
        int v2 = val;
        return new SInt(v1-v2);
    }

    @Override
    public ISNum FloatResta(SFloat Fa) {
        double v1 = Fa.getVal();
        int v2 = val;
        return new SFloat(v1-v2);
    }

    @Override
    public ISNum BinResta(SBin Ba) {
        int v1 = Ba.toInt().getVal();
        int v2 = val;
        SInt ret = new SInt(v1-v2);
        return ret.toBin();
    }

    @Override
    public ISNum Multi(ISNum a) {
        return a.IntMul(this);
    }

    @Override
    public ISNum IntMul(SInt Ia) {
        int v1 = Ia.getVal();
        int v2 = val;
        return new SInt(v1*v2);
    }

    @Override
    public ISNum BinMul(SBin Ba) {
        int v1 = Ba.toInt().getVal();
        int v2 = val;
        SInt ret = new SInt(v1*v2);
        return ret.toBin();
    }

    @Override
    public ISNum FloatMul(SFloat Fa) {
        double v1 = Fa.getVal();
        int v2 = val;
        return new SFloat(v1*v2);
    }

    @Override
    public ISNum Div(ISNum a) {
        return a.IntDiv(this);
    }

    @Override
    public ISNum IntDiv(SInt Ia) {
        int v1 = Ia.getVal();
        int v2 = val;
        return new SInt(v1/v2);
    }

    @Override
    public ISNum BinDiv(SBin Ba) {
        int v1 = Ba.toInt().getVal();
        int v2 = val;
        SInt ret = new SInt(v1/v2);
        return ret.toBin();
    }

    @Override
    public ISNum FloatDiv(SFloat Fa) {
        double v1 = Fa.getVal();
        int v2 = val;
        return new SFloat(v1/v2);
    }

    /**
     * equals method for SInt class
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SInt){
            var other = (SInt) obj;
            return val == other.val;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(SInt.class,val);
    }

    @Override
    public String toString() {
        return "SInt{" + val + "}";
    }
}
