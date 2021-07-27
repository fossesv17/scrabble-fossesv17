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
     * controller method to add create the add tree oper
     */
    public void AddOp(){
        res = new Add();
    }

    /**
     * controller method to add create the sub tree oper
     */
    public void SubOp(){
        res = new Sub();
    }

    /**
     * controller method to add create the mul tree oper
     */
    public void MulOp(){
        res = new Mul();
    }

    /**
     * controller method to add create the div tree oper
     */
    public void DivOp(){
        res = new Div();
    }

    /**
     * controller method to add create the and tree oper
     */
    public void AndOp(){
        res = new And();
    }

    /**
     * controller method to add create the or tree oper
     */
    public void OrOp(){
        res = new Or();
    }

    /**
     * controller method to add create the neg tree oper
     */
    public void NegOp(){
        res = new Neg();
    }

    /**
     * creates a new int variable, saves it in the cache and gets added to the
     * current operation tree
     * @param val String representing the value of the variable to be created
     */
    public void addIntVar(String val){
        int v = Integer.parseInt(val);
        String id = val.concat("I");
        SB.createSInt(v);
        res.addVar(SB.getCache(),id);
    }

    /**
     * creates a new float variable, saves it in the cache and gets added to the
     * current operation tree
     * @param val String representing the value of the variable to be created
     */
    public void addFloatVar(String val){
        double v = Double.parseDouble(val);
        String id = val.concat("F");
        SB.createSFloat(v);
        res.addVar(SB.getCache(),id);
    }

    /**
     * creates a new binary variable, saves it in the cache and gets added to the
     * current operation tree
     * @param val String representing the value of the variable to be created
     */
    public void addBinVar(String val){
        String id = val.concat("B");
        SB.createSBin(val);
        res.addVar(SB.getCache(),id);
    }

    /**
     * creates a new string variable, saves it in the cache and gets added to the
     * current operation tree
     * @param val String representing the value of the variable to be created
     */
    public void addStringVar(String val){
        String id = val.concat("S");
        SB.createSString(val);
        res.addVar(SB.getCache(),id);
    }

    /**
     * creates a new boolean variable, saves it in the cache and gets added to the
     * current operation tree
     * @param val String representing the value of the variable to be created
     */
    public void addBoolVar(String val){
        boolean v = Boolean.parseBoolean(val);
        String id = val.concat("BL");
        SB.createSBool(v);
        res.addVar(SB.getCache(),id);
    }

    /**
     * reduces the current operation tree to its value
     * @return value to which the tree evaluates to
     */
    public IStype calculate(){
        return res.eval();
    }

    /**
     * sets the controller state to default
     * current oper tree = null
     * input_type = 0 (numeric-int or float)
     * string_representation of the tree = ""
     */
    public void setToDefault(){
        res=null;
        type_in=0;
        Sres = "";
    }

    /**
     * getter for the actual input type
     * @return current input type
     */
    public int getType_in() {
        return type_in;
    }

    /**
     * setter for input type
     * @param t new input type value
     */
    public void setType_in(int t) {
        this.type_in = t;
    }

    /**
     * updates the tree string representation to match the current state
     * of the operation tree
     */
    public void UpdateSRes() {
        if (res == null) {
            Sres = "";
        } else {
            Sres = res.toString();
        }
    }

    /**
     * getter for current operation tree
     * @return current operation tree
     */
    public AST getRes() {
        return res;
    }

    /**
     * getter for the current string representation of the operation tree
     * @return string representation for the current operation tree
     */
    public String getSres(){
        return Sres;
    }
}
