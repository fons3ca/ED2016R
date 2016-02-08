/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import List.OrderedListADT;

/**
 *
 * @author n_fon
 * @param <T>
 */
public class DoubleLinkedOrderedList<T extends Comparable> extends DoubleLinkedList<T> implements OrderedListADT<T> {

    @Override
    public void add(T element) {
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(element);
        if(super.isEmpty()){
            this.head.setNext(newNode);
            this.tail.setPrevious(newNode);
            newNode.setPrevious(head);
            newNode.setNext(tail);
            this.count++;
        }else if(super.size()==1){
            if(element.compareTo(this.first())<=0){
                newNode.setNext(this.head.getNext());
                newNode.setPrevious(this.head);
                this.head.setNext(newNode);
                newNode.getNext().setPrevious(newNode);
                this.count++;
            }else{
                newNode.setPrevious(this.tail.getPrevious());
                newNode.setNext(this.tail);
                this.tail.getPrevious().setNext(newNode);
                this.tail.setPrevious(newNode);
                this.count++;
            }
        }else if(super.size()>1){
            if(element.compareTo(this.first())<0){//add head
                newNode.setNext(this.head.getNext());
                newNode.setPrevious(this.head);
                this.head.setNext(newNode);
                newNode.getNext().setPrevious(newNode);
                this.count++;
            }else if(element.compareTo(this.last())>0){//add tail
                newNode.setNext(this.tail);
                newNode.setPrevious(this.tail.getPrevious());
                newNode.getNext().setPrevious(newNode);
                newNode.getPrevious().setNext(newNode);
                this.count++;
            }else{//procura posicao para inserir
                DoubleLinkedNode<T> current = this.head.getNext();
                while(current.getNext().getElement()!=null){
                    if(element.compareTo(current.getElement())>0 && element.compareTo(current.getNext().getElement())<0){
                        newNode.setNext(current.getNext());
                        newNode.setPrevious(current);
                        newNode.getNext().setPrevious(newNode);
                        newNode.getPrevious().setNext(newNode);
                        this.count++;
                    }else{
                        current = current.getNext();
                    }
                }
            }
        }
    }

}
