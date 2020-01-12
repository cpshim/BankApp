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
public class AddCustomerBox {
    private static String nameString;
    private static String passString;
    private static String balanceString;
    private static String enterPress;
    
    public static void enterInfo(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add Customer");
        window.setMinWidth(250);
        
        Label info = new Label("Customer Info");
        
        Label name = new Label("Username: ");
        
        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        
        Label password = new Label("Password: ");
        
        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        
        Label balance = new Label("First Deposit: ");
        
        TextField balanceInput = new TextField();
        balanceInput.setPromptText("Amount");
        
        Button enter = new Button("Enter");
        enter.setOnAction(e -> {
           enterPress = "1";
           nameString = nameInput.getText();
           passString = passInput.getText();
           balanceString = balanceInput.getText();
           window.close();
        });
        
        Button close = new Button("Close");
        close.setOnAction(e -> window.close());
        
        HBox horizontal = new HBox();
        horizontal.setPadding(new Insets(20,20,20,20));
        horizontal.getChildren().addAll(enter, close);
        
        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(info, name, nameInput, password, passInput,
                balance, balanceInput, horizontal);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();       
    } 
    
    public static String[] returnValues(){
        String[] values = new String[4];
        values[0] = enterPress;
        values[1] = nameString;
        values[2] = passString;
        values[3] = balanceString;
        return values;
    }
}
