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
    private static int ammo = 3;
    
    /**
     * Act - do whatever the Scorekeeper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setScore();
    }
    public Scorekeeper() { //Constructor makes the scorekeeper invisible until player has one or more diamonds
    }
    public static void incrementDiamonds() { //Increments the number of diamonds the player has collected
        numDiamonds++;
    }
    public static void incrementAmmo() {
        ammo++;
    }
    public static void decrementAmmo() {
        ammo--;
    }
    public void setScore() { //Changes the score to reflect the number of diamonds collected so far
        getWorld().showText(Integer.toString(numDiamonds), 55, 27);
        getWorld().showText(Integer.toString(ammo), 55, 75);
    }
    public static int getScore() {
        return numDiamonds;
    }
    public static int getAmmo() {
        return ammo;
    }
}