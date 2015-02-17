import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class BetterActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BetterActor extends Actor
{
    int rightExcess = 0; //Images may have excess space along their sides that is transparent, but affects
    int leftExcess = 0;  //collision detection. These values, which can be changed for individual objects
    int botExcess = 0;   //and the images associated with them, represent the size of that space on all sides
    int topExcess = 0;   //of the object (in pixels) and allow the collision detection to ignore it.
    ArrayList detectPoints = new ArrayList();
    
    /**
     * Act - do whatever the BetterActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
    }    
    public Actor betterGetOneObjectAtOffset(int dx, int dy, java.lang.Class cls) {
        Actor actor = super.getOneObjectAtOffset(dx, dy, cls);
        return actor;
    }
}
