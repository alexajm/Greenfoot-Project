import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Platform
{
    private static String exitText;
    
    /**
     * Act - do whatever the Exit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkForPlayer();
    }    
    private void checkForPlayer() { //Checks to see if touching the player
        Actor player = (Actor) getOneObjectAtOffset(0, -getImage().getHeight()/2, TestMan.class); //Looks for players standing on top of the block
        if (player!=null && Scorekeeper.getScore()>=3) {
            getWorld().showText(exitText, getWorld().getWidth()/2, getWorld().getHeight()/2);
            GameWorld.incrementLevel();
            ((GameWorld) getWorld()).changeLevel();
        }
    }
    public static void setText(String text) {
        exitText = text;
    }
    public static String getText() {
        return exitText;
    }
}
