/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author n_fon
 * @param <T>
 */
public class DoubleLinkedNode<T extends Comparable> {
    private DoubleLinkedNode<T> previous;
    private DoubleLinkedNode<T> next;
    private T element;

    public DoubleLinkedNode(T element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }
    
    public DoubleLinkedNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinkedNode<T> previous) {
        this.previous = previous;
    }

    public DoubleLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
