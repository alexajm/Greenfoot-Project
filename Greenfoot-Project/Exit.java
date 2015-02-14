import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Platform
{
    /**
     * Act - do whatever the Exit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkForPlayer();
    }    
    private void checkForPlayer() { //Checks to see if touching the player
        Actor player = (Actor) getOneObjectAtOffset(0, -getImage().getHeight()/2, TestMan.class);
        if (player!=null && Scorekeeper.getScore()>=3) {
            System.out.println("Exit active");
            getWorld().showText("You Won!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
