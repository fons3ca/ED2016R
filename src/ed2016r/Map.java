/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2016r;

import List.ArrayUnorderedList;
import Graph.*;
import LinkedQueue.LinkedQueue;
import List.*;

import java.util.Iterator;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class Map<T> extends Graph<T> implements MapADT<T> {

    protected ArrayUnorderedList<Alternativa>[][] wAdjMatrix;
    private boolean[] visited;      // to remember visit
    private ArrayUnorderedList<Integer> al;
    private int size;

    public Map() {
        super();
        this.wAdjMatrix = new ArrayUnorderedList[super.DEFAULT_CAPACITY][super.DEFAULT_CAPACITY];
        this.al = new ArrayUnorderedList<>();
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
    public void addEdge(T vertex1, T vertex2, Alternativa alt) {
        addEdge(getIndex(vertex1), getIndex(vertex2), alt);
    }

    /**
     * Adiciona uma cidade
     *
     * @param vertex cidade
     */
    @Override
    public void addVertex(T vertex) {
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
    public void removeVertex(T vertex) {
        for (int i = 0; i < numVertices; i++) {
            if (vertex.equals(vertices[i])) {
                removeVertex(i);
                return;
            }
        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
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

    public T getCidadeAt(int i) {
        return this.vertices[i];
    }

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayUnorderedList<ArrayUnorderedList<Integer>> dfsAllPaths(T source, T destination) {
        this.size = 0;
        visited = new boolean[this.numVertices + 1];
        for (int i = 0; i < visited.length; i++) {
            this.visited[i] = false;
        }
        ArrayUnorderedList<ArrayUnorderedList<Integer>> resultQueue = new ArrayUnorderedList<>();
        dfsAllPathsR(getIndex(source), getIndex(destination), resultQueue);
        return resultQueue;
    }

    private void dfsAllPathsR(int src, int dst, ArrayUnorderedList<ArrayUnorderedList<Integer>> resultQueue) {
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

    public int getMinTropaNecessario(T inicio, T fim) {
        return 0;
    }

    public Iterator getMinTropaPathIterator(T inicio, T fim) {
        Iterator it = null;

        return it;
    }

    public ArrayUnorderedList getMinTroops(T src, T dst) {
        int numTropasTemp = 0;
        int numTropas =0;
        int cur;
        int next;
        ArrayUnorderedList<Object> result;
        ArrayUnorderedList<Object> temp = new ArrayUnorderedList<>();
        //todos os caminho possiveis
        ArrayUnorderedList a = this.dfsAllPaths(src, dst);
        Iterator it = a.iterator();
        while (it.hasNext()) {
            ArrayUnorderedList currentPath = (ArrayUnorderedList) it.next();
            Iterator cpit = currentPath.iterator();
            cur = (int) cpit.next();
            next = (int) cpit.next();
            while (cpit.hasNext()) {
                cur = next;
                next = (int)cpit.next();
                temp.addRear(this.vertices[cur]);
                //num de tropas perdidas na viagem pela alternativa 1
                double cansados1 = (this.wAdjMatrix[cur][next].first().getCusto()) * (this.wAdjMatrix[cur][next].first().getDistancia());
                //num de tropas perdidas na viagem pela alternativa 2
                double cansados2 = (this.wAdjMatrix[cur][next].last().getCusto()) * (this.wAdjMatrix[cur][next].first().getDistancia());
                //num tropas perdidas no combate
//                double perdasCombate = (Math.pow((this.vertices[next].getDefesas()/10),1.8))*100;
                if (cansados1 >= cansados2) {
                    numTropasTemp += cansados2;
                    temp.addRear(this.wAdjMatrix[cur][next].last());
                } else {
                    numTropasTemp += cansados1;
                    temp.addRear(this.wAdjMatrix[cur][next].first());
                }
                
            }

        }

        return null;
    }
}
