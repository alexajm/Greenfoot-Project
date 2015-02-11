import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamond here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamond extends TorqueEntity
{
    /**
     * Act - do whatever the Diamond wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        checkForPlayer();
        diamondMovement();
    }
    public Diamond() {
        setRotation(15);
    }
    private void checkForPlayer() { //Checks to see if touching the player
        Actor player = (Actor) getOneObjectAtOffset(0, 0, TestMan.class);
        if (player!=null) { //If there's a player touching the diamond, the score is incremented and the diamond is removed
            Scorekeeper.incrementDiamonds();
            getWorld().removeObject(this);
        }
    }
    public void diamondMovement() {
        if (getRotation()>0 && getRotation()<90) {
            addTorque(0.15);
        }
        if (getRotation()>270 && getRotation()<359) {
            subtractTorque(0.15);
        }
    }
}
