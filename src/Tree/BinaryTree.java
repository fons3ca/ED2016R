/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import List.ArrayUnorderedList;
import java.util.Iterator;

/**
 *
 * @author n_fon
 */
public class BinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;
    protected BinaryTreeNode<T> root;

    public BinaryTree() {
        count = 0;
        root = null;
    }
    
    public BinaryTree(T element) {
        this.root = new BinaryTreeNode<T>(element);
    }
    public BinaryTree(BinaryTreeNode<T> element) {
        this.root = element;
    }
    
    @Override
    public T getRoot() {
        return this.root.getElement();
    }

    @Override
    public boolean isEmpty() {
        if (this.count == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean contains(T targetElement) {
        if (this.find(targetElement) != null) {
            return true;
        }
        return false;
    }

    @Override
    public T find(T targetElement) {
        BinaryTreeNode<T> current = findAgain(targetElement, root);
        if (current == null) {
            return null;
        }
        return (current.getElement());
    }

    /**
     * Returns a reference to the specified target element if it is found in
     * this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     */
    private BinaryTreeNode<T> findAgain(T targetElement,
            BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.getElement().equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(targetElement, next.getLeft());

        if (temp == null) {
            temp = findAgain(targetElement, next.getRight());
        }

        return temp;
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inorder(BinaryTreeNode<T> node,
            ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inorder(node.getLeft(), tempList);
            tempList.addRear(node.getElement());
            inorder(node.getRight(), tempList);
        }
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inorder(root, tempList);
        return tempList.iterator();
    }

    protected void preorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            tempList.addRear(node.getElement());
            inorder(node.getLeft(), tempList);
            inorder(node.getRight(), tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        preorder(root, tempList);

        return tempList.iterator();
    }

    protected void postorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inorder(node.getLeft(), tempList);
            inorder(node.getRight(), tempList);
            tempList.addRear(node.getElement());
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        preorder(root, tempList);
        return tempList.iterator();
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<BinaryTreeNode<T>> tempList = new ArrayUnorderedList<>();
        ArrayUnorderedList<T> finalList = new ArrayUnorderedList<>();
        tempList.addFront(root);

        while (!tempList.isEmpty()) {
            BinaryTreeNode<T> a = tempList.removeFirst();
            if (a.getLeft()!=null) {
                tempList.addRear(a.getLeft());
            }
            if(a.getRight()!=null){
                tempList.addRear(a.getRight());
            }
            finalList.addRear(a.getElement());
        }
        return finalList.iterator();
    }
}
