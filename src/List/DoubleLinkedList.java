/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import List.ListADT;
import java.util.Iterator;

/**
 *
 * @author n_fon
 * @param <T>
 */
public class DoubleLinkedList<T extends Comparable> implements ListADT<T> {

    protected DoubleLinkedNode<T> head;
    protected DoubleLinkedNode<T> tail;
    protected int count;

    public DoubleLinkedList() {
        this.head =  new DoubleLinkedNode<>(null);
        this.tail = new DoubleLinkedNode<>(null);
        this.head.setNext(tail);
        this.tail.setPrevious(head);
        this.count = 0;
    }

    @Override
    public T removeFirst() {
        if (!this.isEmpty()) {
            T element = this.head.getNext().getElement();
            this.head = this.head.getNext();
            this.head.setPrevious(null);
            this.count--;
            this.head.setElement(null);
            this.tail.setElement(null);
            return element;
        } else {
            return null;
        }
    }

    @Override
    public T removeLast() {
        if (!this.isEmpty()) {
            T element = this.tail.getPrevious().getElement();
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);
            this.count--;
            this.head.setElement(null);
            this.tail.setElement(null);
            return element;
        } else {
            return null;
        }
    }

    @Override
    public T remove(T element) {
        if (!this.isEmpty()) {
            DoubleLinkedNode<T> current = this.head.getNext();
            while (current.getElement() != null) {
                if (current.getElement().compareTo(element) == 0) {
                    current.getPrevious().setNext(current.getNext().getNext());
                    current.getNext().setPrevious(current.getPrevious().getPrevious());
                    this.head.setElement(null);
                    this.tail.setElement(null);
                    this.count--;
                    return element;
                }
                current = current.getNext();
            }
            return element;
        } else {
            return null;
        }
    }

    @Override
    public T first() {
        if (!this.isEmpty()) {
            return this.head.getNext().getElement();
        } else {
            return null;
        }
    }

    @Override
    public T last() {
        if (!this.isEmpty()) {
            return this.tail.getPrevious().getElement();
        } else {
            return null;
        }
    }

    @Override
    public boolean contains(T target) {
        DoubleLinkedNode<T> current = this.head.getNext();
        while (current.getElement() != null) {
            if (current.getElement().compareTo(target) == 0) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (this.count == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            DoubleLinkedNode<T> current = head.getNext();

            @Override
            public boolean hasNext() {
                if (current.getNext() != null) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public T next() {
                T element = current.getElement();
                current = current.getNext();
                return element;
            }
        };
        return it;
    }
}
