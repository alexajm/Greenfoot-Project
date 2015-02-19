import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends BetterActor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        bulletMotion();
    }
    public Bullet(int direction) {
        setRotation(direction);
        if (direction==180) //Flips the image so that it's right side up
            getImage().mirrorVertically();
    }
    public void bulletMotion() { //Describes how the bullet moves
        move(10);
        Actor target = getOneIntersectingObject(BetterActor.class);
        if ((target!=null && !(target instanceof TestMan)) || isAtEdge()) { //When the bullet collides with either the edge of the world or another object,
            if (target instanceof Enemy)                                    //it disappears. If it collides with an enemy, the enemy disappears as well.
                getWorld().removeObject(target);
            getWorld().removeObject(this);
        }
    }
}
