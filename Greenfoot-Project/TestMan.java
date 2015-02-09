import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestMan extends VectorEntity
{
    /**
     * Act - do whatever the TestMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        checkKeys();
    }
    public void checkKeys() {
        if (Greenfoot.isKeyDown("left"))
            move(-5);
        if (Greenfoot.isKeyDown("Right"))
            move(5);
        if (Greenfoot.isKeyDown("Up") && getY()>=getWorld().getHeight()-40) {
            accelerate(3*pi/2, 15);
            System.out.println("Up detected");
        }
    }
}