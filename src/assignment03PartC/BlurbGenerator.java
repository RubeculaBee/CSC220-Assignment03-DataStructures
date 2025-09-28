/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: BlurbGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Robin Lane
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
        String yChain = "";

        if(rng.nextBoolean())
        {
            yChain += "y";
            yChain += makeYString();
        }
        
        return yChain;
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     */
    private String makeMultiWhatzits()
    {
        String whatzits = makeWhatzit();
        
        if(rng.nextBoolean())
            whatzits += makeMultiWhatzits();
        
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