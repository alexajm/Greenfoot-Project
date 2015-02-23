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
        Actor player = (Actor) getOneObjectAtOffset(0, -getImage().getHeight()/2, Player.class); //Looks for players standing on top of the block
        Actor ammo = (Actor) getOneObjectAtOffset(0, -getImage().getHeight()/2 + 1, Ammo.class);
        if (player!=null) { //If the player stands on the block, they drown and the game ends
            Health.setHealth(0);
        }
        if (ammo!=null) { //If ammo drops fall on the water, they respawn
            getWorld().removeObject(ammo);
            getWorld().addObject(new Ammo(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
        }
    }
}
