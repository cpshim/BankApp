/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Requires: N/A
 * Modifies: Assigns levelString, currentLevel
 * Effect: Initializes the 3 levels
 * @author Chris
 */
public class Customer {
    private String username;
    private String password;
    private String role;
    private Level silver;
    private Level gold;
    private Level plat;
    private Level currentLevel;
    private String levelString;
    private double balance;
    private double fee;
    private String currentBalance;
    //private Level level;

    Customer() {
        levelString = null;
        silver = new Silver(this);
        gold = new Gold(this);
        plat = new Plat(this);
        currentLevel = silver;
    }

    /**
     * Requires: Needs a level object
     * Modifies: N/A
     * Effects: Changes level of customer in text file
     * 
     */
    protected void setLevel(Level newLevel) {
        currentLevel = newLevel;
        try {
            //File file = new File(a + ".txt");
            //file.createNewFile();
            FileWriter fw = new FileWriter(username + ".txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(password);
            bw.newLine();
            bw.write(currentBalance);
            bw.newLine();
            bw.write(levelString);
            bw.close();
            //fw.close();
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }
    }

    /**
     * Requires: User and Pass cannot be null
     * Modifies: Assigns username, password, levelString, and currentBalance 
     *           to those read from document
     * Effects: Returns true if login info matches that in text document, false
     *          otherwise
     * 
     */
    public boolean login(String user, String pass) {
        username = user;
        String readPassword = null;
        String readBalance = null;
        String readLevel = null;
        try {
            FileReader fr = new FileReader(user + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    readPassword = line;
                }
                if (i == 1) {
                    readBalance = line;
                }
                if (i == 2) {
                    readLevel = line;
                }
                i++;
            }
            br.close();
            if (pass.equals(readPassword)) {
                password = readPassword;
                currentBalance = readBalance;
                levelString = readLevel;
                System.out.println(username);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Requires: N/A
     * Modifies: Assigns the level fee to fee
     * Effects: Returns the value of the fee according to level
     * 
     */
    public double getFee() {
        while (currentLevel.fee() == -1.0){
            currentLevel.fee();
        }
        fee = currentLevel.fee();
        return fee;
    }

    /**
     * Requires: N/A
     * Modifies: Assigns a string of the level to levelString
     * Effects: Returns the level
     * 
     */
    public Level getSilverLevel() {
        levelString = "Silver";
        return silver;
    }

    /**
     * Requires: N/A
     * Modifies: Assigns a string of the level to levelString
     * Effects: Returns the level
     *  
     */
    public Level getGoldLevel() {
        levelString = "Gold";
        return gold;
    }

    /**
     * Requires: N/A
     * Modifies: Assigns a string of the level to levelString
     * Effects: Returns the level
     * 
     */
    public Level getPlatLevel() {
        levelString = "Plat";
        return plat;
    }
    
    /**
     * Requires: N/A
     * Modifies: N/A
     * Effects: Returns the current level of customer as string
     * 
     */
    public String getCurrentLevel(){
        return levelString;
    }

    /**
     * Requires: N/A
     * Modifies: N/A
     * Effects: Returns the current balance as string
     * 
     */
    public String getBalance() {
        return currentBalance;
    }

    /**
     * Requires: Value is able to be converted to double
     * Modifies: Changes the current balance to reflect deposit
     * Effects: Updates customer text file based on deposit. 
     *          Returns true if successful, false otherwise
     * 
     */
    public boolean deposit(String value) {
        if (Double.valueOf(value) >= 0.0) {
            currentBalance = Double.toString(Double.valueOf(currentBalance) + Double.valueOf(value));
            System.out.println(currentBalance);
            try {
                //File file = new File(a + ".txt");
                //file.createNewFile();
                FileWriter fw = new FileWriter(username + ".txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(password);
                bw.newLine();
                bw.write(currentBalance);
                bw.newLine();
                bw.write(levelString);
                bw.close();
                return true;
                //fw.close();
            } 
            catch (IOException e) {
                System.out.println("Error writing to file");
                return false;
            }
            catch (NumberFormatException error){
                System.out.println("Enter only integers");
                return false;
            }
        }
        return false;
    }

    /**
     * Requires: Value is able to be converted to double
     * Modifies: Changes the current balance to reflect withdraw
     * Effects: Updates customer text file based on withdraw. 
     *          Returns true if successful, false otherwise
     * 
     */
    public boolean withdraw(String value) {
        if ((Double.valueOf(value) < Double.valueOf(currentBalance))
                && (Double.valueOf(value) > 0.0)) {
            currentBalance = Double.toString(Double.valueOf(currentBalance) - Double.valueOf(value));
            try {
                //File file = new File(a + ".txt");
                //file.createNewFile();
                FileWriter fw = new FileWriter(username + ".txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(password);
                bw.newLine();
                bw.write(currentBalance);
                bw.newLine();
                bw.write(levelString);
                bw.close();
                return true;
                //fw.close();
            }
            catch (IOException e) {
                System.out.println("Error writing to file");
                return false;               
            }
            catch (NumberFormatException error){
                System.out.println("Enter only integers");
                return false;
            }
        }
        return false;
    }

    /**
     * Requires: N/A
     * Modifies: N/A
     * Effects: Returns the username
     * 
     */
    public String getUsername() {
        return username;
    }

    /**
     * Requires: Value is able to be converted to double
     * Modifies: Changes the current balance to reflect purchase
     * Effects: Updates customer text file based on purchase. 
     *          Returns true if successful, false otherwise
     * 
     */
    public boolean purchase(String value) {
        if (((Double.valueOf(value) + fee) < Double.valueOf(currentBalance))
                && (Double.valueOf(value) > 0.0)) {
            currentBalance = Double.toString(Double.valueOf(currentBalance)
                    - (Double.valueOf(value) + fee));
            try {
                //File file = new File(a + ".txt");
                //file.createNewFile();
                FileWriter fw = new FileWriter(username + ".txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(password);
                bw.newLine();
                bw.write(currentBalance);
                bw.newLine();
                bw.write(levelString);
                bw.close();
                return true;
                //fw.close();
            } catch (Exception e) {
                System.out.println("Error writing to file");
                return false;
            }
        }
        return false;
    }
}
