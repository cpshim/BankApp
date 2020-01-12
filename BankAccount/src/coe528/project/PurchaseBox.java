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
public class PurchaseBox {

    private static String purchaseString;
    private static String enterPress;

    public static void enterAmount(Customer c) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Online Purchase");
        window.setMinWidth(250);
        
        Label level = new Label("Current Level: " + c.getCurrentLevel());
        Label levelFee = new Label("Your fee at your level is $" + c.getFee());
        
        Label purchase = new Label("Cost of purchase:");

        TextField purchaseInput = new TextField();
        purchaseInput.setPromptText("Amount");

        Button enter = new Button("Enter");
        enter.setOnAction(e -> {
            enterPress = "1";
            purchaseString = purchaseInput.getText();
            window.close();
        });

        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> window.close());

        HBox horizontal = new HBox();
        horizontal.setPadding(new Insets(20, 20, 20, 20));
        horizontal.getChildren().addAll(enter, cancel);

        VBox layout = new VBox();
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(level, levelFee, purchase, purchaseInput, 
                horizontal);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();       
    }
    
    public static String[] returnValues(){
        String[] values = new String[2];
        values[0] = enterPress;
        values[1] = purchaseString;
        return values;
    }
}
