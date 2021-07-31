package cl.uchile.dcc.scrabble.Controller;

import cl.uchile.dcc.scrabble.Model.AST.*;
import cl.uchile.dcc.scrabble.Model.Builder.ScrabbleBuilder;
import cl.uchile.dcc.scrabble.Model.Builder.TreeBuilder;
import cl.uchile.dcc.scrabble.Model.Tipos.IStype;

/**
 * controller for the calculator
 */
public class CalcController {
    private ScrabbleBuilder SB=new ScrabbleBuilder();
    private TreeBuilder TB = new TreeBuilder();
    private String Sres = "";

    /**
     * controller method to add create the add tree oper
     */
    public void AddOp(){
        TB.addOperation(new Add());
    }

    /**
     * controller method to add create the sub tree oper
     */
    public void SubOp() {
        TB.addOperation(new Sub());
    }
    /**
     * controller method to add create the mul tree oper
     */
    public void MulOp(){
        TB.addOperation(new Mul());
    }

    /**
     * controller method to add create the div tree oper
     */
    public void DivOp(){
        TB.addOperation(new Div());
    }

    /**
     * controller method to add create the and tree oper
     */
    public void AndOp(){
        TB.addOperation(new And());
    }

    /**
     * controller method to add create the or tree oper
     */
    public void OrOp(){
        TB.addOperation(new Or());
    }

    /**
     * controller method to add create the neg tree oper
     */
    public void NegOp(){
        TB.addOperation(new Neg());
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
        IStype variable = SB.getCache().get(id);
        TB.addVariable(variable);
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
        IStype variable = SB.getCache().get(id);
        TB.addVariable(variable);
    }

    /**
     * creates a new binary variable, saves it in the cache and gets added to the
     * current operation tree
     * @param val String representing the value of the variable to be created
     */
    public void addBinVar(String val){
        String id = val.concat("B");
        SB.createSBin(val);
        IStype variable = SB.getCache().get(id);
        TB.addVariable(variable);
    }

    /**
     * creates a new string variable, saves it in the cache and gets added to the
     * current operation tree
     * @param val String representing the value of the variable to be created
     */
    public void addStringVar(String val){
        String id = val.concat("S");
        SB.createSString(val);
        IStype variable = SB.getCache().get(id);
        TB.addVariable(variable);
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
        IStype variable = SB.getCache().get(id);
        TB.addVariable(variable);
    }

    /**
     * reduces the current operation tree to its value
     * @return value to which the tree evaluates to
     */
    public IStype calculate() {
        if (TB.opTree() == null)
            return null;
        else {
            return TB.opTree().eval();
        }
    }


    /**
     * sets the controller state to default
     * current oper tree = null
     * input_type = 0 (numeric-int or float)
     * string_representation of the tree = ""
     */
    public void setToDefault(){
        Sres = "";
        TB.clear();
    }

    /**
     * updates the tree string representation to match the current state
     * of the operation tree
     */
    public void UpdateSRes() {
        AST optree = TB.opTree();
        if (optree==null){
            Sres="";
        }
        else {
            Sres = optree.toString();
        }
    }

    /**
     * getter for current operation tree
     * @return current operation tree
     */
    public AST getRes() {
        return TB.opTree();
    }

    /**
     * getter for the current string representation of the operation tree
     * @return string representation for the current operation tree
     */
    public String getSres(){
        return Sres;
    }
}
