import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemies extends VectorEntity
{
    private int randomNum = Greenfoot.getRandomNumber(2);
    /**
     * Act - do whatever the Enemies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move();
    }   
    
    public void move() //Randomly moves the enemy left or right
    {
        int dx = -2;
        addVector(-2, 0);
        if(!onGround())
        {
            this.multiplyXComp(-1);
        }
    }
    
    public void addVector(double xValue, double yValue)
    {
        super.addVector(xValue, yValue);
        setLocation((int)this.getXComp(), (int)this.getYComp());
    }
}
    
  