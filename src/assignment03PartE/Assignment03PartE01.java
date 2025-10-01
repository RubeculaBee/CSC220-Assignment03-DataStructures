/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Assignment02PartE01.java
 * Author: Duc Ta
 * Author: Robin Lane
 * **********************************************
 */

package assignment03PartE;

public class Assignment03PartE01 {
    public static void main(String[] args)
    {
        originalAlgorithm();
        System.out.println();
        expandedAlgorithm();
    }

    static void originalAlgorithm()
    {
        int i, n = 5, sum = 5;
        for (i = 5; i < 3 * n; i++) {
            sum *= n + i * 7 + 37;
        }
        System.out.println(sum);   
    }

    static void expandedAlgorithm()
    {
        int i, n, sum;
        n = 5;
        sum = 5;
        for(i=5; i < 3 * n; i = i + 1)
        {
            sum = sum * (n + i * 7 + 37);
        }
        System.out.println(sum);
    }
}
