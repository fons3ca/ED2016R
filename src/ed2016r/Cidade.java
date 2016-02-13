/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2016r;

/**
 *
 * @author n_fon
 */
public class Cidade {
    private String nome;
    private double defesas;
    private boolean conquistada;

    public Cidade(String nome, int defesas) {
        this.nome = nome;
        this.defesas = defesas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDefesas() {
        return defesas;
    }

    public void setDefesas(int defesas) {
        this.defesas = defesas;
    }

    public boolean isConquistada() {
        return conquistada;
    }

    public void setConquistada(boolean conquistada) {
        this.conquistada = conquistada;
    }

    @Override
    public String toString() {
        return "" + this.nome + '\n';
    }
    
    
    
}
