
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
        private Node parent;
        private Node left;
        private Node right;
        private int balance;
        
        private Node(E e, Node parent) {
            this.value = e;
            this.parent = parent;
        }
        
        private void add(E e, char lastCriteria) {
            if (lastCriteria == 'x') {
                if (e.getCoordinates().getY() > this.value.getCoordinates().getY()) {
                    if (this.right == null) {
                        this.right = new Node(e, this);
                    } else {
                        this.right.add(e, 'y');
                    }
                } else {
                    if (this.left == null) {
                        this.left = new Node(e, this);
                    } else {
                        this.left.add(e, 'y');
                    }
                }
            } else if (lastCriteria == 'y') {
                if (e.getCoordinates().getZ() > this.value.getCoordinates().getZ()) {
                    if (this.right == null) {
                        this.right = new Node(e, this);
                    } else {
                        this.right.add(e, 'z');
                    }
                } else {
                    if (this.left == null) {
                        this.left = new Node(e, this);
                    } else {
                        this.left.add(e, 'z');
                    }
                }
            } else {
                if (e.getCoordinates().getX()> this.value.getCoordinates().getX()) {
                    if (this.right == null) {
                        this.right = new Node(e, this);
                    } else {
                        this.right.add(e, 'x');
                    }
                } else {
                    if (this.left == null) {
                        this.left = new Node(e, this);
                    } else {
                        this.left.add(e, 'x');
                    }
                }
            }
        }
        
        @Override
        public String toString() {
            String str = "(" + this.value.toString() + ", ";
            str += this.left != null ? this.left.toString() : "";
            str += ", ";
            str += this.right != null ? this.right.toString() : "";
            str += ")";
            
            return str;
        }
    }
    
    private class Binary3DSearchTreeIterator implements Iterator {
        
        private Node last;
        
        @Override
        public boolean hasNext() {
            if (this.last == null) {
                return root != null;
            } else if ((this.last.left != null) ||
                       (this.last.right != null)) {
                return true;
            } else {
                return up(last) != null;
            }           
        }
        
        @Override
        public E next() {
            if (this.last == null) {
                this.last = root;
            } else if (this.last.left != null) {
                this.last = this.last.left;
            } else if (this.last.right != null) {
                this.last = this.last.right;
            } else {
                this.last = up(this.last);
            }
            
            return this.last != null ? this.last.value : null;
        }
        
        private Node up(Node last) {
            if (last.parent != null) {
                if ((last.parent.right != null) && 
                    (!last.parent.right.equals(last))) {
                    return last.parent.right;
                } else {
                    return this.up(last.parent);
                }
            } else {
                return null;
            }
        }
        
        @Override
        public void remove() {
            
        }
    }
    
    public boolean add(E e) {
        if (root == null) {
            root = new Node(e, null);
        } else {
            root.add(e, 'x');
        }
        
        return true;
    }
    
    public void clear() {
        
    }
    
    @Override
    public Iterator iterator() {
        return new Binary3DSearchTreeIterator();
    }
    
    @Override
    public String toString() {
        if (root != null) {
            return root.toString();
        } else {
            return "";
        }
    }
}