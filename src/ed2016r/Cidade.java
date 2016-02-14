
package ed2016r;

/**
 * Classe Cidade que guarda informação de uma Cidade.
 * @author Tiago Fernandes - 8120152
 * @author Nuno Fonseca - 8120116
 */
public class Cidade {
    private String nome;
    private double defesas;
    private boolean conquistada;

    /**
     * Método construtor para instanciar a classe Cidade.
     * @param nome Nome da Cidade
     * @param defesas Defesas da Cidade
     */
    public Cidade(String nome, int defesas) {
        this.nome = nome;
        this.defesas = defesas;
    }

    /**
     * Método que devolve o nome de uma Cidade.
     * @return Retorna o nome de uma Cidade.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que altera o nome de uma Cidade.
     * @param nome Valor para o qual vai ser alterado.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que devolve as defesas de uma Cidade.
     * @return Retorna as defesas de uma Cidade.
     */
    public double getDefesas() {
        return defesas;
    }

    /**
     * Método que altera as defesas de uma Cidade.
     * @param defesas Valor para o qual vai ser alterado.
     */
    public void setDefesas(int defesas) {
        this.defesas = defesas;
    }

    /**
     * Método que retorna true se a Cidade estiver conquistada e false se a Cidade não estiver conquistada.
     * @return Retorna true se conquistada || false se não estiver conquistada.
     */
    public boolean isConquistada() {
        return conquistada;
    }

    /**
     * Método que altera o estado da Cidade de conquistada para não conquistada, ou vice-versa.
     * @param conquistada Valor para o qual vai ser alterado.
     */
    public void setConquistada(boolean conquistada) {
        this.conquistada = conquistada;
    }

    /**
     * Método que retorna uma string com os valores de uma Cidade.
     * @return Retorna uma string com os valores de uma Cidade.
     */
    @Override
    public String toString() {
        return "" + this.nome;
    }
    
    
    
}
