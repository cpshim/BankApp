/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Requires: N/A
 * Modifies: Assigns username, password
 * Effect: Creates admin text file
 * @author Chris
 */
public class Manager {
    private String username;
    private String password;
    private String role;

    Manager() {
        username = "admin";
        password = "admin";
        try {
            //File file = new File(a + ".txt");
            //file.createNewFile();
            FileWriter fw = new FileWriter(username + ".txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(password);
            bw.close();
            //fw.close();
        } catch (Exception e) {
            System.out.println("Hi");
        }
    }

    /**
     * Requires: User and Pass cannot be null
     * Modifies: N/A
     * Effects: Returns true if login info matches that in text document, false
     *          otherwise
     * 
     */
    public boolean login(String user, String pass) {
        String password = null;
        try {
            FileReader fr = new FileReader(user + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    password = line;
                }
                i++;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Can't find file");
            return false;
        }
        return (pass.equals(password));
    }

    /**
     * Requires: User, Pass, Role, and Balance cannot be null, Balance must be
     *           able to convert to double
     * Modifies: N/A
     * Effects: Returns a negative integer based on whether the file exists, an 
     *          exception was caught, or if deposit amount is less than 100.
     *          Returns a positive integer if successful. Adds a customer 
     *          text file if successful
     * 
     */
    public int addCustomer(String user, String pass, String role, String balance) {
        if (Files.isReadable(Paths.get(user + ".txt"))){
            return (-1);
        }
        if (Double.valueOf(balance) >= 100.0) {
            try {
                FileWriter fw = new FileWriter(user + ".txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(pass);
                bw.newLine();
                bw.write(balance);
                bw.newLine();
                bw.write("Silver");
                bw.close();
                return(1);
                
            } catch (Exception e) {
                System.out.println("Error adding file");
                return (-3);
            }
        }
        return (-2);
    }
    
    /**
     * Requires: User must be a string
     * Modifies: N/A
     * Effects: Returns true if successful, false otherwise. Deletes customer 
     *          text file if it exists
     * 
     */
    public boolean deleteCustomer(String user) {
        try{
            if (Files.deleteIfExists(Paths.get(user + ".txt"))){
                System.out.println("success");
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Cannot find file");
            
        }
        return false;
    }
}
