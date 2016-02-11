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
    private double numeroCombates;

    public Criterio(double duracaoTotal, double custoMaximo, double perdasCombate, double numeroCombates) {
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

    public double getNumeroCombates() {
        return numeroCombates;
    }

    public void setNumeroCombates(double numeroCombates) {
        this.numeroCombates = numeroCombates;
    }
    
    
    
}
