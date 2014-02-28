
package game;

import datastructures.Binary3DSearchTree;

/**
 * Testprogramm zur Datenstruktur Binary3DSearchTree
 *
 * @author Roland Ganaus
 * @project Binary3DSearchTree
 * @version 1.0
 */
class Test
{
        
    /**
     * Eintrittspunkt ins Programm
     * @param args Parameter, nicht verwendet
     */
    public static void main(String[] args) {
        
       /**
        * TEST1
        */
        Binary3DSearchTree tree = new Binary3DSearchTree();
        
        tree.add(new WorldObject(1,  0,  0));
        tree.add(new WorldObject(1, -1,  0));
        tree.add(new WorldObject(1,  1,  0));
        tree.add(new WorldObject(1, -1, -1));
        tree.add(new WorldObject(1, -1,  1));
        tree.add(new WorldObject(1,  1, -1));
        tree.add(new WorldObject(1,  1,  1));
        
        System.out.println("///////////// TEST 1 //////////////");
        System.out.println("Ausgabe: " + tree.toString());
        System.out.println("Erwartete Ausgabe: (0, (1, (3), (4)), (2, (5), (6)))");
    }
}