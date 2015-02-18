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
        if (direction==180)
            getImage().mirrorVertically();
    }
    public void bulletMotion() {
        move(10);
        Actor target = getOneIntersectingObject(BetterActor.class);
        if (target!=null && !(target instanceof TestMan)) {
            if (target instanceof Enemy)
                getWorld().removeObject(target);
            getWorld().removeObject(this);
        }
    }
    public boolean isTouchingEdge() {
        return isAtEdge();
    }
}
