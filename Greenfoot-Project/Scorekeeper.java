import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scorekeeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scorekeeper extends BetterActor
{
    private static int numDiamonds = 0;
    private GreenfootImage transparent = new GreenfootImage("transparent.png");
    private GreenfootImage number1 = new GreenfootImage("number1.png");
    private GreenfootImage number2 = new GreenfootImage("number2.png");
    private GreenfootImage number3 = new GreenfootImage("number3.png");
    private GreenfootImage number4 = new GreenfootImage("number4.png");
    private GreenfootImage number5 = new GreenfootImage("number5.png");
    GreenfootImage[] scores = {transparent, number1, number2, number3, number4, number5}; //An array of images that represent each score (0, 1, 2,...)
    private boolean boundsException = false; //Keeps track of whether there's been an ArrayIndexOutOfBoundsException
    
    /**
     * Act - do whatever the Scorekeeper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setScore();
    }
    public Scorekeeper() { //Constructor makes the scorekeeper invisible until player has one or more diamonds
        setImage(transparent);
    }
    public static void incrementDiamonds() { //Increments the number of diamonds the player has collected
        numDiamonds++;
    }
    public void setScore() { //Changes the score to reflect the number of diamonds collected so far
        try {    
            if (!boundsException)
                setImage(scores[numDiamonds]);
        } catch (ArrayIndexOutOfBoundsException e) {    //If the array limit is reached, the program catches the exception and 
            System.out.println("Max diamonds reached"); //stops changing the counter.
            boundsException = true;
        }
    }
    public static int getScore() {
        return numDiamonds;
    }
}
