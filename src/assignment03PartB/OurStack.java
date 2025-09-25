/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: OurStack.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment03PartB;

public class OurStack<T> implements StackInterface<T> 
{
    private Node firstNode;

    public OurStack() {}

    public OurStack(T[] data)
    {
        for(T entry : data)
            this.push(entry);
    }

    @Override
    public void push(T newEntry)
    {
        firstNode = new Node(newEntry, firstNode);
    }

    @Override
    public T peek()
    {
        return firstNode.data;
    }

    @Override
    public T pop()
    {
        Node topNode = firstNode;
        firstNode = topNode.next;
        
        return topNode.data;
    }

    @Override
    public boolean isEmpty()
    {
        return firstNode == null;
    }

    @Override
    public void clear()
    {
        firstNode = null;
    }

    private class Node
    {
        private T data;
        private Node next;

        private Node(T data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
}