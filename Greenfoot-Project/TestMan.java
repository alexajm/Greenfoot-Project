import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestMan2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestMan extends BetterActor
{
    Force force = new Force();
    final double pi = Math.PI;
    int ammo = 3;
    int reloadTime = 10;
    
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
    }
    public TestMan() {
        rightExcess = 16;
        leftExcess = 15;
        botExcess = 2;
        topExcess = 1;
        detectPoints.add(new Coordinate(0, -((getImage().getHeight()-topExcess-botExcess)/2)-1));
        detectPoints.add(new Coordinate(-15, -11));
        detectPoints.add(new Coordinate(-15, 8));
        detectPoints.add(new Coordinate(-6, 27));
        detectPoints.add(new Coordinate(15, -11));
        detectPoints.add(new Coordinate(15, 8));
        detectPoints.add(new Coordinate(6, 27));
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
            System.out.println("Up detected");
        }
        if (Greenfoot.isKeyDown("S")) { //Stops unwanted sideways movement that has happens when there's an error in the past
            force.setXComp(0);
            System.out.println("Down detected");
        }
        if (Greenfoot.isKeyDown("Left") && ammo>0 && reloadTime>=10) {
            getWorld().addObject(new Bullet(180), getX()-widthLeft, getY());
            ammo--;
            reloadTime=0;
        }
        if (Greenfoot.isKeyDown("Right") && ammo>0 && reloadTime>=10) {
            getWorld().addObject(new Bullet(0), getX()+widthRight, getY());
            ammo--;
            reloadTime=0;
        }
    }
    public double getHeight() {
        return getImage().getHeight();
    }
    public int getScore() {
        return Scorekeeper.getScore();
    }
}
