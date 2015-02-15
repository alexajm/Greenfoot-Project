import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Water extends Platform
{
    /**
     * Act - do whatever the Water wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkForPlayer();
    }    
    private void checkForPlayer() { //Checks to see if touching the player
        Actor player = (Actor) getOneObjectAtOffset(0, -getImage().getHeight()/2, TestMan.class); //Looks for players standing on top of the block
        if (player!=null) {
            System.out.println("Drowning");
            getWorld().showText("You Lose", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop(); //With a score of three or more, the game will end when the player stands on the block
        }
    }
}
