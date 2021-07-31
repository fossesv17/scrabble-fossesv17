package cl.uchile.dcc.scrabble.View;

import cl.uchile.dcc.scrabble.Controller.CalcController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Scrabble");
        var root = new Group();
        CalcController CC = new CalcController();
        HBox calc = createCalc(CC);
        root.getChildren().addAll(calc);
        Scene scene = new Scene(root, 500,200);
        stage.setScene(scene);
        stage.show();
    }

    private HBox createCalc(CalcController cc) {
        //screen containing calculator and panel
        // for string representation
        HBox screen = new HBox();
        //calculator
        VBox calc = new VBox();
        //panel for string representation of the tree
        VBox panel = new VBox();
        panel.setPadding(new Insets(10, 10, 10, 10));
        //label for the panel
        Label title = new Label("Tree Representation");
        title.setAlignment(Pos.TOP_RIGHT);
        //string representation of the tree
        Label srep = new Label(cc.getSres());
        srep.setAlignment(Pos.BOTTOM_CENTER);
        panel.getChildren().addAll(title, srep);
        //output textfield
        TextField output = new TextField();
        output.setMouseTransparent(true);
        output.setFocusTraversable(false);
        output.setEditable(false);
        //string and binary buttons
        Button bs = new Button("string");
        Button bb = new Button("binary");
        //operation buttons
        Button bsum = new Button("+");
        Button bsub = new Button("-");
        Button bmul = new Button("*");
        Button bdiv = new Button("/");
        Button band = new Button("^");
        Button bor = new Button("v");
        Button bneg = new Button("~");
        Button eq = new Button("=");
        eq.setPrefSize(100, 30);
        eq.setOnAction(e -> eqButtonEvent(output, cc, srep));
        //buttons to enter bool values
        Button t = new Button("true");
        Button f = new Button("false");
        //setting event for operation and bool buttons
        Button[] butts = {bsum, bsub, bmul, bdiv, band, bor, bneg, t, f};
        for (Button b : butts) {
            b.setOnAction(e -> operButtonEvent(b, output, cc, srep));
        }
        //input text field
        TextField input = new TextField();
        input.setOnAction(e -> inputTextEvent(input, output, cc, srep));
        bs.setOnAction(e -> StrButtonEvent(input,output,cc,srep));
        bb.setOnAction(e -> BinButtonEvent(input,output,cc,srep));
        HBox oper = new HBox();
        HBox strbinbool = new HBox();
        strbinbool.getChildren().addAll(bs, bb, t, f);
        oper.getChildren().addAll(bsum, bsub, bmul, bdiv, band, bor, bneg);
        //adding everything to the calculator
        calc.getChildren().addAll(output, oper,input, strbinbool, eq);
        calc.setPadding(new Insets(10, 10, 10, 10));
        calc.setSpacing(5);
        screen.getChildren().addAll(calc, panel);
        return screen;
    }

    private static void operButtonEvent(Button b, TextField op, CalcController cc, Label l) {
        if (cc.getRes() == null) {
            op.clear();
        }
        op.setText(op.getText().concat(b.getText() + " "));
        String oper = b.getText();
        if (oper.equals("+")) {
            cc.AddOp();
        } else if (oper.equals("-")) {
            cc.SubOp();
        } else if (oper.equals("*")) {
            cc.MulOp();
        } else if (oper.equals("/")) {
            cc.DivOp();
        } else if (oper.equals("^")) {
            cc.AndOp();
        } else if (oper.equals("v")) {
            cc.OrOp();
        } else if (oper.equals("~")) {
            cc.NegOp();
        } else if (oper.equals("true")) {
            cc.addBoolVar(oper);
        } else if (oper.equals("false")) {
            cc.addBoolVar(oper);
        }
        cc.UpdateSRes();
        l.setText(cc.getSres());
    }

    private void eqButtonEvent(TextField output, CalcController cc, Label l) {
        if (cc.getRes() == null) {
            output.clear();
            cc.UpdateSRes();
            l.setText(cc.getSres());
        } else if (cc.calculate() == null) {
            output.setText("Syntax Error");
            cc.setToDefault();
            cc.UpdateSRes();
            l.setText(cc.getSres());
        } else {
            output.setText(cc.calculate().toString());
            cc.setToDefault();
            cc.UpdateSRes();
            l.setText(cc.getSres());
        }
    }

    private void inputTextEvent(TextField input, TextField output, CalcController cc, Label srep) {
        String in = input.getText();
        output.setText(output.getText().concat(in + " "));
        if (in.split("\\.").length == 1) {
            cc.addIntVar(in);
        } else {
            cc.addFloatVar(in);
        }
        input.clear();
        cc.UpdateSRes();
        srep.setText(cc.getSres());
    }

    private void StrButtonEvent(TextField input, TextField output, CalcController cc, Label l){
        String in = input.getText();
        cc.addStringVar(in);
        output.setText(output.getText().concat(in+" "));
        input.clear();
        cc.UpdateSRes();
        l.setText(cc.getSres());
    }

    private void BinButtonEvent(TextField input, TextField output, CalcController cc, Label l) {
        String in = input.getText();
        cc.addBinVar(in);
        output.setText(output.getText().concat(in + " "));
        input.clear();
        cc.UpdateSRes();
        l.setText(cc.getSres());
    }

    public static void main(String[] args) {
        launch();
    }

}