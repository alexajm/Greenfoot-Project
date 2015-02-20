import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamond2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamond extends BetterActor
{
    private Force force = new Force();
    
    /**
     * Act - do whatever the Diamond wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        force.move(this);
        force.gravity(this);
        checkForPlayer();
        diamondMovement();
    }
    public Diamond() {
        setRotation(17);
    }
    private void checkForPlayer() { //Checks to see if touching the player
        Actor player = (Actor) getOneObjectAtOffset(0, 0, Player.class);
        if (player!=null) { //If there's a player touching the diamond, the score is incremented and the diamond is removed
            Scorekeeper.incrementDiamonds();
            getWorld().removeObject(this);
        }
    }
    private void diamondMovement() { //Describes the swaying movement of the diamond
        if (getRotation()>0 && getRotation()<90) {
            force.subtractTorque(0.15);
        }
        if (getRotation()>270 && getRotation()<359) {
            force.addTorque(0.15);
        }
    }
}
