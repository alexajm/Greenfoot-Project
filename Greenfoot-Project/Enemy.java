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
        if (force.isTouchingWall(this)) {
            move(-speed);
            speed*=-1;
        }
    }
}
