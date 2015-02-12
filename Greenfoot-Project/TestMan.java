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
    public void checkKeys() { //Facilitates user-controlled movement of the character
        double height = getImage().getHeight()/2;
        Actor platform = getOneObjectAtOffset(0, (int)height, Platform.class);
        if (Greenfoot.isKeyDown("Left")) //Moves left
            move(-5);
        if (Greenfoot.isKeyDown("Right")) //Moves right
            move(5);
        if (Greenfoot.isKeyDown("Up") && (getY()>=getWorld().getHeight()-height || platform!=null)) { //Makes player jump
            accelerate(pi/2, -15);
            System.out.println("Up detected");
        }
        if (Greenfoot.isKeyDown("Down")) { //Stops unwanted sideways movement that has happens when there's an error in the past
            changeXComp(0);
            System.out.println("Down detected");
        }
    }
    public double getHeight() {
        return getImage().getHeight();
    }
}