
package ed2016r;

/**
 * Classe Alternativa que guarda informação de uma Alternativa.
 * @author Tiago Fernandes - 8120152
 * @author Nuno Fonseca - 8120116
 */
public class Alternativa {

    private String nome;
    private int distancia;
    private double duracao;
    private double custo;

    /**
     * Método construtor para instanciar a classe Alternativa.
     * @param nome Nome da Alternativa
     * @param distancia Distancia da Alternativa
     * @param duracao Duracao da Alternativa
     * @param custo Custo da Alternativa
     */
    public Alternativa(String nome, int distancia, double duracao, double custo) {
        this.nome = nome;
        this.distancia = distancia;
        this.duracao = duracao;
        this.custo = custo;
    }

    /**
     * Método que devolve a distancia de uma Alternativa.
     * @return Retorna a distancia de uma Alternativa.
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * Método que altera a distancia de uma Alternativa.
     * @param distancia Valor para o qual vai ser alterado.
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    /**
     * Método que devolve a duracao de uma Alternativa.
     * @return Retorna a duracao de uma Alternativa.
     */
    public double getDuracao() {
        return duracao;
    }

    /**
     * Método que altera a distancia de uma Alternativa.
     * @param duracao Valor para o qual vai ser alterado.
     */
    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    /**
     * Método que devolve o custo de uma Alternativa.
     * @return Retorna o custo de uma Alternativa.
     */
    public double getCusto() {
        return custo;
    }

    /**
     * Método que altera o custo de uma Alternativa.
     * @param custo Valor para o qual vai ser alterado.
     */
    public void setCusto(double custo) {
        this.custo = custo;
    }

    /**
     * Método que devolve o nome de uma Alternativa.
     * @return Retorna o nome de uma Alternativa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que altera o nome de uma Alternativa.
     * @param nome Valor para o qual vai ser alterado.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna uma string com os valores de uma Alternativa.
     * @return Retorna uma string com os valores de uma Alternativa.
     */
    @Override
    public String toString() {
        return nome + "\n      distancia=" + distancia + "\n      duracao=" + duracao + "\n      custo=" + custo + "\n";
    }

}
