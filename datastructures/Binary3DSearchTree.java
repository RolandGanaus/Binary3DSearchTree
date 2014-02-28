
package datastructures;

import game.HasCoordinates;
import java.util.Iterator;

/**
 *
 * @author Roland
 */
public class Binary3DSearchTree<E extends HasCoordinates> implements Iterable<E> {
    
    private Node root;

    private class Node {
        private E value;
        private Node left;
        private Node right;
        
        private Node(E e) {
            this.value = e;
        }
        
        private void add(E e, char lastCriteria) {
            if (lastCriteria == 'x') {
                if (e.getCoordinates().getY() > this.value.getCoordinates().getY()) {
                    if (this.right == null) {
                        this.right = new Node(e);
                    } else {
                        this.right.add(e, 'y');
                    }
                } else {
                    if (this.left == null) {
                        this.left = new Node(e);
                    } else {
                        this.left.add(e, 'y');
                    }
                }
            } else if (lastCriteria == 'y') {
                if (e.getCoordinates().getZ() > this.value.getCoordinates().getZ()) {
                    if (this.right == null) {
                        this.right = new Node(e);
                    } else {
                        this.right.add(e, 'z');
                    }
                } else {
                    if (this.left == null) {
                        this.left = new Node(e);
                    } else {
                        this.left.add(e, 'z');
                    }
                }
            } else {
                if (e.getCoordinates().getX()> this.value.getCoordinates().getX()) {
                    if (this.right == null) {
                        this.right = new Node(e);
                    } else {
                        this.right.add(e, 'x');
                    }
                } else {
                    if (this.left == null) {
                        this.left = new Node(e);
                    } else {
                        this.left.add(e, 'x');
                    }
                }
            }
        }
    }
    
    private class Binary3DSearchTreeIterator implements Iterator {
        
        private Node node;
        
        @Override
        public boolean hasNext() {
            if (this.node == null) {
                return root != null ? true : false;
            } else {
                return true;
            }           
        }
        
        @Override
        public E next() {
            return this.node.value;
        }
        
        @Override
        public void remove() {
            
        }
    }
    
    public boolean add(E e) {
        if (root == null) {
            root = new Node(e);
        } else {
            root.add(e, 'x');
        }
        
        return true;
    }
    
    public void clear() {
        
    }
    
    public Iterator iterator() {
        return new Binary3DSearchTreeIterator();
    }
    
}
