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
        randomMove();
        onGround();
    }   
    
    public void randomMove() //Randomly moves the enemy left or right
    {
        if (randomNum==1)
        {
            move(-5);
        }
        else
        {
            move(5);
        }
    }
    
    public boolean onGround() //Platform detection, stops enemy if he hits a platform and lets him randomly move if he doesn't
    {
        int actorHeight = getImage().getHeight();
        int lookForGround = (int) (actorHeight/2) + 5;
        Actor ground = getOneObjectAtOffset(0, lookForGround, Platform.class);
        if (ground == null)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}
    
  