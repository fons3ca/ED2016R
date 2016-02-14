
package ed2016r;

import Graph.*;

/**
 * @author Tiago Fernandes - 8120152
 * @author Nuno Fonseca - 8120116
 */
public interface MapADT<T> extends GraphADT<T> {
    
    /**
     * Inserts an edge between two vertices of this graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight the weight
     */
    public void addEdge(T vertex1, T vertex2, Alternativa weight);
    
}
