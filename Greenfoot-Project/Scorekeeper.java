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
    private static int ammo = 0;
    
    /**
     * Act - do whatever the Scorekeeper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setScore();
    }
    public Scorekeeper() {
    }
    public static void incrementDiamonds() { //Increments the number of diamonds the player has collected
        numDiamonds++;
    }
    public static void incrementAmmo() { //Increments the player's ammo
        ammo++;
    }
    public static void decrementAmmo() { //Decrements the player's ammo
        ammo--;
    }
    public void setScore() { //Changes the score to reflect the number of diamonds collected so far
        if (numDiamonds>=0)
            getWorld().showText(Integer.toString(numDiamonds), 55, 27);
        else
            getWorld().showText("", 55, 27);
        if (numDiamonds>=0)
            getWorld().showText(Integer.toString(ammo), 55, 75);
        else
            getWorld().showText("", 55, 75);     
    }
    public static int getScore() { //Returns the number of diamonds the player has collected
        return numDiamonds;
    }
    public static int getAmmo() { //Returns the amount of ammo the player has
        return ammo;
    }
    public static void setDiamonds(int diamonds) { //Sets the number of diamonds the player has
        numDiamonds = diamonds;
    }
    public static void setAmmo(int ammunition) { //Sets the amount of ammo the player has
        ammo = ammunition;
    }
}