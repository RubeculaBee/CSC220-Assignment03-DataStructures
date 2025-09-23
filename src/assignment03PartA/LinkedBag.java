/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: LinkedBag.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Robin Lane
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
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[numberOfEntries];

        Node currentNode = firstNode;
        for(int i = 0; i < this.numberOfEntries; i++)
        {
            array[i] = currentNode.data;
            currentNode = currentNode.next;
        }
        
        return array;
    }

    @Override
    public boolean removeAllOccurrences(T[][] entries)
    {
        System.out.println("[+] Removing 2D test array items from the bag...");

        System.out.println(" [-] Converting 2D array to 1D...");
        T[] array1D = convertArray(entries);

        System.out.println(" [-] Removing duplicates in 1D array...");
        array1D = removeDuplicates(array1D);

        displayFinalArray(array1D);

        return true;
    }

    private T[] convertArray(T[][] array2D)
    {
        int arraySize = 0;
        for(T[] array : array2D)
            arraySize += array.length;
        
        @SuppressWarnings("unchecked")
        T[] array1D = (T[]) new Object[arraySize];

        // this index used to count our progress through the 1D array
        int i = 0;
        for(T[] row : array2D)
            for(T col : row)
            {
                array1D[i] = col;
                i++;
            }
        
        return array1D;
    }

    private T[] removeDuplicates(T[] array)
    {
        //Count how much smaller the new array needs to be
        int numRemovedEntries = 0;

        // For each element in the 1D array
        for(int i = 0; i < array.length; i++)
            // for each element ahead of the one we're currently looking at (we don't need to check ones we already checked)
            for(int j = i+1; j < array.length; j++)
                // we must first check if the current entry is null, because if it is we can't call .equals() from it.
                if(array[i] != null && array[j] != null && array[j].equals(array[i]))
                {
                    array[j] = null;
                    numRemovedEntries++;
                }
        
        @SuppressWarnings("unchecked")
        T[] shortArray = (T[]) new Object[array.length-numRemovedEntries];

        // Keeps our place in the shorter array while we loop through the long array 
        int i = 0;
        for(T entry : array)
            // if an entry wasn't removed, add it to the short array and move to the next index in the short array
            if(entry != null)
            {
                shortArray[i] = entry;
                i++;
            }
        
        return shortArray;
    }

    private void displayFinalArray(T[] array)
    {
        System.out.print(" [>] The final 1D array now contains: ");
        for(T entry : array)
            System.out.print(entry + " ");
        System.out.println();
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