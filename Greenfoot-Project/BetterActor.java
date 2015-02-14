import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BetterActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BetterActor extends Actor
{
    int rightExcess = 0;
    int leftExcess = 0;
    int botExcess = 0;
    int topExcess = 0;
    
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
