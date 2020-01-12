/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

/**
 *
 * @author Chris
 */
public class GetBalanceBox {
    public static void showBalance(String balance){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Bank Balance");
        window.setMinWidth(250);
        
        Label currentBalance = new Label("Your current bank balance: " + balance);

        Button close = new Button("Close");
        close.setOnAction(e -> window.close());
        
        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(currentBalance, close);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();       
    } 
}
