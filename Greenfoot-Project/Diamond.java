import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamond here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamond extends NonvectorEntities
{
    /**
     * Act - do whatever the Diamond wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkForPlayer();
    } 
    private void checkForPlayer() {
        Actor player = (Actor) getOneObjectAtOffset(0, 0, TestMan.class);
        System.out.println("Diamond touch");
        if (player!=null) {
            numDiamonds++;
            getWorld().removeObject(this);
        }
    }
}
