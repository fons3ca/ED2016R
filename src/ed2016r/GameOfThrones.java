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

    private int opt;
    private InputStreamReader istream;
    private BufferedReader bufRead;

    public GameOfThrones() {
        istream = new InputStreamReader(System.in);
        bufRead = new BufferedReader(istream);
        this.opt = opt=-1;
    }

    public int getOpt() {
        return opt;
    }

    public void readOption() {
        String a;
        try {
            a = bufRead.readLine();
            this.opt = Integer.parseInt(a);
        } catch (Exception ex) {
            System.out.println("Plese chose a valid option!");
            readOption();
        }
    }

    public void initialMenu() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+            MENU             +");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+ 1. Start game               +");
        System.out.println("+ 2. Change game values       +");
        System.out.println("+++++++++++++++++++++++++++++++");
    }

    public void startGameManu() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+        Game Started         +");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+ 1. Conquer Simulator        +");
        System.out.println("+ 2. Iniciar conquista        +");
        System.out.println("+++++++++++++++++++++++++++++++");
    }
}
