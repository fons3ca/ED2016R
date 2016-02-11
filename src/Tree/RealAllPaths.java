/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import List.ArrayUnorderedList;
import ed2016r.Alternativa;
import ed2016r.Map;
import java.util.Iterator;

/**
 *
 * @author n_fon
 */
public class RealAllPaths extends BinaryTree<Alternativa> {

    private Integer[] path;
    private ArrayUnorderedList<Integer> caminho;
    private ArrayUnorderedList<Alternativa>[][] wAdjMatrix;
    
    public RealAllPaths(Alternativa alt, ArrayUnorderedList<Integer> caminho, ArrayUnorderedList<Alternativa>[][] wAdjMatrix) {
        super(alt);
        this.caminho = caminho;
        path = new Integer[caminho.size()];
        int i=0;
        Iterator it = caminho.iterator();
        while (it.hasNext()) {
            path[i]=(Integer) it.next();
            i++;
        }
        this.wAdjMatrix = wAdjMatrix;
    }
    
    public void build(){
        for (int i = 0; i < path.length-1; i++) {
            
        }
    }
    

}
