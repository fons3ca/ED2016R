/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2016r;

import List.ArrayUnorderedList;
import Graph.*;
import LinkedQueue.LinkedQueue;

import java.util.Iterator;

/**
 *
 * @author Utilizador
 * @param <Cidade>
 */
public class Map extends Graph<Cidade> implements MapADT<Cidade> {

    protected ArrayUnorderedList<Alternativa>[][] wAdjMatrix;
    private boolean[] visited;      // to remember visit
    private ArrayUnorderedList<Integer> al;
    private int size;

    public Map() {
        super();
        this.wAdjMatrix = new ArrayUnorderedList[super.DEFAULT_CAPACITY][super.DEFAULT_CAPACITY];
        this.al = new ArrayUnorderedList<>();
        super.vertices = new Cidade[10];

    }

    /**
     * Adiciona um caminho entre duas cidades
     *
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
     *
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
     *
     * @param vertex cidade
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
     *
     * @param index
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
     * Procura o vertex (Cidade) e se existir chama removeVertex(i)
     *
     * @param vertex
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

    @Override
    public void removeEdge(Cidade vertex1, Cidade vertex2) {
        this.removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    @Override
    public void removeEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
            wAdjMatrix[index1][index2] = null;
            wAdjMatrix[index2][index1] = null;
        }
    }

    public Cidade getCidadeAt(int i) {
        return this.vertices[i];
    }

    @Override
    public double shortestPathWeight(Cidade vertex1, Cidade vertex2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayUnorderedList<ArrayUnorderedList<Integer>> dfsAllPaths(Cidade source, Cidade destination) {
        this.size = 0;
        visited = new boolean[this.numVertices + 1];
        for (int i = 0; i < visited.length; i++) {
            this.visited[i] = false;
        }
        ArrayUnorderedList<ArrayUnorderedList<Integer>> resultQueue = new ArrayUnorderedList<>();
        dfsAllPathsR(getIndex(source), getIndex(destination), resultQueue);
        return resultQueue;
    }

    public void dfsAllPathsR(int src, int dst, ArrayUnorderedList<ArrayUnorderedList<Integer>> resultQueue) {
        al.addRear(src);
        size++;
        visited[src] = true;
        if (src == dst) {       // tests for base condition to stop
            //System.out.println("Find destination");
            ArrayUnorderedList<Integer> path = new ArrayUnorderedList<>();
            for (Integer i : al) {
//                     Prints the path --> introduzir numa lista
                path.addRear(i);
                //System.out.print(vertices[i] + "  ");
            }
            //System.out.println();
            resultQueue.addRear(path);
            return;
        }
        for (int I = 0; I < this.numVertices; I++) {
            if (adjMatrix[src][I] == true) {
                if (visited[I] == false) {
                    dfsAllPathsR(I, dst, resultQueue);        // These lines do
                    visited[I] = false;   // main job of backtracking
                    size--;
                    al.removeIndex(size);
                }
            }
        }
    }
    public void testarAlternativas(ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths){
        Iterator allpathsIt = allpaths.iterator();
        
        ArrayUnorderedList<Integer> firstpath = (ArrayUnorderedList<Integer>) allpathsIt.next();
        
    }
    
    public void testeaaaaa(Iterator<Integer> path){
        int current = path.next();
        int next = path.next();
        
    }

    public int getMinTropaNecessario(Cidade inicio, Cidade fim) {
        return 0;
    }

    public Iterator getMinTropaPathIterator(Cidade inicio, Cidade fim) {
        Iterator it = null;
        return it;
    }

    public ArrayUnorderedList getMinTroopsPath(Cidade src, Cidade dst, int tropas) {
        int numTropasTemp = 0;
        int numTropas = -1;
        int cur;
        int next;

        ArrayUnorderedList<Object> temp = new ArrayUnorderedList<>();
        ArrayUnorderedList<Object> result = new ArrayUnorderedList<>();
        //todos os caminho possiveis
        ArrayUnorderedList<ArrayUnorderedList<Integer>> a = this.dfsAllPaths(src, dst);
        Iterator it = a.iterator();
        //iterar sobre todos os caminhos possiveis
        while (it.hasNext()) {
            //currentPath é o caminho seguinte no Array de caminhos
            ArrayUnorderedList currentPath = (ArrayUnorderedList) it.next();
            Iterator cpit = currentPath.iterator();
            cur = (int) cpit.next();
            next = cur;
            do {
                if (cpit.hasNext()) {
                    next = (int) cpit.next();
                }
                temp.addRear(this.vertices[cur]);
                //num de tropas perdidas na viagem pela alternativa 1
                double cansados1 = (this.wAdjMatrix[cur][next].first().getCusto()) * (this.wAdjMatrix[cur][next].first().getDistancia());
                //num de tropas perdidas na viagem pela alternativa 2
                double cansados2 = (this.wAdjMatrix[cur][next].last().getCusto()) * (this.wAdjMatrix[cur][next].first().getDistancia());
                //num tropas perdidas no combate
                double perdasCombate = (Math.pow((this.vertices[next].getDefesas() / 10), 1.8)) * 100;

                if (cansados2 <= cansados1) {
                    numTropasTemp += cansados2;
                    numTropasTemp += perdasCombate;
                    temp.addRear(this.wAdjMatrix[cur][next].last());
                } else {
                    numTropasTemp += cansados1;
                    numTropasTemp += perdasCombate;
                    temp.addRear(this.wAdjMatrix[cur][next].first());
                }
                cur = next;

            } while (cpit.hasNext());//fim do caminho
            temp.addRear(this.vertices[next]);
            if (numTropas == -1 || numTropas > numTropasTemp) {
                numTropas = numTropasTemp;
                result = new ArrayUnorderedList<>();
                Iterator tempit = temp.iterator();
                while (tempit.hasNext()) {
                    result.addRear(tempit.next());
                }

            } else {
                temp = new ArrayUnorderedList<>();
                numTropasTemp = 0;
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Minhas tropas: " + tropas);
        System.out.println("Tropas necessárias: " + numTropas);
        System.out.println("--------------------------------------------------");
        return result;
    }

    public boolean canConquer(ArrayUnorderedList caminho, int tropas) {
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
        if (tropas > custo) {
            System.out.println("Consegue conquistar e o melhor caminho é: ");
            return true;
        } else {
            System.out.println("Não consegue conquistar por nenhum caminho!");
            return false;
        }
    }
    
    //metodo auxiliar
    private ArrayUnorderedList<Integer> shortestPathByDays(Cidade src, Cidade dst, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths){
        Iterator allpathsIt = allpaths.iterator();
        ArrayUnorderedList<Integer> bestPath = null;
        
        int cur;
        int next;
        float numOfDaysCP = 0;
        float numOfDaysOptimum=Float.MAX_VALUE;
        while (allpathsIt.hasNext()) {
            ArrayUnorderedList<Integer> currentPath = (ArrayUnorderedList<Integer>) allpathsIt.next();
            Iterator currentPathIt = currentPath.iterator();
            cur = (int) currentPathIt.next();
            next = cur;
            do {
                if (currentPathIt.hasNext()) {
                    next = (int) currentPathIt.next();
                }
                if (this.wAdjMatrix[cur][next].first().getDuracao() > this.wAdjMatrix[cur][next].last().getDuracao()) {
                    numOfDaysCP += this.wAdjMatrix[cur][next].last().getDuracao();
                    //TODO meter alternativa no resultado
                } else {
                    numOfDaysCP += this.wAdjMatrix[cur][next].first().getDuracao();
                }
            } while (currentPathIt.hasNext());
            if (numOfDaysOptimum > numOfDaysCP) {
                numOfDaysOptimum = numOfDaysCP;
                bestPath = currentPath;
            }
        }
        return bestPath;
    }
    
    public ArrayUnorderedList<ArrayUnorderedList<Integer>> shortestPathByDays(Cidade src, Cidade dst, int numCaminhos, int numDiasMax) {
        ArrayUnorderedList<ArrayUnorderedList<Integer>> result = new ArrayUnorderedList<>();
        ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths = this.dfsAllPaths(src, dst);
        
//        for (int i = 0; i < numOpcoes; i++) {
//            result.addRear(shortestPathByDays(src, dst, allpaths));
//            allpaths.
//        }
        
        
       

        return result;
    }
    
    private void filterPathsByDuration(float duracaoMax, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths){
        Iterator allpathsIt = allpaths.iterator();
        int cur;
        int next;
        int numOfDaysCP = 0;
        
        while (allpathsIt.hasNext()) {
            ArrayUnorderedList<Integer> currentPath = (ArrayUnorderedList<Integer>) allpathsIt.next();
            
            Iterator currentPathIt = currentPath.iterator();
            cur = (int) currentPathIt.next();
            next = cur;
            do {
                if (currentPathIt.hasNext()) {
                    next = (int) currentPathIt.next();
                }
                if (this.wAdjMatrix[cur][next].first().getDuracao() > this.wAdjMatrix[cur][next].last().getDuracao()) {
                    numOfDaysCP += this.wAdjMatrix[cur][next].last().getDuracao();
                    //TODO meter alternativa no resultado
                } else {
                    numOfDaysCP += this.wAdjMatrix[cur][next].first().getDuracao();
                }
            } while (currentPathIt.hasNext());
            if (numOfDaysCP>duracaoMax) {
                allpathsIt.remove();
            }
        }
        
    }
    
    public ArrayUnorderedList<ArrayUnorderedList<Integer>> findBestPaths(Cidade start, Cidade target, Criterio criterios) {
        // Vai buscar todos os caminhos
        ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths = this.dfsAllPaths(start, target);
        
        if(criterios.getDuracaoTotal() > 0) {
            // Se duracaoTotal > 0, filtra os caminhos por duracao total, ficando allpaths apenas com os caminhos filtrados
            
        } else if(criterios.getCustoMaximo() > 0) {
            // Se custoMaximo > 0, filtra os caminhos por custo maximo, ficando allpaths apenas com os caminhos filtrados
            
        } else if(criterios.getPerdasCombate() > 0) {
            // Se perdasCombate > 0, filtra os caminhos por limite de perdas em combate, ficando allpaths apenas com os caminhos filtrados
            
        } else if(criterios.getNumeroCombates() > 0) {
            // Se numeroCombates > 0, filtra os caminhos por numero de combates limite, ficando allpaths apenas com os caminhos filtrados
            
        }
        
        // Retorna os caminhos dentro dos parametros
        return allpaths;
    }
    
    private void filterPathsByMaxLoss(float MaxLoss, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths){
        
    }
    
    private void filterPathsByLossPerCombat(float MaxLoss, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths){
        
    }
    
    private void filterPathsByNumberOfCombats(int numCombat, ArrayUnorderedList<ArrayUnorderedList<Integer>> allpaths){
        
    }
}
