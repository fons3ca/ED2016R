package Tree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class LinkedBinarySearchTree<T> extends BinaryTree<T>
        implements BinarySearchTreeADT<T> {

    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTree() {
        super();
    }

    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will be the root of the new binary search
     * tree
     */
    public LinkedBinarySearchTree(T element) {
        super(element);
    }

    @Override
    /**
     * Adds the specified object to the binary search tree in the appropriate
     * position according to its key value. Note that equal elements are added
     * to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    public void addElement(T element) {
        BinaryTreeNode<T> temp = new BinaryTreeNode<T>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (isEmpty()) {
            root = temp;
        } else {
            BinaryTreeNode<T> current = root;
            boolean added = false;
            while (!added) {
                if (comparableElement.compareTo(current.getElement()) < 0) {
                    if (current.getLeft() == null) {
                        current.setLeft(temp);
                        added = true;
                    } else {
                        current = current.getLeft();
                    }
                } else {
                    if (current.getRight() == null) {
                        current.setRight(temp);
                        added = true;
                    } else {
                        current = current.getRight();
                    }
                }
            }
        }
        count++;
    }

    @Override
    /**
     * Removes the first element that matches the specified target element from
     * the binary search tree and returns a reference to it. Throws a
     * ElementNotFoundException if the specified target element is not found in
     * the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    public T removeElement(T targetElement) {
        T result = null;
        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.getElement())) {
                result = root.getElement();
                root = replacement(root);
                count--;
            } else {
                BinaryTreeNode<T> current, parent = root;
                boolean found = false;
                if (((Comparable) targetElement).compareTo(root.getElement()) < 0) {
                    current = root.getLeft();
                } else {
                    current = root.getRight();
                }
                while (current != null && !found) {
                    if (targetElement.equals(current.getElement())) {
                        found = true;
                        count--;
                        result = current.getElement();

                        if (current == parent.getLeft()) {
                            parent.setLeft(replacement(current));
                        } else {
                            parent.setRight(replacement(current));
                        }
                    } else {
                        parent = current;

                        if (((Comparable) targetElement).compareTo(current.getElement()) < 0) {
                            current = current.getLeft();
                        } else {
                            current = current.getRight();
                        }
                    }
                } //while

                if (!found) {
                    return null;
                }
            }
        } // end outer if
        return result;
    }

    /**
     * Returns a reference to a node that will replace the one specified for
     * removal. In the case where the removed node has two children, the inorder
     * successor is used as its replacement.
     *
     * @param node the node to be removeed
     * @return a reference to the replacing node
     */
    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;
        if ((node.getLeft() == null) && (node.getRight() == null)) {
            result = null;
        } else if ((node.getLeft() != null) && (node.getRight() == null)) {
            result = node.getLeft();
        } else if ((node.getLeft() == null) && (node.getRight() != null)) {
            result = node.getRight();
        } else {
            BinaryTreeNode<T> current = node.getRight();
            BinaryTreeNode<T> parent = node;
            while (current.getLeft() != null) {
                parent = current;
                current = current.getLeft();
            }
            if (node.getRight() == current) {
                current.setLeft(node.getLeft());
            } else {
                parent.setLeft(current.getRight());
                current.setRight(node.getRight());
                current.setLeft(node.getLeft());
            }
            result = current;
        }
        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        while (this.removeElement(targetElement) != null) {

        }
    }

    @Override
    public T removeMin() {
        T result = null;
        if (this.root.getLeft() == null) {
            result = root.getElement();
            this.root = this.root.getRight();
            return result;
        }
        BinaryTreeNode<T> current = root;
        BinaryTreeNode<T> parent = current;
        while (current.getLeft() != null) {
            parent = current;
            current = current.getLeft();
        }
        if (current.getRight() == null) {//é folha
            result = current.getElement();
            parent.setLeft(null);
        } else {
            result = current.getElement();
            parent.setLeft(current.getRight());
        }

        return result;
    }

    @Override
    public T removeMax() {
        T result = null;
        if (this.root.getRight()== null) {
            result = root.getElement();
            this.root = this.root.getLeft();
            return result;
        }
        BinaryTreeNode<T> current = root;
        BinaryTreeNode<T> parent = current;
        while (current.getRight() != null) {
            parent = current;
            current = current.getRight();
        }
        if (current.getLeft()== null) {//é folha
            result = current.getElement();
            parent.setRight(null);
        } else {
            result = current.getElement();
            parent.setRight(current.getLeft());
        }

        return result;
    }

    @Override
    public T findMin() {
            T result = null;
        if (this.root.getLeft()== null) {
            return root.getElement();
        }
        BinaryTreeNode<T> current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        if (current.getRight()== null) {//é folha
            result = current.getElement();
        } else {
            result = current.getElement();
        }

        return result;
    
    }

    @Override
    public T findMax() {
        T result = null;
        if (this.root.getRight()== null) {
            return root.getElement();
        }
        BinaryTreeNode<T> current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        if (current.getLeft()== null) {//é folha
            result = current.getElement();
        } else {
            result = current.getElement();
        }

        return result;
    }
}
