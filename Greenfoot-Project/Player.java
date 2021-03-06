import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestMan2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends BetterActor
{
    private Force force = new Force();
    private final double pi = Math.PI;
    private int reloadTime = 10;
    private int healthTime = 0;
    GreenfootSound cry = new GreenfootSound("cry.wav");
    GreenfootSound punch = new GreenfootSound("punch.wav");
    /**
     * Act - do whatever the TestMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        force.move(this);
        force.lookForWall(this);
        force.lookForCeiling(this);
        force.gravity(this);
        //force.move2(this);
        checkKeys();
        reloadTime++;
        decrementHealth();
    }
    public Player() {
        rightExcess = 16;
        leftExcess = 15;
        botExcess = 1;
        topExcess = 1;
        /*detectPoints.add(new Coordinate(0, -((getImage().getHeight()-topExcess-botExcess)/2)-1));
        detectPoints.add(new Coordinate(-15, -11));
        detectPoints.add(new Coordinate(-15, 8));
        detectPoints.add(new Coordinate(-6, 27));
        detectPoints.add(new Coordinate(15, -11));
        detectPoints.add(new Coordinate(15, 8));
        detectPoints.add(new Coordinate(6, 27));*/
    }
    public void checkKeys() { //Facilitates user-controlled movement of the character
        double height = getImage().getHeight()/2;
        int widthRight = getImage().getWidth()/2 - rightExcess;
        int widthLeft = getImage().getWidth()/2 - leftExcess;
        Actor platform = getOneObjectAtOffset(0, (int)height, Platform.class);
        if (Greenfoot.isKeyDown("A")) //Moves left
            move(-5);
        if (Greenfoot.isKeyDown("D")) //Moves right
            move(5);
        if (Greenfoot.isKeyDown("W") && (getY()>=getWorld().getHeight()-height || platform!=null)) { //Makes player jump
            force.addVectorInDirection(90, -15.0);
        }
        if (Greenfoot.isKeyDown("S")) { //Stops unwanted sideways movement that has happened when there's an error in the past
            force.setXComp(0);
        }
        if (Greenfoot.isKeyDown("Left") && Scorekeeper.getAmmo()>0 && reloadTime>=10) { //Fires bullet left
            getWorld().addObject(new Bullet(180), getX()-widthLeft, getY());
            Greenfoot.playSound("fire.mp3");
            Scorekeeper.decrementAmmo();
            reloadTime=0;
        }
        if (Greenfoot.isKeyDown("Right") && Scorekeeper.getAmmo()>0 && reloadTime>=10) { //Fires bullet right
            getWorld().addObject(new Bullet(0), getX()+widthRight, getY());
            Greenfoot.playSound("fire.mp3");
            Scorekeeper.decrementAmmo();
            reloadTime=0;
        }
    }
    public double getHeight() { //Returns height of image
        return getImage().getHeight();
    }
    public int getScore() { //Returns player's score
        return Scorekeeper.getScore();
    }
    public void decrementHealth(){ //Decreases the player's health
        Actor enemy = betterGetOneObjectAtOffset(0, 0, Enemy.class);
        if (enemy!=null && healthTime>=15)
        {
            Health.setHealth(Health.getHealth()-0.5);
            punch.play();
            cry.play();
            healthTime=0;
        } else
            healthTime++;
    }
}
