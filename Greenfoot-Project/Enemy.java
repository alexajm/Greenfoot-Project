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
    private GreenfootImage walking1 = new GreenfootImage("Alien.Still.png");
    private GreenfootImage walking2 = new GreenfootImage("Alien.Walking.png");
    private int moveTime = 1; //Iterator for the animation of the enemy's movement
    
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
        enemyAnimation();
    }
    public Enemy() {
        rightExcess = 0;
        leftExcess = 0;
        botExcess = 4;
        topExcess = 0;
    }
    public void enemyMovement() { //Describes how the enemy moves
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
            walking1.mirrorHorizontally();
            walking2.mirrorHorizontally();
        }
    }

    public void decrementPlayersHealth() {
        if (force.canSee(Player.class, this)) {
            Health.setHealth(Health.getHealth()-0.5);
        }
    }
    public void enemyAnimation() { //Animates the enemy's movement
        if (moveTime==10)
            setImage(walking2);
        if (moveTime>=20) {
            setImage(walking1);
            moveTime = 1;
        }
        moveTime++;
    }
}
