/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: BlurbGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment03PartC;

import java.util.Random;

public class BlurbGenerator {

    // Random Number Generator
    Random rng;

    /**
     * Instantiates a random number generator needed for blurb creation.
     */
    public BlurbGenerator()
    {
        this.rng = new Random();
    }

    /**
     * Generates and returns a random Blurb. A Blurb is a Whoozit followed by
     * one or more Whatzits.
     */
    public String makeBlurb()
    {
        return makeWhoozit() + makeMultiWhatzits();
    }

    /**
     * Generates a random Whoozit. A Whoozit is the character 'x' followed by
     * zero or more 'y's.
     */
    private String makeWhoozit() 
    {
        return "x" + makeYString();
    }

    /**
     * Recursively generates a string of zero or more 'y's.
     */
    private String makeYString()
    {
        return "y".repeat(rng.nextInt(10));
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     */
    private String makeMultiWhatzits()
    {
        String whatzits = "";
        
        for(int i = 0; i < rng.nextInt(4) + 1; i++)
            whatzits += makeWhatzit();

        return whatzits;

    }

    /**
     * Generates a random Whatzit. A Whatzit is a 'q' followed by either a 'z'
     * or a 'd', followed by a Whoozit.
     */
    private String makeWhatzit()
    {
        return String.format
        (
            "%s%s%s",
            "q",
            rng.nextBoolean() ? "z" : "d",
            makeWhoozit()
        );
    }
}