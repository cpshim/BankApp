/*
 * Overview: This class implements the level interface. It is used to get the
 *           fee at silver level, or changes level if the current balance
 *           is at a different level
 *
 * Abstraction Function: Contains the fee for this specific level
 *
 * Rep Invar: Fee for this level must be 20.0
 *
 *
 */
package coe528.project;

/**
 * Requires: N/A
 * Modifies: Assigns currentCustomer
 * Effect: Initialize Silver object
 * @author Chris
 */
public class Silver implements Level{
    Customer currentCustomer;
    private double fee = 20.0;
    Silver(Customer c){
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
        if (Double.valueOf(currentCustomer.getBalance()) < 10000.0){
            return (fee);
        }
        else if ((Double.valueOf(currentCustomer.getBalance()) < 20000.0) && 
                (Double.valueOf(currentCustomer.getBalance()) >= 10000.0)){
            currentCustomer.setLevel(currentCustomer.getGoldLevel());
        }
        else if (Double.valueOf(currentCustomer.getBalance()) >= 20000.0){
            currentCustomer.setLevel(currentCustomer.getPlatLevel());
        }
        return (-1.0);
    }
    
    //EFFECTS: Returns true if fee is 20.0, false if it isn't
    public boolean repOK(){
        if (fee != 20.0){
            return false;
        }
        return true;
    }
    
    // EFFECTS: Returns a string that is the fee for the level
    @Override
    public String toString() {
        return (Double.toString(fee));
    }
}
