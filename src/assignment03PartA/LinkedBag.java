/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: LinkedBag.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment03PartA;

public final class LinkedBag<T> implements PrimaryDataStructureBagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;
    
    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean isEmpty()
    {
        //if there is no first node, then there are no nodes at all, therefore the bag is empty
        return firstNode == null;
    }

    @Override
    public int getCurrentSize()
    {
        return this.numberOfEntries;
    }

    @Override
    public boolean add(T newEntry)
    {
        // Create a node with the new data and connect it to the node chain before the first node
        // then by setting this new node to be the first node, it becomes part of the bag
        // as a result, each entry in the bag is pushed up by one index
        this.firstNode = new Node(newEntry, firstNode);
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean removeAllOccurrences(T[][] entries) {
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }
}