import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestMan extends VectorEntity
{
    final double pi = Math.PI;
    
    /**
     * Act - do whatever the TestMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        gravity();
        checkKeys();
        move();
    }
    public void gravity() {
        if (getY()>=getWorld().getHeight()-35) {
            changeYComp(0.0);
        } else {
            accelerate((3*pi)/2, -1);
        }
    }
    public void accelerate(double direction, double magnitude) {
        addVector(magnitude*Math.cos(direction), magnitude*Math.sin(direction));
    }
    public void move() {
        double x = getX() + getXComp();
        double y = getY() + getYComp();
        setLocation((int)x, (int)y);
    }
    public void checkKeys() {
        if (Greenfoot.isKeyDown("left"))
            move(-5);
        if (Greenfoot.isKeyDown("Right"))
            move(5);
        if (Greenfoot.isKeyDown("Up") && getY()>=getWorld().getHeight()-35)
            accelerate(3*pi/2, 15);
    }
}