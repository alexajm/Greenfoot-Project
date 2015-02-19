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
    private double healthEnemy = 2;
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
        Actor platformLeft = getOneObjectAtOffset(-widthLeft, height, Platform.class); //Looks for platform below and to the left
        Actor platformRight = getOneObjectAtOffset(widthRight, height, Platform.class); //Looks for platform below and to the right
        boolean left = platformLeft!=null;
        boolean right = platformRight!=null;
        if (force.isTouchingWall(this) || (!(left&&right)&&(left||right))) { //If touching a wall, the enemy turns. If there's a platform below it on one
            move(-speed);                                                    //side, but not the other, it turns as well. This uses an XOR gate.
            speed*=-1;
        }
    }
   
}
