/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2016r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author n_fon
 */
public class GameOfThrones {

    final static String INVALID_OPTION = "Please enter a valid option!";
    final static String INVALID_VALUE = "Please enter a valid value!";
    
    private int opt;
    private double value;
    private int troops;

    private InputStreamReader istream;
    private BufferedReader bufRead;

    public GameOfThrones() {
        istream = new InputStreamReader(System.in);
        bufRead = new BufferedReader(istream);
        this.opt = -1;
    }

    public int getOpt() {
        return opt;
    }

    public double getValue() {
        return value;
    }
    
    public int getTropas() {
        return troops;
    }

    public void setTroops(int troops) {
        this.troops = troops;
    }
    
    public void readOption() {
        String s;
        try {
            System.out.print("Read Option: ");
            s = bufRead.readLine();
            this.opt = Integer.parseInt(s);
        } catch (Exception ex) {
            System.out.println(INVALID_OPTION);
            readOption();
        }
    }
    
    public void readDouble() {
        String s;
        try {
            System.out.print(" Value: ");
            s = bufRead.readLine();
            this.value = Double.parseDouble(s);
        } catch(Exception ex) {
            System.out.println(INVALID_VALUE);
            readDouble();
        }
    }
    
    public void readTroops() {
        String s;
        try {
            System.out.print(" Starting Troops: ");
            s = bufRead.readLine();
            this.troops = Integer.parseInt(s);
        } catch(Exception ex) {
            System.out.println(INVALID_VALUE);
            readTroops();
        }
    }

    public void printCriterias() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+      PATHS BY CRITERIAS     +");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("++    SET -1 IF NOT NEEDED    +");
        System.out.println("+++++++++++++++++++++++++++++++");
    }
    
    public void printDurationLine() {
        System.out.println(" --Duration:");
    }
    
    public void printMaxCostLine() {
        System.out.println(" --Max Cost:");
    }
    
    public void printLossPerCombatLine() {
        System.out.println(" --LossPerCombat:");
    }
    
    public void printMaxCombatsLine() {
        System.out.println(" --MaxCombats:");
    }
    
    public void editTroops() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+++++++  EDITING TROOPS +++++++");
        System.out.println("+ Insert your starting troops +");
        readTroops();
    }
    
    public void initialMenu() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+             MENU            +");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+ 1. Start game               +");
        System.out.println("+ 2. Change game values       +");
        System.out.println("+ 3. Exit                     +");
        System.out.println("+++++++++++++++++++++++++++++++");
    }

    public void startGameMenu() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+        Game Started         +");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+ 1. Simulate                 +");
        System.out.println("+ 2. Conquer                  +");
        System.out.println("+ 3. Back                     +");
        System.out.println("+++++++++++++++++++++++++++++++");
    }
    
    public void simMenu() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+        Simulate  Menu       +");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+ --Show paths by:            +");
        System.out.println("+ 1. Duration                 +");
        System.out.println("+ 2. Max Troops Lost          +");
        System.out.println("+ 3. Losses Per Combat        +");
        System.out.println("+ 4. Max Combats              +");
        System.out.println("+ 5. More than one Criteria   +");
        System.out.println("+ 6. Back                     +");
        System.out.println("+++++++++++++++++++++++++++++++");
    }
    
    public void editGameMenu() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+       Edit Game Values      +");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+ 1. Edit Starting Troops     +");
        System.out.println("+ 2. Edit City                +");
        System.out.println("+ 3. Edit Path                +");
        System.out.println("+ 4. Back                     +");
        System.out.println("+++++++++++++++++++++++++++++++");
    }
    
    public void editCityMenu() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+          Edit City          +");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+ 1. Edit Name                +");
        System.out.println("+ 2. Edit Defenses            +");
        System.out.println("+ 3. Back                     +");
        System.out.println("+++++++++++++++++++++++++++++++");
    }
    
    public void editPathMenu() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+          Edit Path          +");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+ 1. Edit Distance            +");
        System.out.println("+ 2. Edit Duration            +");
        System.out.println("+ 3. Edit Cost                +");
        System.out.println("+ 4. Back                     +");
        System.out.println("+++++++++++++++++++++++++++++++");
    }
    
}
