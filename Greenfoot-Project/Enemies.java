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
    private int actorHeight = getImage().getHeight();
    private int actorWidth = getImage().getWidth();
    private int checkX = (int) actorWidth/2;
    private int checkY = (int) actorHeight/2;
    private int speed = 1; 
    /**
     * Act - do whatever the Enemies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        //move();
        enemyMovement();
    }   
    
    public void move() //Moves enemy back and forth
    {
        Actor ground = getOneObjectAtOffset(checkX, checkY, Platform.class);
        if(ground == null)
        {
            speed *= -1; // Reverses direction
            checkX*= -1; // Looks for a negative number
        }
        else
        {
            move(speed);
        }
    }
    
    public void addVector(double xValue, double yValue)
    {
        super.addVector(xValue, yValue);
        setLocation((int)this.getXComp(), (int)this.getYComp());
    }
    
    public void enemyMovement() {
        Actor platform = getOneObjectAtOffset(0, checkY, Platform.class);
        move(speed);
        if (getY()<getWorld().getHeight()-checkY && platform==null) {
            move(-speed);
            speed*=1;
        }
    }
}
    
  