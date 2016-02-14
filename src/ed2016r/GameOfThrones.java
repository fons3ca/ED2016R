
package ed2016r;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Classe Game of Thrones que guarda variaveis uteis para os inputs.
 * @author Tiago Fernandes - 8120152
 * @author Nuno Fonseca - 8120116
 */
public class GameOfThrones {

    final static String INVALID_OPTION = "Please enter a valid option!";
    final static String INVALID_VALUE = "Please enter a valid value!";
    
    private int opt;
    private double value;
    private int troops;
    private String string;

    private InputStreamReader istream;
    private BufferedReader bufRead;

    /**
     * Método construtor que instancia a Classe Game of Thrones.
     */
    public GameOfThrones() {
        istream = new InputStreamReader(System.in);
        bufRead = new BufferedReader(istream);
        this.opt = -1;
    }

    /**
     * Método que devolve a opção.
     * @return Retorna a opção.
     */
    public int getOpt() {
        return opt;
    }

    /**
     * Método que devolve um valor do tipo double. (Usado para a leitura de valores).
     * @return Retorna um valor do tipo Double.
     */
    public double getValue() {
        return value;
    }
    
    /**
     * Método que devolve o número de tropas do utilizador.
     * @return Retorna o número de tropas do utilizador.
     */
    public int getTropas() {
        return troops;
    }
    
    /**
     * Método que retorna uma string.
     * @return Retorna uma string.
     */
    public String getString() {
        return string;
    }

    /**
     * Método que altera o número de tropas do utilizador.
     * @param troops Valor para o qual vai ser alterado.
     */
    public void setTroops(int troops) {
        this.troops = troops;
    }
    
    /**
     * Método de leitura de uma opção.
     */
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
    
    /**
     * Método de leitura de um Double.
     */
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
    
    /**
     * Método de leitura do número de tropas.
     */
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
    
    /**
     * Método de leitura de uma String.
     */
    public void readString() {
        String s;
        try {
            s = bufRead.readLine();
            this.string = s;
        } catch(Exception ex) {
            System.out.println(INVALID_VALUE);
            readString();
        }
    }

    /**
     * Método que Altera o número de tropas.
     */
    public void editTroops() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+++++++  EDITING TROOPS +++++++");
        System.out.println("+ Insert your starting troops +");
        readTroops();
    }
    
    /**************************************************************
     * Métodos que imprimem partes do Menu.
     **************************************************************/
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
    
    public void printNumAlternatives() {
        System.out.println(" --How many alternatives: ");
    }
    
    public void initialMenu() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+      Game OF <T>hrones      +");
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
        System.out.println("+ 1. Min Duration             +");
        System.out.println("+ 2. Min Troops Lost          +");
        System.out.println("+ 3. Min Losses Per Combat    +");
        System.out.println("+ 4. Min Combats              +");
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
