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
public class Alternativa {
    
    private int distancia;
    private double duracao;
    private double custo;

    public Alternativa(int distancia, double duracao, double custo) {
        this.distancia = distancia;
        this.duracao = duracao;
        this.custo = custo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
    
    
}
