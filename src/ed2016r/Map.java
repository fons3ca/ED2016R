/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2016r;

import ArrayList.ArrayUnorderedList;
import Graph.*;
import java.util.Iterator;

/**
 *
 * @author Utilizador
 */
public class Map extends Graph<Cidade> implements MapADT<Cidade> {

    private ArrayUnorderedList<Alternativa>[][] wAdjMatrix;
    
    
    public Map() {
        super();
        this.wAdjMatrix = new ArrayUnorderedList[super.DEFAULT_CAPACITY][super.DEFAULT_CAPACITY];
    }
    
<<<<<<< HEAD
    
=======
    /**
     * Verifica se index é válido
     * @param index
     * @return true se index for válido
     */
    @Override
    public boolean indexIsValid(int index) {
        return index >= 0 && index < this.wAdjMatrix.length;
    }
    
    /**
     * Adiciona um caminho entre duas cidades
     * @param index1 index da cidade 
     * @param index2 index da cidade destino
     * @param alt 
     */
    public void addEdge (int index1, int index2, Alternativa alt)
   {
      if (indexIsValid(index1) && indexIsValid(index2))
      {
         wAdjMatrix[index1][index2].addRear(alt);
      }
   }
    
    /**
     * Adiciona uma cidade
     * @param vertex cidade
     */
    @Override
    public void addVertex (Cidade vertex)
   {
      if (numVertices == vertices.length)
         expandCapacity();

      vertices[numVertices] = vertex;
      for (int i = 0; i <= numVertices; i++)
      {
         wAdjMatrix[numVertices][i] = new ArrayUnorderedList<>();
         wAdjMatrix[i][numVertices] = new ArrayUnorderedList<>();
         adjMatrix[numVertices][i] = false;
         adjMatrix[i][numVertices] = false;
      }      
      numVertices++;
   }
>>>>>>> origin/master
    
    public void removeVertex (int index)
   {
      if (indexIsValid(index))
      {
         numVertices--;

         for (int i = index; i < numVertices; i++)
            vertices[i] = vertices[i+1];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j <= numVertices; j++)
               wAdjMatrix[i][j] = wAdjMatrix[i+1][j];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
               wAdjMatrix[j][i] = wAdjMatrix[j][i+1];
      }
   }
    
    @Override
    public void addEdge(Cidade vertex1, Cidade vertex2, Alternativa weight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double shortestPathWeight(Cidade vertex1, Cidade vertex2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
