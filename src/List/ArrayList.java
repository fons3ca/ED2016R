/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import java.util.Iterator;

/**
 *
 * @author n_fon
 */
public class ArrayList<T> implements ListADT<T> {

    private final int DEFAULT_SIZE = 100;
    protected T[] collection;
    protected int rear;

    public ArrayList(int size) {
        this.collection = (T[]) (new Object[size]);
        this.rear = 0;
    }

    public ArrayList() {
        this.collection = (T[]) (new Object[DEFAULT_SIZE]);
        this.rear = 0;
    }

    @Override
    public T removeFirst() {
        if (!this.isEmpty()) {
            T removed = this.collection[0];
            for (int i = 0; i < this.rear; i++) {
                this.collection[i] = this.collection[i + 1];
            }
            this.rear--;
            return removed;
        } else {
            return null;
        }
    }

    @Override
    public T removeLast() {
        if (!this.isEmpty()) {
            this.rear--;
            T removed = this.collection[this.rear];
            this.collection[this.rear] = null;
            return removed;
        }
        return null;
    }

    public void removeIndex(int index) {
        if (!this.isEmpty() && index>=0) {
            for (int j = index; j < this.rear; j++) {
                this.collection[j] = this.collection[j + 1];
            }
            rear--;
        }
    }

    @Override
    public T remove(T element) {
        for (int i = 0; i < this.rear; i++) {
            if (this.collection[i].equals(element)) {
                rear--;
                for (int j = i; j < this.rear; j++) {
                    this.collection[j] = this.collection[j + 1];
                }
                return element;
            }
        }
        return null;
    }

    @Override
    public T first() {
        if (!this.isEmpty()) {
            return this.collection[0];
        }
        return null;
    }

    @Override
    public T last() {
        if (!this.isEmpty()) {
            return this.collection[this.rear - 1];
        }
        return null;
    }

    @Override
    public boolean contains(T target) {
        for (int i = 0; i < this.rear; i++) {
            if (this.collection[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (this.rear == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.rear;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            int current = 0;

            @Override
            public boolean hasNext() {
                if (current < rear) {
                    return true;
                }
                return false;
            }

            @Override
            public T next() {
                T element = collection[current];
                current++;
                return element;
            }
            
            @Override
            public void remove(){
               for (int j = current-1; j < rear; j++) {
                collection[j] = collection[j + 1];
            }
               rear--;
            }
        };
        return it;
    }

}
