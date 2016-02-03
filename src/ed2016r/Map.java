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
    
    @Override
    public void addEdge(Cidade vertex1, Cidade vertex2, Alternativa weight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double shortestPathWeight(Cidade vertex1, Cidade vertex2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
