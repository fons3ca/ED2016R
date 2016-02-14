
package ed2016r;

import List.ArrayUnorderedList;
import Graph.*;

import java.util.Iterator;

/**
 * @author Tiago Fernandes - 8120152
 * @author Nuno Fonseca - 8120116
 */
public class Map extends Graph<Cidade> implements MapADT<Cidade> {

    protected ArrayUnorderedList<Alternativa>[][] wAdjMatrix;
    private boolean[] visited;      // to remember visit
    private ArrayUnorderedList<Integer> al;
    private int size;

    /**
     * Método construtor de Map
     */
    public Map() {
        super();
        this.wAdjMatrix = new ArrayUnorderedList[super.DEFAULT_CAPACITY][super.DEFAULT_CAPACITY];
        this.al = new ArrayUnorderedList<>();
        super.vertices = new Cidade[10];

    }

    /**
     * Adiciona um caminho entre duas cidades
     * @param index1 index da cidade
     * @param index2 index da cidade destino
     * @param alt
     */
    public void addEdge(int index1, int index2, Alternativa alt) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            wAdjMatrix[index1][index2].addRear(alt);
            wAdjMatrix[index2][index1].addRear(alt);
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }

    /**
     * Se existe estes vertices envia para AddEdge os indexs
     * @param vertex1 
     * @param vertex2
     * @param alt
     */
    @Override
    public void addEdge(Cidade vertex1, Cidade vertex2, Alternativa alt) {
        addEdge(getIndex(vertex1), getIndex(vertex2), alt);
    }

    /**
     * Adiciona uma cidade
     * @param vertex cidade a adicionar
     */
    @Override
    public void addVertex(Cidade vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }

        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            wAdjMatrix[numVertices][i] = new ArrayUnorderedList<>();
            wAdjMatrix[i][numVertices] = new ArrayUnorderedList<>();
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    /**
     * Remove um vertex (Cidade)
     * @param index posicao a remover.
     */
    public void removeVertex(int index) {
        if (indexIsValid(index)) {
            numVertices--;

            for (int i = index; i < numVertices; i++) {
                vertices[i] = vertices[i + 1];
            }

            for (int i = index; i < numVertices; i++) {
                for (int j = 0; j <= numVertices; j++) {
                    wAdjMatrix[i][j] = wAdjMatrix[i + 1][j];
                    adjMatrix[i][j] = adjMatrix[i + 1][j];
                }
            }
            for (int i = index; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    wAdjMatrix[j][i] = wAdjMatrix[j][i + 1];
                    adjMatrix[i][j] = adjMatrix[i + 1][j];
                }
            }
        }
    }

    /**
     * Método que procura o vertex (Cidade) e se existir chama removeVertex(i)
     * @param vertex Cidade a remover.
     */
    @Override
    public void removeVertex(Cidade vertex) {
        for (int i = 0; i < numVertices; i++) {
            if (vertex.equals(vertices[i])) {
                removeVertex(i);
                return;
            }
        }
    }

    /**
     * Método que envia os indexes de duas cidade para o método removeEdge para remover.
     * @param vertex1 Cidade inicio.
     * @param vertex2 Cidade destino.
     */
    @Override
    public void removeEdge(Cidade vertex1, Cidade vertex2) {
        this.removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * Método que remove o caminho entre duas Cidades
     * @param index1 Index da Cidade incial
     * @param index2 Index da Cidade Destino
     */
    @Override
    public void removeEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
            wAdjMatrix[index1][index2] = null;
            wAdjMatrix[index2][index1] = null;
        }
    }

    /**
     * Método que retorna todos as Cidades.
     * @return 
     */
    public Cidade[] getVertices() {
        return vertices;
    }
    
    /**
     * Método que retorna a cidade na posição "i"
     * @param i Posição da cidade a retornar.
     * @return Retorna a cidade na posição "i".
     */
    public Cidade getCidadeAt(int i) {
        return this.vertices[i];
    }

    /**
     * @param source cidade de inicio dos caminhos
     * @param destination cidade de destino dos caminhos
     * @return Lista nao ordenada de listas nao ordenadas de integers que
     * representam index de cidades
     */
    public ArrayUnorderedList<ArrayUnorderedList<Integer>> dfsAllPaths(Cidade source, Cidade destination) {
        al = new ArrayUnorderedList<>();
        this.size = 0;
        visited = new boolean[this.numVertices + 1];
        for (int i = 0; i < visited.length; i++) {
            this.visited[i] = false;
        }
        ArrayUnorderedList<ArrayUnorderedList<Integer>> resultQueue = new ArrayUnorderedList<>();
        dfsAllPathsR(getIndex(source), getIndex(destination), resultQueue);
        return resultQueue;
    }
    
    /**
     * 
     * @param src
     * @param dst
     * @param resultQueue 
     */
    private void dfsAllPathsR(int src, int dst, ArrayUnorderedList<ArrayUnorderedList<Integer>> resultQueue) {
        al.addRear(src);
        size++;
        visited[src] = true;
        if (src == dst) {       // tests for base condition to stop
            //System.out.println("Find destination");
            ArrayUnorderedList<Integer> path = new ArrayUnorderedList<>();
            for (Integer i : al) {
                //introduzir numa lista
                path.addRear(i);
            }
            resultQueue.addRear(path);
            return;
        }
        for (int I = 0; I < this.numVertices; I++) {
            if (adjMatrix[src][I] == true) {
                if (visited[I] == false) {
                    dfsAllPathsR(I, dst, resultQueue);
                    visited[I] = false;
                    size--;
                    al.removeIndex(size);
                }
            }
        }
    }

    /**
     * Método que retorna um ArrayUnorderedList de ArrayUnorderedList de Objects
     * ordenado pelo minimo de tropas perdidas.
     * @param numPaths Número de Alternativas que o utilizador pretende.
     * @param allpaths Todos os caminhos de uma Cidade inicial a uma Cidade destino.
     * @return Retorna ArrayUnorderedList de ArrayUnorderedList de Objects 
     * ordenado pelo minimo de tropas perdidas.
     */
    public ArrayUnorderedList<ArrayUnorderedList<Object>> shortestPathsByLessTroopLosses(int numPaths, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        if (allpaths.isEmpty()) {
            return new ArrayUnorderedList<>();
        }
        if(numPaths >= allpaths.size()) {
            numPaths = allpaths.size();
        }
        ArrayUnorderedList<ArrayUnorderedList<Integer>> resultPathOnly = new ArrayUnorderedList<>();
        ArrayUnorderedList<ArrayUnorderedList<Object>> result = new ArrayUnorderedList<>();
        ArrayUnorderedList<Object> resultPA = new ArrayUnorderedList<>();
        double cost = 0;
        for (int i = 0; i < numPaths; i++) {
            ArrayUnorderedList<Integer> bestPath = shortestPathByLessTroopLossesIndexes(allpaths);
            allpaths.remove(bestPath);
            resultPathOnly.addRear(bestPath);
        }

        Iterator it = resultPathOnly.iterator();
        while (it.hasNext()) {
            ArrayUnorderedList<Integer> current = (ArrayUnorderedList<Integer>) it.next();
            Iterator currentPI = current.iterator();
            int cur, next;
            cur = (int) currentPI.next();
            next = cur;
            resultPA.addRear(vertices[cur]);
            do {
                if(currentPI.hasNext()) {
                    next = (int) currentPI.next();
                }
                if(!this.wAdjMatrix[cur][next].isEmpty()) {
                    //num de tropas perdidas na viagem pela alternativa 1
                    double pathlosses1 = (this.wAdjMatrix[cur][next].first().getCusto()) * (this.wAdjMatrix[cur][next].first().getDistancia());
                    //num de tropas perdidas na viagem pela alternativa 2
                    double pathlosses2 = (this.wAdjMatrix[cur][next].last().getCusto()) * (this.wAdjMatrix[cur][next].last().getDistancia());
                    //num tropas perdidas no combate
                    double perdasCombate = (Math.pow((this.vertices[next].getDefesas() / 10), 1.8)) * 100;
                    if(this.vertices[next].isConquistada()) {
                        perdasCombate = 0;
                    }
                    if (pathlosses2 <= pathlosses1) {
                        cost += pathlosses2;
                        cost += perdasCombate;
                        resultPA.addRear(this.wAdjMatrix[cur][next].last());
                    } else {
                        cost += pathlosses1;
                        cost += perdasCombate;
                        resultPA.addRear(this.wAdjMatrix[cur][next].first());
                    }
                }
                resultPA.addRear(vertices[next]);
                cur = next;
            } while (currentPI.hasNext());
            result.addRear(resultPA);
            System.out.println("Path Cost: " + cost);
            resultPA = new ArrayUnorderedList<>();
            cost = 0;
        }

        return result;
    }
    
    /**
     * 
     * @param allpaths
     * @return 
     */
    private ArrayUnorderedList<Integer> shortestPathByLessTroopLossesIndexes(ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        Iterator allpathsIt = allpaths.iterator();
        ArrayUnorderedList<Integer> bestPath = null;
        int cur;
        int next;
        double cost = 0;
        double costOptimum = Double.MAX_VALUE;
        while (allpathsIt.hasNext()) {
            ArrayUnorderedList<Integer> currentPath = (ArrayUnorderedList<Integer>) allpathsIt.next();
            Iterator currentPathIt = currentPath.iterator();
            cur = (int) currentPathIt.next();
            next = cur;
            do {
                if (currentPathIt.hasNext()) {
                next = (int) currentPathIt.next();
                }
                if(!this.wAdjMatrix[cur][next].isEmpty()) {
                    //num de tropas perdidas na viagem pela alternativa 1
                    double pathlosses1 = (this.wAdjMatrix[cur][next].first().getCusto()) * (this.wAdjMatrix[cur][next].first().getDistancia());
                    //num de tropas perdidas na viagem pela alternativa 2
                    double pathlosses2 = (this.wAdjMatrix[cur][next].last().getCusto()) * (this.wAdjMatrix[cur][next].last().getDistancia());
                    //num tropas perdidas no combate
                    double perdasCombate = (Math.pow((this.vertices[next].getDefesas() / 10), 1.8)) * 100;
                    if(this.vertices[next].isConquistada()) {
                        perdasCombate = 0;
                    }
                    if (pathlosses2 <= pathlosses1) {
                        cost += pathlosses2;
                        cost += perdasCombate;
                    } else {
                        cost += pathlosses1;
                        cost += perdasCombate;
                    }
                }
                cur = next;
            } while (currentPathIt.hasNext());

            if (costOptimum > cost) {
                costOptimum = cost;
                bestPath = currentPath;
            }
            cost = 0;
        }
        return bestPath;
    }

    /**
     * Método que retorna um ArrayUnorderedList de ArrayUnorderedList de Objects
     * ordenado pelo minimo de tropas perdidas por combate individual.
     * @param numPaths Número de Alternativas que o utilizador pretende.
     * @param allpaths Todos os caminhos de uma Cidade inicial a uma Cidade destino.
     * @return Retorna ArrayUnorderedList de ArrayUnorderedList de Objects 
     * ordenado pelo minimo de tropas perdidas por combate individual.
     */
    public ArrayUnorderedList<ArrayUnorderedList<Object>> shortestPathsByMinCombatLosses(int numPaths, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        if (allpaths.isEmpty()) {
            return new ArrayUnorderedList<>();
        }
        if (numPaths >= allpaths.size()) {
            numPaths = allpaths.size();
        }
        ArrayUnorderedList<ArrayUnorderedList<Integer>> resultPathOnly = new ArrayUnorderedList<>();
        ArrayUnorderedList<ArrayUnorderedList<Object>> result = new ArrayUnorderedList<>();
        ArrayUnorderedList<Object> resultPA = new ArrayUnorderedList<>();
        double cost = 0;
        for (int i = 0; i < numPaths; i++) {
            ArrayUnorderedList<Integer> bestPath = shortestPathByMinCombatLossesIndexes(allpaths);
            allpaths.remove(bestPath);
            resultPathOnly.addRear(bestPath);
        }

        Iterator it = resultPathOnly.iterator();
        while (it.hasNext()) {
            ArrayUnorderedList<Integer> current = (ArrayUnorderedList<Integer>) it.next();
            Iterator currentPI = current.iterator();
            int cur, next;
            cur = (int) currentPI.next();
            next = cur;
            resultPA.addRear(vertices[cur]);
            do {
                if (currentPI.hasNext()) {
                    next = (int) currentPI.next();
                }

                //num de tropas perdidas na viagem pela alternativa 1
                double pathlosses1 = (this.wAdjMatrix[cur][next].first().getCusto()) * (this.wAdjMatrix[cur][next].first().getDistancia());
                //num de tropas perdidas na viagem pela alternativa 2
                double pathlosses2 = (this.wAdjMatrix[cur][next].last().getCusto()) * (this.wAdjMatrix[cur][next].last().getDistancia());
                //num tropas perdidas no combate
                double perdasCombate = (Math.pow((this.vertices[next].getDefesas() / 10), 1.8)) * 100;
                if (pathlosses2 <= pathlosses1) {
                    cost += pathlosses2;
                    cost += perdasCombate;
                    resultPA.addRear(this.wAdjMatrix[cur][next].last());
                } else {
                    cost += pathlosses1;
                    cost += perdasCombate;
                    resultPA.addRear(this.wAdjMatrix[cur][next].first());
                }

                resultPA.addRear(vertices[next]);
                cur = next;
            } while (currentPI.hasNext());
            result.addRear(resultPA);
            System.out.println("Path Cost: " + cost);
            resultPA = new ArrayUnorderedList<>();
            cost = 0;
        }

        return result;
    }

    /**
     * 
     * @param allpaths
     * @return 
     */
    private ArrayUnorderedList<Integer> shortestPathByMinCombatLossesIndexes(ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        Iterator allpathsIt = allpaths.iterator();
        ArrayUnorderedList<Integer> bestPath = null;
        int cur;
        int next;
        double currentCityCost = 0;
        double maxCostInPath = -1;
        double bestCost = Double.MAX_VALUE;

        while (allpathsIt.hasNext()) {
            ArrayUnorderedList<Integer> currentPath = (ArrayUnorderedList<Integer>) allpathsIt.next();
            Iterator currentPathIt = currentPath.iterator();
            cur = (int) currentPathIt.next();
            next = cur;
            do {
                if (currentPathIt.hasNext()) {
                    next = (int) currentPathIt.next();
                }
                //num de tropas perdidas na viagem pela alternativa 1
                double pathlosses1 = (this.wAdjMatrix[cur][next].first().getCusto()) * (this.wAdjMatrix[cur][next].first().getDistancia());
                //num de tropas perdidas na viagem pela alternativa 2
                double pathlosses2 = (this.wAdjMatrix[cur][next].last().getCusto()) * (this.wAdjMatrix[cur][next].last().getDistancia());
                //num tropas perdidas no combate
                currentCityCost = (Math.pow((this.vertices[next].getDefesas() / 10), 1.8)) * 100;
                if(this.getCidadeAt(next).isConquistada()){
                    currentCityCost=0;
                }
                if (maxCostInPath <= currentCityCost) {
                    maxCostInPath = currentCityCost;
                }
                cur = next;
            } while (currentPathIt.hasNext());

            if (bestCost > maxCostInPath) {
                bestPath = currentPath;
                
            }
            maxCostInPath = 0;
        }
        return bestPath;
    }
    
    /**
     * Método que retorna um ArrayUnorderedList de ArrayUnorderedList de Objects
     * ordenado pelo minimo de combates.
     * @param numPaths Número de Alternativas que o utilizador pretende.
     * @param allpaths Todos os caminhos de uma Cidade inicial a uma Cidade destino.
     * @return Retorna ArrayUnorderedList de ArrayUnorderedList de Objects 
     * ordenado pelo minimo de combates.
     */
    public ArrayUnorderedList<ArrayUnorderedList<Object>> shortestPathsByMinCombats(int numPaths, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        if (allpaths.isEmpty()) {
            return new ArrayUnorderedList<>();
        }
        if(numPaths >= allpaths.size()) {
            numPaths = allpaths.size();
        }
        ArrayUnorderedList<ArrayUnorderedList<Integer>> resultPathOnly = new ArrayUnorderedList<>();
        ArrayUnorderedList<ArrayUnorderedList<Object>> result = new ArrayUnorderedList<>();
        ArrayUnorderedList<Object> resultPA = new ArrayUnorderedList<>();
        double cost = 0;
        for (int i = 0; i < numPaths; i++) {
            ArrayUnorderedList<Integer> bestPath = shortestPathByMinCombatsIndexes(allpaths);
            allpaths.remove(bestPath);
            resultPathOnly.addRear(bestPath);
        }

        Iterator it = resultPathOnly.iterator();
        while (it.hasNext()) {
            ArrayUnorderedList<Integer> current = (ArrayUnorderedList<Integer>) it.next();
            Iterator currentPI = current.iterator();
            int cur, next;
            cur = (int) currentPI.next();
            next = cur;
            resultPA.addRear(vertices[cur]);
            do {
                if(currentPI.hasNext()) {
                    next = (int) currentPI.next();
                }
                if(!this.wAdjMatrix[cur][next].isEmpty()) {
                    //num de tropas perdidas na viagem pela alternativa 1
                    double pathlosses1 = (this.wAdjMatrix[cur][next].first().getCusto()) * (this.wAdjMatrix[cur][next].first().getDistancia());
                    //num de tropas perdidas na viagem pela alternativa 2
                    double pathlosses2 = (this.wAdjMatrix[cur][next].last().getCusto()) * (this.wAdjMatrix[cur][next].last().getDistancia());
                    //num tropas perdidas no combate
                    if (pathlosses2 <= pathlosses1) {
                        cost += pathlosses2;
                        resultPA.addRear(this.wAdjMatrix[cur][next].last());
                    } else {
                        cost += pathlosses1;
                        resultPA.addRear(this.wAdjMatrix[cur][next].first());
                    }
                }
                resultPA.addRear(vertices[next]);
                cur = next;
            } while (currentPI.hasNext());
            result.addRear(resultPA);
            System.out.println("Path Cost: " + cost);
            resultPA = new ArrayUnorderedList<>();
            cost = 0;
        }

        return result;
    }
    
    /**
     * 
     * @param allpaths
     * @return 
     */
    private ArrayUnorderedList<Integer> shortestPathByMinCombatsIndexes(ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        Iterator allpathsIt = allpaths.iterator();
        ArrayUnorderedList<Integer> bestPath = null;
        int cur;
        int next;
        int cost = 0;
        
        double costOptimum = Double.MAX_VALUE;
        while (allpathsIt.hasNext()) {
            ArrayUnorderedList<Integer> currentPath = (ArrayUnorderedList<Integer>) allpathsIt.next();
            Iterator currentPathIt = currentPath.iterator();
            cur = (int) currentPathIt.next();
            next = cur;
            do {
                if (currentPathIt.hasNext()) {
                next = (int) currentPathIt.next();
                }
                if(!this.vertices[next].isConquistada()) {
                    cost++;
                }
                
                cur = next;
            } while (currentPathIt.hasNext());

            if (costOptimum > cost) {
                costOptimum = cost;
                bestPath = currentPath;
            }
            cost = 0;
        }
        return bestPath;
    }

    /**
     * Método que verifica se uma cidade pode ser conquistada.
     * @param caminho Caminho de uma Cidade inicial a uma Cidade destino.
     * @param tropas Tropas que o utilizador possui.
     * @return retorna calculo das tropas sobreviventes depois de percorrer um caminho
     */
    public int canConquer(ArrayUnorderedList<Integer> caminho, int tropas) {
        if (!vertices[(int) caminho.first()].isConquistada()) {
            System.out.println("A cidade de inicio ainda nao foi conquistada!!");
            return -1;
        }

        Iterator it = caminho.iterator();
        double custo = 0;

        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof Cidade) {
                double def = ((Cidade) obj).getDefesas();
                custo += (Math.pow((((Cidade) obj).getDefesas() / 10), 1.8)) * 100;
            } else if (obj instanceof Alternativa) {
                double altCost = ((Alternativa) obj).getCusto() * ((Alternativa) obj).getDistancia();
                custo += altCost;
            }
        }
        return (int) (tropas - custo);
    }

    /**
     * Método que conquista todas as cidades num determinado caminho, se no final
     * restarem sobreviventes.
     * @param caminho a ser conquistado
     * @param tropas num de tropas que o vao percorrer
     * @return tropas sobreviventes ou -1 se nao foi possivel conquistar
     */
    public int conquerPath(ArrayUnorderedList<Integer> caminho, int tropas) {
        int survivors = canConquer(caminho, tropas);
        if (survivors >= 0) {
            Iterator it = caminho.iterator();
            while (it.hasNext()) {
                int cur = (int) it.next();
                vertices[cur].setConquistada(true);
            }
        }

        return survivors;
    }

    
    /**
     * 
     * @param numPaths numero de caminhos pretendidos
     * @param allpaths
     * @return os n melhores caminhos em relacao a duracao em dias ja com as alternativas escolhidas
     */
    public ArrayUnorderedList<ArrayUnorderedList<Object>> shortestPathsByMinDuration(int numPaths, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        if (allpaths.isEmpty()) {
            return new ArrayUnorderedList<>();
        }
        if(numPaths >= allpaths.size()) {
            numPaths = allpaths.size();
        }
        ArrayUnorderedList<ArrayUnorderedList<Integer>> resultPathOnly = new ArrayUnorderedList<>();
        ArrayUnorderedList<ArrayUnorderedList<Object>> result = new ArrayUnorderedList<>();
        ArrayUnorderedList<Object> resultPA = new ArrayUnorderedList<>();
        double cost = 0;
        for (int i = 0; i < numPaths; i++) {
            ArrayUnorderedList<Integer> bestPath = shortestPathByMinDurationIndexes(allpaths);
            allpaths.remove(bestPath);
            resultPathOnly.addRear(bestPath);
        }

        Iterator it = resultPathOnly.iterator();
        while (it.hasNext()) {
            ArrayUnorderedList<Integer> current = (ArrayUnorderedList<Integer>) it.next();
            Iterator currentPI = current.iterator();
            int cur, next;
            cur = (int) currentPI.next();
            next = cur;
            resultPA.addRear(vertices[cur]);
            do {
                if (currentPI.hasNext()) {
                    next = (int) currentPI.next();
                }
                if (this.wAdjMatrix[cur][next].first().getDuracao() > this.wAdjMatrix[cur][next].last().getDuracao()) {
                    resultPA.addRear(this.wAdjMatrix[cur][next].last());
                    cost += wAdjMatrix[cur][next].last().getDuracao();
                } else {
                    resultPA.addRear(this.wAdjMatrix[cur][next].first());
                    cost += wAdjMatrix[cur][next].first().getDuracao();
                }
                resultPA.addRear(vertices[next]);
                cur = next;
            } while (currentPI.hasNext());
            result.addRear(resultPA);
            System.out.println("Path Cost: " + cost);
            resultPA = new ArrayUnorderedList<>();
            cost = 0;
        }

        return result;
    }

    /**
     * @param allpaths
     * @return lista com o caminho que dura menos dias.
     */
    private ArrayUnorderedList<Integer> shortestPathByMinDurationIndexes(ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        Iterator allpathsIt = allpaths.iterator();
        ArrayUnorderedList<Integer> bestPath = null;
        int cur;
        int next;
        float numOfDaysCP = 0;
        float numOfDaysOptimum = Float.MAX_VALUE;
        while (allpathsIt.hasNext()) {
            ArrayUnorderedList<Integer> currentPath = (ArrayUnorderedList<Integer>) allpathsIt.next();
            Iterator currentPathIt = currentPath.iterator();
            cur = (int) currentPathIt.next();
            next = cur;
            do {
                //if (currentPathIt.hasNext()) {
                next = (int) currentPathIt.next();
                //}
                if (this.wAdjMatrix[cur][next].first() == null) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");

                }

                if (this.wAdjMatrix[cur][next].first().getDuracao() > this.wAdjMatrix[cur][next].last().getDuracao()) {
                    numOfDaysCP += this.wAdjMatrix[cur][next].last().getDuracao();
                    //TODO meter alternativa no resultado
                } else {
                    numOfDaysCP += this.wAdjMatrix[cur][next].first().getDuracao();
                }
                cur = next;
            } while (currentPathIt.hasNext());

            if (numOfDaysOptimum > numOfDaysCP) {
                numOfDaysOptimum = numOfDaysCP;
                bestPath = currentPath;
            }
            numOfDaysCP = 0;
        }
        return bestPath;
    }

    /**
     * 
     * @param duracaoMax
     * @param allpaths
     * @return todos es caminhos com duracao menor que duracaoMax
     */
    private ArrayUnorderedList<ArrayUnorderedList<Integer>> filterPathsByDuration(double duracaoMax, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        if (allpaths.isEmpty()) {
            System.out.println("VAZIO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        Iterator allpathsIt = allpaths.iterator();
        int cur = 0;
        int next = 0;
        double numOfDaysCP = 0;
        ArrayUnorderedList<ArrayUnorderedList<Integer>> result = new ArrayUnorderedList<>();

        while (allpathsIt.hasNext()) {
            ArrayUnorderedList<Integer> currentPath = (ArrayUnorderedList<Integer>) allpathsIt.next();

            Iterator currentPathIt = currentPath.iterator();
            cur = (int) currentPathIt.next();
            next = cur;
            do {
                if (currentPathIt.hasNext()) {
                    next = (int) currentPathIt.next();
                }
                if (this.wAdjMatrix[cur][next].first() == null) {
                    System.out.println("VAZIO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("cur: " + cur + "next: " + next);
                }
                if (this.wAdjMatrix[cur][next].first().getDuracao() > this.wAdjMatrix[cur][next].last().getDuracao()) {
                    numOfDaysCP += this.wAdjMatrix[cur][next].last().getDuracao();
                    //TODO meter alternativa no resultado
                    //System.out.println("Alternativa 2: " + wAdjMatrix[cur][next].last().getDuracao());
                } else {
                    //System.out.println("Alternativa 1: " + wAdjMatrix[cur][next].first().getDuracao());
                    numOfDaysCP += this.wAdjMatrix[cur][next].first().getDuracao();
                }
                //modification
                cur = next;
            } while (currentPathIt.hasNext());
            if (numOfDaysCP <= duracaoMax) {
                result.addRear(currentPath);
            }
            numOfDaysCP = 0;
        }
        return result;
    }

    /**
     * 
     * @param MaxCost
     * @param allpaths
     * @return todos es caminhos com custo de tropas menor que MaxCost
     */
    private ArrayUnorderedList<ArrayUnorderedList<Integer>> filterPathsByMaxCost(double maxCost, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        Iterator allpathsIt = allpaths.iterator();
        int cur;
        int next;
        double maxCostCP = 0;
        ArrayUnorderedList<ArrayUnorderedList<Integer>> result = new ArrayUnorderedList<>();

        while (allpathsIt.hasNext()) {
            ArrayUnorderedList<Integer> currentPath = (ArrayUnorderedList<Integer>) allpathsIt.next();

            Iterator currentPathIt = currentPath.iterator();
            cur = (int) currentPathIt.next();
            next = cur;
            do {
                if (currentPathIt.hasNext()) {
                    next = (int) currentPathIt.next();
                }
                double alt1Cost = this.wAdjMatrix[cur][next].first().getCusto() * this.wAdjMatrix[cur][next].first().getDistancia();
                double alt2Cost = this.wAdjMatrix[cur][next].last().getCusto() * this.wAdjMatrix[cur][next].last().getDistancia();
                if (alt1Cost > alt2Cost) {
                    maxCostCP += alt2Cost;
                    if (!vertices[next].isConquistada()) {
                        maxCostCP += (Math.pow((vertices[next].getDefesas() / 10), 1.8)) * 100;
                    }

                    //TODO meter alternativa no resultado
                } else {
                    maxCostCP += alt1Cost;

                }
                if (!vertices[next].isConquistada()) {
                    maxCostCP += (Math.pow((vertices[next].getDefesas() / 10), 1.8)) * 100;
                }
                cur = next;
            } while (currentPathIt.hasNext());
            if (maxCostCP < maxCost) {
                result.addRear(currentPath);
            }
            maxCostCP = 0;
        }
        return result;
    }

    /**
     * 
     * @param MaxLossPerCombat
     * @param allpaths
     * @return todos es caminhos com custo por baatalha menor que MaxLossPerCombat
     */
    private ArrayUnorderedList<ArrayUnorderedList<Integer>> filterPathsByMaxLossPerCombat(double maxLossesCombat, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        Iterator allpathsIt = allpaths.iterator();
        ArrayUnorderedList<ArrayUnorderedList<Integer>> result = new ArrayUnorderedList<>();
        double maxLoss = 0;

        while (allpathsIt.hasNext()) {
            ArrayUnorderedList<Integer> currentPath = (ArrayUnorderedList<Integer>) allpathsIt.next();
            Iterator currentPathIt = currentPath.iterator();
            while (currentPathIt.hasNext()) {
                int current = (int) currentPathIt.next();
                double a = (Math.pow((vertices[current].getDefesas() / 10), 1.8)) * 100;
                //System.out.println("Cidade: " + vertices[current] + " maxLoss: " + maxLoss + " CurrentLoss: " + a);
                if (maxLoss < a) {
                    maxLoss = a;
                }
            }
            if (maxLoss <= maxLossesCombat) {
                result.addRear(currentPath);
            }
            maxLoss = 0;
        }
        return result;
    }

     /**
     * 
     * @param maxCombats
     * @param allpaths
     * @return todos es caminhos num de combates travados menor maxCombats
     */
    private ArrayUnorderedList<ArrayUnorderedList<Integer>> filterPathsByMaxCombats(int maxCombats, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths) {
        Iterator allpathsIt = allpaths.iterator();
        ArrayUnorderedList<ArrayUnorderedList<Integer>> result = new ArrayUnorderedList<>();

        while (allpathsIt.hasNext()) {
            ArrayUnorderedList<Integer> currentPath = (ArrayUnorderedList<Integer>) allpathsIt.next();
            System.out.println("Current size: " + (currentPath.size() - 1));
            if ((currentPath.size() - 1) <= maxCombats) {
                result.addRear(currentPath);
            }
        }
        return result;
    }

    /**
     * 
     * @param start
     * @param target
     * @param criterios
     * @return lista de caminhos segundo os filtros aplicados pelo utilizador
     */
    public ArrayUnorderedList<ArrayUnorderedList<Integer>> findBestPaths(Cidade start, Cidade target, Criterio criterios) {
        // Vai buscar todos os caminhos
        ArrayUnorderedList<ArrayUnorderedList<Integer>> result = this.dfsAllPaths(start, target);

        if (criterios.getDuracaoTotal() > -1) {
            // Se duracaoTotal > 0, filtra os caminhos por duracao total, ficando allpaths apenas com os caminhos filtrados
            result = filterPathsByDuration(criterios.getDuracaoTotal(), result);
        }
        if (criterios.getCustoMaximo() > -1) {
            // Se custoMaximo > 0, filtra os caminhos por custo maximo, ficando allpaths apenas com os caminhos filtrados
            result = filterPathsByMaxCost(criterios.getCustoMaximo(), result);
        }
        if (criterios.getPerdasCombate() > -1) {
            // Se perdasCombate > 0, filtra os caminhos por limite de perdas em combate, ficando allpaths apenas com os caminhos filtrados
            result = filterPathsByMaxLossPerCombat(criterios.getPerdasCombate(), result);
        }
        if (criterios.getNumeroCombates() > -1) {
            // Se numeroCombates > 0, filtra os caminhos por numero de combates limite, ficando allpaths apenas com os caminhos filtrados
            result = filterPathsByMaxCombats(criterios.getNumeroCombates(), result);
        }

        return result;
    }

    /**
     * Imprime uma determinada lista de caminhos
     * @param resultPaths
     */
    public void printPaths(ArrayUnorderedList<ArrayUnorderedList<Object>> resultPaths) {
        if (resultPaths.isEmpty()) {
            System.out.println("Nao existem caminhos!");
        } else {
            int pathCount = 1;
            Iterator it = resultPaths.iterator();
            while (it.hasNext()) {
                ArrayUnorderedList<Integer> cur = (ArrayUnorderedList<Integer>) it.next();
                Iterator it2 = cur.iterator();
                System.out.println("--------> Caminho " + pathCount + " <---------");
                while (it2.hasNext()) {
                    System.out.println(it2.next().toString());
                }
                pathCount++;
            }
        }
    }
    
    /**
     * Método que lista todas as Cidades.
     */
    public void listCities() {
        System.out.println("Cities: ");
        for(int i=0; i<this.numVertices; i++) {
            System.out.println("[" + i + "] " + vertices[i].getNome() + " [" + (int)vertices[i].getDefesas() + "]");
        }
    }
    
    /**
     * Método que serve para editar o nome de uma Cidade.
     */
    public void editCityName() {
        GameOfThrones input = new GameOfThrones();
        do {
            input.readOption();
            if(input.getOpt() == -1) {
                return;
            }
            if(input.getOpt() > 0 && input.getOpt() < this.numVertices) {
                System.out.println("Set new name: ");
                input.readString();
                this.vertices[input.getOpt()].setNome(input.getString());
                System.out.println("New name set: " + this.vertices[input.getOpt()]);
            }
        } while(input.getOpt() < 0 && input.getOpt() > this.numVertices-1);
    }

    /**
     * Método que serve para editar as defesas de uma Cidade.
     */
    public void editCityDefense() {
        GameOfThrones input = new GameOfThrones();
        do {
            input.readOption();
            if(input.getOpt() == -1) {
                return;
            }
            if(input.getOpt() > 0 && input.getOpt() < this.numVertices) {
                System.out.println("Set new Defense: ");
                input.readDouble();
                this.vertices[input.getOpt()].setDefesas((int) input.getValue());
                System.out.println("New Defense set: " + (int)this.vertices[input.getOpt()].getDefesas());
            }
        } while(input.getOpt() < 0 && input.getOpt() > this.numVertices-1);
    }
    
    /**
     * Método que serve para editar a distancia de um caminho.
     */
    public void editPathDistance() {
        GameOfThrones input = new GameOfThrones();
        int start, dest;
        
        do {
            System.out.println("Cidade Partida: ");
            input.readOption();
            start = input.getOpt();
            if(input.getOpt() == -1)
                return;
            System.out.println("Cidade Destino: ");
            input.readOption();
            dest = input.getOpt();
            if(input.getOpt() == -1)
                return;
            
            if(this.wAdjMatrix[start][dest].isEmpty()) {
                System.out.println("Nao existe caminho entre essas cidades!");
                return;
            }
            System.out.println(this.wAdjMatrix[start][dest].first().toString());
            System.out.println(this.wAdjMatrix[start][dest].last().toString());
            
            do {
                System.out.println("Which Alternative to change: ");
                do {
                    input.readOption();
                } while(input.getOpt() != -1 && input.getOpt() != 1 && input.getOpt() != 2);
                if(input.getOpt() == -1)
                    return;
                    
                do {
                    input.readDouble();
                    if(input.getValue() == -1)
                        return;
                    
                } while(input.getValue() < 0);
                
                double value = input.getValue();
                
                if(input.getOpt() == 1) {
                    this.wAdjMatrix[start][dest].first().setDistancia((int) value);
                    System.out.println("Values changed to: ");
                    System.out.println(this.wAdjMatrix[start][dest].first().toString());
                } else if(input.getOpt() == 2) {
                    this.wAdjMatrix[start][dest].last().setDistancia((int) value);
                    System.out.println("Values changed to: ");
                    System.out.println(this.wAdjMatrix[start][dest].last().toString());
                }
            } while(input.getOpt() < 1 && input.getOpt() > 2);
        } while(input.getOpt() < 0 && input.getOpt() > this.numVertices-1);
        
    }
    
    /**
     * Método que serve para editar a duracao de um caminho.
     */
    public void editPathDuration() {
        GameOfThrones input = new GameOfThrones();
        int start, dest;
        
        do {
            System.out.println("Cidade Partida: ");
            input.readOption();
            start = input.getOpt();
            if(input.getOpt() == -1)
                return;
            System.out.println("Cidade Destino: ");
            input.readOption();
            dest = input.getOpt();
            if(input.getOpt() == -1)
                return;
            
            if(this.wAdjMatrix[start][dest].isEmpty()) {
                System.out.println("Nao existe caminho entre essas cidades!");
                return;
            }
            System.out.println(this.wAdjMatrix[start][dest].first().toString());
            System.out.println(this.wAdjMatrix[start][dest].last().toString());
            
            do {
                System.out.println("Which Alternative to change: ");
                do {
                    input.readOption();
                } while(input.getOpt() != -1 && input.getOpt() != 1 && input.getOpt() != 2);
                if(input.getOpt() == -1)
                    return;
                    
                do {
                    input.readDouble();
                    if(input.getValue() == -1)
                        return;
                    
                } while(input.getValue() < 0);
                
                double value = input.getValue();
                
                if(input.getOpt() == 1) {
                    this.wAdjMatrix[start][dest].first().setDuracao(value);
                    System.out.println("Values changed to: ");
                    System.out.println(this.wAdjMatrix[start][dest].first().toString());
                } else if(input.getOpt() == 2) {
                    this.wAdjMatrix[start][dest].last().setDuracao(value);
                    System.out.println("Values changed to: ");
                    System.out.println(this.wAdjMatrix[start][dest].last().toString());
                }
            } while(input.getOpt() < 1 && input.getOpt() > 2);
        } while(input.getOpt() < 0 && input.getOpt() > this.numVertices-1);
        
    }
    
    /**
     * Método que serve para editar o custo de um caminho.
     */
    public void editPathCost() {
        GameOfThrones input = new GameOfThrones();
        int start, dest;
        
        do {
            System.out.println("Cidade Partida: ");
            input.readOption();
            start = input.getOpt();
            if(input.getOpt() == -1)
                return;
            System.out.println("Cidade Destino: ");
            input.readOption();
            dest = input.getOpt();
            if(input.getOpt() == -1)
                return;
            
            if(this.wAdjMatrix[start][dest].isEmpty()) {
                System.out.println("Nao existe caminho entre essas cidades!");
                return;
            }
            System.out.println(this.wAdjMatrix[start][dest].first().toString());
            System.out.println(this.wAdjMatrix[start][dest].last().toString());
            
            do {
                System.out.println("Which Alternative to change: ");
                do {
                    input.readOption();
                } while(input.getOpt() != -1 && input.getOpt() != 1 && input.getOpt() != 2);
                if(input.getOpt() == -1)
                    return;
                    
                do {
                    input.readDouble();
                    if(input.getValue() == -1)
                        return;
                    
                } while(input.getValue() < 0);
                
                double value = input.getValue();
                
                if(input.getOpt() == 1) {
                    this.wAdjMatrix[start][dest].first().setCusto(value);
                    System.out.println("Values changed to: ");
                    System.out.println(this.wAdjMatrix[start][dest].first().toString());
                } else if(input.getOpt() == 2) {
                    this.wAdjMatrix[start][dest].last().setCusto(value);
                    System.out.println("Values changed to: ");
                    System.out.println(this.wAdjMatrix[start][dest].last().toString());
                }
            } while(input.getOpt() < 1 && input.getOpt() > 2);
        } while(input.getOpt() < 0 && input.getOpt() > this.numVertices-1);
    }
    
    
}
