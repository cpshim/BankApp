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
public class ErrorBox {
    public static void showError(int type){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Error");
        window.setMinWidth(250);
        
        Label error = new Label();
        
        switch(type){
            case 1: 
                error.setText("Username or password is wrong!");
                break;
            case 2:
                error.setText("Amount must be higher than $100.00!");
                break;
            case 3:
                error.setText("Amount entered must be higher than 0!");
                break;
            case 4:
                error.setText("Withdrawing more than you have!");
                break;
            case 5:
                error.setText("Account already exists!");
                break;
            case 6:
                error.setText("Account does not exist!");
                break;
            default:
                error.setText("Error Occurred");
                break;
        }
        
        Button close = new Button("Close");
        close.setOnAction(e -> window.close());
        
        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(error, close);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();       
    } 
}
