/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: PalindromeChecker.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Robin Lane
 * **********************************************
 */

package assignment03PartB;

import java.util.Scanner;

//
// - Do not change the "main" method.
// - Please ADD CODE to complete implementing the program
//
public class PalindromeChecker {

    private static boolean isPalindrome(String string) 
    {
        // Remove uppercase and special characters
        string = removeSpecialChar(string.toLowerCase());

        // Turn the string into a char array, wrap those chars with the Character object wrapper
        Character[] wrappedArray = wrapCharArray(string.toCharArray());

        // Then intilize the stack with those Characters
        // Because of the LIFO nature of the stack, this will reverse the string (the last character will be in the front)
        OurStack<Character> stringStack = new OurStack<Character>(wrappedArray);

        // We only need to check half of the string, because palindromes are by definition symetric
        int halfwayPoint = (int) Math.ceil( ((double) wrappedArray.length) /2 );
        
        for(int i = 0; i < halfwayPoint; i++)
        {
            // if even one character does not match, we know it's not a palindrome
            if(!wrappedArray[i].equals(stringStack.pop()))
                return false;
        }

        // If we can make it through half the string and it's the same back and front, than it *is* a palindrome
        return true;
    }

    private static String removeSpecialChar(String string)
    {
        char[] characters = string.toCharArray();

        // set every char that's not a letter to 0, and count how many need to be removed 
        int numRemoved = 0; 
        for(int i = 0; i < characters.length; i++)
        {
            // 97 = a, 122 = z
            if(characters[i] < 97 || characters[i] > 122)
            {
                characters[i] = 0;
                numRemoved++;
            }
        }

        // new character array that is smaller based on how many were removed
        char[] savedChars = new char[characters.length - numRemoved];

        //Add each character that isn't a 0 to the smaller array
        int i = 0;
        for(int j = 0; j < characters.length; j++)
            if(characters[j] != 0)
            {
                savedChars[i] = characters[j];
                i++;
            }

        // turn it back into a string and return
        return new String(savedChars);
    }

    private static Character[] wrapCharArray(char[] array)
    {
        Character[] wrappedArray = new Character[array.length];

        for(int i = 0; i < array.length; i++)
            wrappedArray[i] = Character.valueOf(array[i]);

        return wrappedArray;
    }

    //
    // - Do not change the "main" method.
    // - Please ADD CODE to complete implementing the program
    //
    public static void main(String[] args) {
        //
        // - Do not change the "main" method.
        // - Please ADD CODE to complete implementing the program
        //
        Scanner input = new Scanner(System.in);
        System.out.print("[>>] Enter a string (or a ! to exit): ");
        String string = input.nextLine();

        while (!string.equals("!")) {
            if (isPalindrome(string)) {
                System.out.println(" [+] Yes. \"" + string + "\" IS a palindrome!");
            } else {
                System.out.println(" [-] No. \"" + string + "\" is NOT a palindrome!");
            }
            System.out.print("[>>] Enter a string: ");
            string = input.nextLine();
        }

        System.out.println("[<<] Thank you!");
        //
        // - Do not change the "main" method.
        // - Please ADD CODE to complete implementing the program
        //
    }
}