/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 * Requires: N/A
 * Modifies: Assigns currentCustomer
 * Effect: Initialize Gold object
 * @author Chris
 */
public class Gold implements Level{
    Customer currentCustomer;
    private double fee = 10.0;
    Gold(Customer c){
        currentCustomer = c;
    }
    
    /**
     * Requires: Customer current bank balance must be string able to convert to double
     * Modifies: Changes level of customer if bank balance is at a certain amount
     * Effects: Returns the value of the fee according to level
     * 
     */
    @Override
    public double fee(){
        if ((Double.valueOf(currentCustomer.getBalance()) < 20000.0) && 
                (Double.valueOf(currentCustomer.getBalance()) >= 10000.0)){
            return (fee);
        }
        else if (Double.valueOf(currentCustomer.getBalance()) < 10000.0){
            currentCustomer.setLevel(currentCustomer.getSilverLevel());
        }
        else if (Double.valueOf(currentCustomer.getBalance()) >= 20000.0){
            currentCustomer.setLevel(currentCustomer.getPlatLevel());
        }
        return (-1.0);
    }
}
