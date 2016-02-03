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
    private int soldados;
    
    public Map() {
        super();
        this.wAdjMatrix = new ArrayUnorderedList[super.DEFAULT_CAPACITY][super.DEFAULT_CAPACITY];
    }
    
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
      }      
      numVertices++;
   }
    
    @Override
    public void addEdge(Cidade vertex1, Cidade vertex2, Alternativa weight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double shortestPathWeight(Cidade vertex1, Cidade vertex2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void expandCapacity()
   {
      Cidade[] largerVertices = new Cidade[vertices.length*2];
      ArrayUnorderedList<Alternativa>[][] largerAdjMatrix = new ArrayUnorderedList[vertices.length*2][vertices.length*2];

      for (int i = 0; i < numVertices; i++)
      {
         for (int j = 0; j < numVertices; j++)
         {
            largerAdjMatrix[i][j] = wAdjMatrix[i][j];
         }
         largerVertices[i] = vertices[i];
      }

      vertices = largerVertices;
      wAdjMatrix = largerAdjMatrix;
   }
    
}
