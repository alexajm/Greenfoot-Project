import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scorekeeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scorekeeper
{
    private static int numDiamonds = 0;
    
    /**
     * Act - do whatever the Scorekeeper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public static void incrementDiamonds() { //Increments the number of diamonds the player has collected
        numDiamonds++;
    }
}
