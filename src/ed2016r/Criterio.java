
package ed2016r;

/**
 * Classe Critério que guarda os Critérios a ser usados para calcular os shortest paths.
 * @author Tiago Fernandes - 8120152
 * @author Nuno Fonseca - 8120116
 */
public class Criterio {
    private double duracaoTotal;
    private double custoMaximo;
    private double perdasCombate;
    private int numeroCombates;

    /**
     * Método construtor para instanciar a classe Critério.
     * @param duracaoTotal Duração Total do critério.
     * @param custoMaximo Custo Máximo do critério.
     * @param perdasCombate Perdas Máximas em Combate do critério.
     * @param numeroCombates Número Máximo de Combates do critério.
     */
    public Criterio(double duracaoTotal, double custoMaximo, double perdasCombate, int numeroCombates) {
        this.duracaoTotal = duracaoTotal;
        this.custoMaximo = custoMaximo;
        this.perdasCombate = perdasCombate;
        this.numeroCombates = numeroCombates;
    }

    /**
     * Método que devolve a duracao de um Critério.
     * @return Retorna a duracao de um Critério.
     */
    public double getDuracaoTotal() {
        return duracaoTotal;
    }

    /**
     * Método que altera a Duracao Total de um Critério.
     * @param duracaoTotal Valor para o qual vai ser alterado.
     */
    public void setDuracaoTotal(double duracaoTotal) {
        this.duracaoTotal = duracaoTotal;
    }

    /**
     * Método que devolve o Custo Maximo de um Critério.
     * @return Retorna o Custo Maximo de um Critério.
     */
    public double getCustoMaximo() {
        return custoMaximo;
    }

    /**
     * Método que altera o Custo Maximo de um Critério.
     * @param custoMaximo Valor para o qual vai ser alterado.
     */
    public void setCustoMaximo(double custoMaximo) {
        this.custoMaximo = custoMaximo;
    }

    /**
     * Método que devolve as Perdas Maximas em Combate de um Critério.
     * @return Retorna as Perdas Maximas de um Critério.
     */
    public double getPerdasCombate() {
        return perdasCombate;
    }

    /**
     * Método que altera as Perdas Maximas em Combate de um Critério.
     * @param perdasCombate Valor para o qual vai ser alterado.
     */
    public void setPerdasCombate(double perdasCombate) {
        this.perdasCombate = perdasCombate;
    }

    /**
     * Método que devolve o Numero Maximo de Combates de um Critério.
     * @return Retorna o Numero Maximo de Combates de um Critério.
     */
    public int getNumeroCombates() {
        return numeroCombates;
    }

    /**
     * Método que altera o Numero Maximo de Combates de um Critério.
     * @param numeroCombates Valor para o qual vai ser alterado.
     */
    public void setNumeroCombates(int numeroCombates) {
        this.numeroCombates = numeroCombates;
    }
    
}
