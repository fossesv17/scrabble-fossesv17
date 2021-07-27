package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.Controller.CalcController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private HBox createCalc(CalcController cc){
        VBox calc = new VBox();
        HBox screen = new HBox();
        Label title = new Label("Tree Representation");
        title.setAlignment(Pos.TOP_CENTER);
        Label srep = new Label(cc.getSres());
        srep.setMaxSize(100,200);
        srep.setAlignment(Pos.BOTTOM_CENTER);
        VBox panel = new VBox();
        panel.setPadding(new Insets(10,10,10,10));
        panel.getChildren().addAll(title,srep);
        TextField output = new TextField();
        output.setMouseTransparent(true);
        output.setFocusTraversable(false);
        output.setEditable(false);
        //string and binary buttons
        Button bs = new Button("string");
        Button bb = new Button("binary");
        bs.setOnAction(e -> cc.setType_in(2));
        bb.setOnAction(e -> cc.setType_in(1));
        //operation buttons
        Button bsum = new Button("+");
        Button bsub = new Button("-");
        Button bmul = new Button("*");
        Button bdiv = new Button("/");
        Button band = new Button("^");
        Button bor = new Button("v");
        Button bneg = new Button("~");
        Button eq = new Button("=");
        eq.setPrefSize(100,50);
        eq.setOnAction(e -> eqButtonEvent(output,cc,srep));
        //buttons to enter bool values
        Button t = new Button("true");
        Button f = new Button("false");
        Button[] butts = {bsum,bsub,bmul,bdiv,band,bor,bneg,t,f};
        for (Button b : butts){
            b.setOnAction(e -> addBText(b,output,cc,srep));
        }
        //string or binary input text field
        TextField input = new TextField();
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                output.setText(output.getText().concat(input.getText()+" "));
                int type=cc.getType_in();
                String in = input.getText();
                if (type==0){
                    if (in.split("\\.").length==1) {
                        cc.addIntVar(in);
                    }
                    else {
                        cc.addFloatVar(in);
                    }
                }
                if (type==1){
                    cc.addBinVar(in);
                }
                if (type==2){
                    cc.addStringVar(in);
                }
                cc.setType_in(0);
                input.clear();
                cc.UpdateSRes();
                srep.setText(cc.getSres());
            }
        };
        input.setOnAction(event);
        HBox strbin = new HBox();
        strbin.getChildren().addAll(bs,bb);
        HBox oper = new HBox();
        HBox bool = new HBox();
        bool.getChildren().addAll(t,f);
        oper.getChildren().addAll(bsum,bsub,bmul,bdiv,band,bor,bneg);
        //adding everything to the calculator
        calc.getChildren().addAll(output,oper,strbin, input,bool, eq);
        calc.setPadding(new Insets(10,10,10,10));
        calc.setSpacing(5);
        screen.getChildren().addAll(calc,panel);
        return screen;
    }

    private static void addBText(Button b, TextField op, CalcController cc, Label l){
        if (cc.getRes()==null){
            op.clear();
        }
        op.setText(op.getText().concat(b.getText()+" "));
        String oper = b.getText();
        if (oper.equals("+")){
            cc.AddOp();
        }
        else if (oper.equals("-")){
            cc.SubOp();
        }
        else if (oper.equals("*")){
            cc.MulOp();
        }
        else if (oper.equals("/")){
            cc.DivOp();
        }
        else if (oper.equals("^")){
            cc.AndOp();
        }
        else if (oper.equals("v")){
            cc.OrOp();
        }
        else if (oper.equals("~")){
            cc.NegOp();
        }
        else if (oper.equals("true")){
            cc.addBoolVar(oper);
        }
        else if (oper.equals("false")){
            cc.addBoolVar(oper);
        }
        cc.UpdateSRes();
        l.setText(cc.getSres());
    }

    private void eqButtonEvent(TextField output, CalcController cc, Label l){
        if (cc.getRes()==null){
            output.clear();
            cc.UpdateSRes();
            l.setText(cc.getSres());
        }
        else if (cc.calculate()==null) {
            output.setText("Syntax Error");
            cc.setToDefault();
            cc.UpdateSRes();
            l.setText(cc.getSres());
        }
        else{
            output.setText(cc.calculate().toString());
            cc.setToDefault();
            cc.UpdateSRes();
            l.setText(cc.getSres());
        }
    }


    public static void main(String[] args) {
        launch();
    }

}