import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends BetterActor
{
    Force force = new Force();
    private int speed = 2;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        force.move(this);
        force.gravity(this);
        force.lookForWall(this);
        force.lookForCeiling(this);
        enemyMovement();
    }
    public Enemy() {
        rightExcess = 16;
        leftExcess = 15;
        botExcess = 2;
        topExcess = 1;
    }
    public void enemyMovement() {
        move(speed);
        int widthLeft = getImage().getWidth()/2 - leftExcess;
        int widthRight = getImage().getWidth()/2 - rightExcess;
        int height = getImage().getHeight() - botExcess;
        Actor platformLeft = getOneObjectAtOffset(-widthLeft, height, Platform.class);
        Actor platformRight = getOneObjectAtOffset(widthRight, height, Platform.class);
        boolean left = platformLeft!=null;
        boolean right = platformRight!=null;
        if (force.isTouchingWall(this) || (!(left&&right)&&(left||right))) {
            move(-speed);
            speed*=-1;
        }
    }
}
