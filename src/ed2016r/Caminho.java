/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2016r;

import List.ArrayUnorderedList;
import java.util.Iterator;

/**
 *
 * @author n_fon
 */
public class Caminho extends ArrayUnorderedList<Cidade> implements Comparable<Caminho>{

    public Caminho(int size) {
        super(size);
    }

    public Caminho() {
    }

    @Override
    public int compareTo(Caminho o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getMinTropasNecessarias(){
        int tropas=0;
        Iterator it = this.iterator();
        while (it.hasNext()) {
            int src = (int) it.next();
            int dst = (int) it.next();
            
        }
        return 0;
    }
}
