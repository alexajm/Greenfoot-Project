import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestMan2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestMan extends BetterActor
{
    Force force = new Force();
    final double pi = Math.PI;
    
    /**
     * Act - do whatever the TestMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        force.move(this);
        force.gravity(this);
        force.lookForWall(this);
        force.lookForCeiling(this);
        checkKeys();
    }
    public TestMan() {
        rightExcess = 16;
        leftExcess = 15;
        botExcess = 2;
        topExcess = 1;
    }
    public void checkKeys() { //Facilitates user-controlled movement of the character
        double height = getHeight()/2;
        Actor platform = getOneObjectAtOffset(0, (int)height, Platform.class);
        if (Greenfoot.isKeyDown("Left")) //Moves left
            move(-5);
        if (Greenfoot.isKeyDown("Right")) //Moves right
            move(5);
        if (Greenfoot.isKeyDown("Up") && (getY()>=getWorld().getHeight()-height || platform!=null)) { //Makes player jump
            force.addVectorInDirection(90, -15.0);
            System.out.println("Up detected");
        }
        if (Greenfoot.isKeyDown("Down")) { //Stops unwanted sideways movement that has happens when there's an error in the past
            force.setXComp(0);
            System.out.println("Down detected");
        }
    }
    public double getHeight() {
        return getImage().getHeight();
    }
    public int getScore() {
        return Scorekeeper.getScore();
    }
}
