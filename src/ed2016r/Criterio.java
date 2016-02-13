/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2016r;

/**
 *
 * @author Utilizador
 */
public class Criterio {
    private double duracaoTotal;
    private double custoMaximo;
    private double perdasCombate;
    private int numeroCombates;

    public Criterio(double duracaoTotal, double custoMaximo, double perdasCombate, int numeroCombates) {
        this.duracaoTotal = duracaoTotal;
        this.custoMaximo = custoMaximo;
        this.perdasCombate = perdasCombate;
        this.numeroCombates = numeroCombates;
    }

    public double getDuracaoTotal() {
        return duracaoTotal;
    }

    public void setDuracaoTotal(double duracaoTotal) {
        this.duracaoTotal = duracaoTotal;
    }

    public double getCustoMaximo() {
        return custoMaximo;
    }

    public void setCustoMaximo(double custoMaximo) {
        this.custoMaximo = custoMaximo;
    }

    public double getPerdasCombate() {
        return perdasCombate;
    }

    public void setPerdasCombate(double perdasCombate) {
        this.perdasCombate = perdasCombate;
    }

    public int getNumeroCombates() {
        return numeroCombates;
    }

    public void setNumeroCombates(int numeroCombates) {
        this.numeroCombates = numeroCombates;
    }
    
    public void setCriterios() {
        GameOfThrones got = new GameOfThrones();
        got.printCriterias();
        got.printDurationLine();
        got.readDouble();
        this.setDuracaoTotal(got.getValue());
        got.printMaxCostLine();
        this.setCustoMaximo(got.getValue());
        got.printLossPerCombatLine();
        this.setPerdasCombate(got.getValue());
        got.printMaxCombatsLine();
        this.setNumeroCombates((int) got.getValue());
    }
    
}
