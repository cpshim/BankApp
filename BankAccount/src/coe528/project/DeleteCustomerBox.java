/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Chris
 */
public class DeleteCustomerBox {
    private static String enterPress;
    private static String nameString;
    
    public static void enterInfo(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Delete Customer");
        window.setMinWidth(250);
        
        Label info = new Label("Delete customer with name: ");
        
        Label name = new Label("Username: ");
        
        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        
        Button enter = new Button("Enter");
        enter.setOnAction(e -> {
           enterPress = "1";
           nameString = nameInput.getText();
           window.close();
        });
        
        Button close = new Button("Close");
        close.setOnAction(e -> window.close());
        
        HBox horizontal = new HBox();
        horizontal.setPadding(new Insets(20,20,20,20));
        horizontal.getChildren().addAll(enter, close);
        
        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(info, name, nameInput, horizontal);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();       
    }
    
    public static String[] returnValues(){
        String[] values = new String[4];
        values[0] = enterPress;
        values[1] = nameString;
        return values;
    }
}
