/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: PascalsTriangleGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Robin Lane
 * **********************************************
 */

package assignment03PartD;

public class PascalsTriangleGenerator 
{
    private int[] row = {1};

    public PascalsTriangleGenerator() {}

    public int[] computeRow(int rowToCompute) 
    {
        if(rowToCompute > 1)
            row = computeRow(rowToCompute - 1);
        
        return rowSum();
    }

    private int[] rowSum()
    {
        int[] newRow = new int[row.length + 1];

        for(int i = 0; i < newRow.length; i++)
            newRow[i] = safeGet(row, i) + safeGet(row, i-1);

        return newRow;
    }

    // Get an item from an array, but return 0 if the index is out of bounds instead of crashing
    private int safeGet(int [] array, int index)
    {
        if(index < 0 || index >= array.length)
            return 0;
        
        return array[index];
    }
}
