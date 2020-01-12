/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;

/**
 *
 * @author Chris
 */
public class DepositBox {

    private static String depositString;
    private static String enterPress;

    public static void enterInfo() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Deposit Money");
        window.setMinWidth(250);

        Label deposit = new Label("How much money would you like to deposit:");

        TextField depositInput = new TextField();
        depositInput.setPromptText("Amount");

        Button enter = new Button("Enter");
        enter.setOnAction(e -> {
            enterPress = "1";
            depositString = depositInput.getText();
            window.close();
        });

        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> window.close());

        HBox horizontal = new HBox();
        horizontal.setPadding(new Insets(20, 20, 20, 20));
        horizontal.getChildren().addAll(enter, cancel);

        VBox layout = new VBox();
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(deposit, depositInput, horizontal);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();       
    }
    
    public static String[] returnValues(){
        String[] values = new String[2];
        values[0] = enterPress;
        values[1] = depositString;
        return values;
    }
}
