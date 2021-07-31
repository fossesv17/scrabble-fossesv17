package cl.uchile.dcc.scrabble.Model.Builder;


import cl.uchile.dcc.scrabble.Model.AST.OperTree;
import cl.uchile.dcc.scrabble.Model.Tipos.IStype;

import java.util.ArrayList;

/**
 * class to build Operation trees
 */
public class TreeBuilder {
    private ArrayList<OperTree> op = new ArrayList<OperTree>();
    public TreeBuilder(){};

    /**
     * method to add an operation node to the current tree
     * @param oper operation node to add to the tree
     */
    public void addOperation(OperTree oper){
        op.add(oper);
        int last = op.size()-1;
        OperTree tree = op.get(last);
        if (tree.getNullOperands()==0){
            updateTree();
        }
    }

    /**
     * method to add variables to the tree so it can operate with them
     * @param variable operand/variable to add to the tree
     */
    public void addVariable(IStype variable){
        int last = op.size()-1;
        OperTree tree = op.get(last);
        tree.addVar(variable);
        if (last!=0 && tree.getNullOperands()==0){
            updateTree();
        }
    }

    /**
     * to update the state of the main tree with the operation nodes that have been added
     */
    public void updateTree() {
        int last = op.size() - 1;
        OperTree mainTree = op.get(last - 1);
        OperTree subTree = op.get(last);
        mainTree.addOp(subTree);
        op.remove(subTree);
    }

    /**
     * method to return the current operation tree
     * @return operation tree
     */
    public OperTree opTree() {
        if (op.size() == 0) {
            return null;
        } else {
            return op.get(0);
        }
    }

    /**
     * to initialize the state of the tree builder so it can build another one
     */
    public void clear(){
        op.clear();
    }
}
