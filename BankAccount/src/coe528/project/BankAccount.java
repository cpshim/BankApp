/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Chris
 */
public class BankAccount extends Application {
    
    Stage window;
    Scene login;
    Scene mScreen;
    Scene cScreen;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Manager m = new Manager();
        Customer c = new Customer();
        window = primaryStage;
        window.setTitle("Best Banking App Ever!");
        
        GridPane main = new GridPane();
        main.setPadding(new Insets(20,20,20,20));
        main.setVgap(10);
        main.setHgap(10);
        
        Label mLoginText = new Label("Manager Login");
        GridPane.setConstraints(mLoginText, 0, 0);
        
        Label mName = new Label("Username: ");
        GridPane.setConstraints(mName, 0, 1);
        
        TextField mNameInput = new TextField();
        mNameInput.setPromptText("Username");
        GridPane.setConstraints(mNameInput, 1, 1);
        
        Label mPassword = new Label("Password: ");
        GridPane.setConstraints(mPassword, 0, 2);
        
        TextField mPassInput = new TextField();
        mPassInput.setPromptText("Password");
        GridPane.setConstraints(mPassInput, 1, 2);
        
        Button mLogin = new Button("Login");
        GridPane.setConstraints(mLogin, 1, 3);
        mLogin.setOnAction(e -> {
            if (m.login(mNameInput.getText(), mPassInput.getText())){
                mNameInput.clear();
                mPassInput.clear();
                window.setScene(mScreen);
            }
            else {
                mNameInput.clear();
                mPassInput.clear();
                ErrorBox.showError(1);
            }
        });
        
        Label cLoginText = new Label("Customer Login");
        GridPane.setConstraints(cLoginText, 3, 0);
        
        Label cName = new Label("Username: ");
        GridPane.setConstraints(cName, 3, 1);
        
        TextField cNameInput = new TextField();
        cNameInput.setPromptText("Username");
        GridPane.setConstraints(cNameInput, 4, 1);
        
        Label cPassword = new Label("Password: ");
        GridPane.setConstraints(cPassword, 3, 2);
        
        TextField cPassInput = new TextField();
        cPassInput.setPromptText("Password");
        GridPane.setConstraints(cPassInput, 4, 2);
        
        Button cLogin = new Button("Login");
        GridPane.setConstraints(cLogin, 4, 3);
        cLogin.setOnAction(e -> {
            if (c.login(cNameInput.getText(), cPassInput.getText())){
                cNameInput.clear();
                cPassInput.clear();
                window.setScene(cScreen);
            }
            else {
                cNameInput.clear();
                cPassInput.clear();
                ErrorBox.showError(1);
            }
        });
        
        main.getChildren().addAll(mLoginText, mName, mNameInput, mPassword, 
                mPassInput, mLogin, cLoginText, cName, cNameInput, cPassword,
                cPassInput, cLogin);
        login = new Scene(main, 850, 480);
        
        GridPane manager = new GridPane();
        manager.setPadding(new Insets(20,20,20,20));
        manager.setVgap(10);
        manager.setHgap(10);
              
        mScreen = new Scene(manager, 850, 480);
        
        Label mHello = new Label("Hello Manager!");
        GridPane.setConstraints(mHello, 0, 0);
        manager.getChildren().add(mHello);
        
        Button add = new Button("Add Customer");
        GridPane.setConstraints(add, 0, 1);
        manager.getChildren().add(add);
        add.setOnAction(e -> {
            AddCustomerBox.enterInfo();
            String[] values = AddCustomerBox.returnValues();
            if (values[0].equals("1")){
                if ((m.addCustomer(values[1], values[2], "customer", values[3])) == 
                        -1){
                    ErrorBox.showError(5);
                }
                else if ((m.addCustomer(values[1], values[2], "customer", values[3])) == 
                        -2){
                    ErrorBox.showError(2);
                }
                else if ((m.addCustomer(values[1], values[2], "customer", values[3])) == 
                        -3){
                    ErrorBox.showError(0);
                }
            } 
        });
        
        Button delete = new Button("Delete Customer");
        GridPane.setConstraints(delete, 1, 1);
        manager.getChildren().add(delete);
        delete.setOnAction(e -> {
            DeleteCustomerBox.enterInfo();
            String[] values = DeleteCustomerBox.returnValues();
            if (values[0].equals("1")){
                if (!m.deleteCustomer(values[1])){
                    ErrorBox.showError(6);
                }
            }
        });
        
        Button mLogout = new Button("Logout");
        GridPane.setConstraints(mLogout, 1, 2);
        manager.getChildren().add(mLogout);
        mLogout.setOnAction(e -> window.setScene(login));
        
        GridPane customer = new GridPane();
        customer.setPadding(new Insets(20,20,20,20));
        customer.setVgap(10);
        customer.setHgap(10);
              
        cScreen = new Scene(customer, 850, 480);
        
        Label cHello = new Label("Hello " + c.getUsername() + "!");
        GridPane.setConstraints(cHello, 0, 0);
        customer.getChildren().add(cHello);
        
        Button deposit = new Button("Deposit Money");
        GridPane.setConstraints(deposit, 0, 1);
        customer.getChildren().add(deposit);
        deposit.setOnAction(e -> {
            DepositBox.enterInfo();
            String[] values = DepositBox.returnValues();
            if (values[0].equals("1")){
                if (!c.deposit(values[1])){
                    ErrorBox.showError(3);
                }
            } 
        });
        
        Button withdraw = new Button("Withdraw Money");
        GridPane.setConstraints(withdraw, 1, 1);
        customer.getChildren().add(withdraw);
        withdraw.setOnAction(e -> {
            WithdrawBox.enterInfo();
            String[] values = WithdrawBox.returnValues();
            if (Double.valueOf(values[1]) <= 0){
                ErrorBox.showError(3);
            }
            else if (values[0].equals("1")){
                if (!c.withdraw(values[1])){
                    ErrorBox.showError(4);
                }
            } 
        });
        
        Button getBalance = new Button("Get Account Balance");
        GridPane.setConstraints(getBalance, 2, 1);
        customer.getChildren().add(getBalance);
        getBalance.setOnAction(e -> GetBalanceBox.showBalance(c.getBalance()));
        
        Button purchase = new Button("Online Purchase");
        GridPane.setConstraints(purchase, 3, 1);
        customer.getChildren().add(purchase);
        purchase.setOnAction(e -> {
            PurchaseBox.enterAmount(c);
            String[] values = PurchaseBox.returnValues();
            if (Double.valueOf(values[1]) <= 0){
                ErrorBox.showError(3);
            }
            else if (values[0].equals("1")){
                if (!c.purchase(values[1])){
                    ErrorBox.showError(4);
                }
            } 
        });
        
        Button cLogout = new Button("Logout");
        GridPane.setConstraints(cLogout, 3, 2);
        customer.getChildren().add(cLogout);
        cLogout.setOnAction(e -> window.setScene(login));
               
        window.setScene(login);
        window.show();
    }
}
