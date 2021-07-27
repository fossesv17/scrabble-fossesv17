package cl.uchile.dcc.scrabble.Controller;

import cl.uchile.dcc.scrabble.AST.*;
import cl.uchile.dcc.scrabble.Builder.ScrabbleBuilder;
import cl.uchile.dcc.scrabble.Tipos.IStype;

/**
 * controller for the calculator
 */
public class CalcController {
    private ScrabbleBuilder SB=new ScrabbleBuilder();
    private AST res = null;
    private int type_in=0;
    private String Sres = "";

    /**
     *
     */
    public void AddOp(){
        res = new Add();
    }

    public void SubOp(){
        res = new Sub();
    }

    public void MulOp(){
        res = new Mul();
    }

    public void DivOp(){
        res = new Div();
    }

    public void AndOp(){
        res = new And();
    }

    public void OrOp(){
        res = new Or();
    }

    public void NegOp(){
        res = new Neg();
    }

    public void addIntVar(String val){
        int v = Integer.parseInt(val);
        String id = val.concat("I");
        SB.createSInt(v);
        res.addVar(SB.getCache(),id);
    }

    public void addFloatVar(String val){
        double v = Double.parseDouble(val);
        String id = val.concat("F");
        SB.createSFloat(v);
        res.addVar(SB.getCache(),id);
    }

    public void addBinVar(String val){
        String id = val.concat("B");
        SB.createSBin(val);
        res.addVar(SB.getCache(),id);
    }

    public void addStringVar(String val){
        String id = val.concat("S");
        SB.createSString(val);
        res.addVar(SB.getCache(),id);
    }

    public void addBoolVar(String val){
        boolean v = Boolean.parseBoolean(val);
        String id = val.concat("BL");
        SB.createSBool(v);
        res.addVar(SB.getCache(),id);
    }

    public IStype calculate(){
        return res.eval();
    }

    public void setToDefault(){
        res=null;
        type_in=0;
        Sres = "";
    }

    public int getType_in() {
        return type_in;
    }

    public void setType_in(int t) {
        this.type_in = t;
    }

    public void UpdateSRes() {
        if (res == null) {
            Sres = "";
        } else {
            Sres = res.toString();
        }
    }

    public AST getRes() {
        return res;
    }
    public String getSres(){
        return Sres;
    }
}
