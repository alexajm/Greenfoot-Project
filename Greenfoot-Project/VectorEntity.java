import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VectorEntity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VectorEntity extends Actor
{
    private double xComp; //The net force vector's x-component
    private double yComp; //The net force vector's y-component
    private double magnitude; //The magnitude of the force acting on actor
    final double pi = Math.PI;
    
    /**
     * Act - do whatever the VectorEntity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        applyGravity();
        move();
    }   
    public VectorEntity(double xValue, double yValue) { //A constructor that accepts x- and y-components
        xComp = xValue;
        xComp = xValue;
    }
    public VectorEntity() { //Default constructor
        xComp = 0;
        yComp = 0;
    }
    public double getXComp() {
        return xComp;
    }
    public double getYComp() {
        return yComp;
    }
    public double getUnitXComp() {
        return xComp/Math.sqrt(Math.pow(xComp, 2)+Math.pow(yComp, 2));
    }
    public double getUnitYComp() {
        return yComp/Math.sqrt(Math.pow(xComp, 2)+Math.pow(yComp, 2));
    }
    public double getDirection() { //The vector's direction in radians
        return Math.tan(yComp/xComp);
    }
    public double getMagnitude() { //The vector's magnitude in cells
        return Math.sqrt(Math.pow(xComp, 2)+Math.pow(yComp, 2));
    }
    public void changeXComp(double xValue) {
        xComp = xValue;
    }
    public void changeYComp(double yValue) {
        yComp = yValue;
    }
    public void addVector(double xValue, double yValue) {
        xComp += xValue;
        yComp += yValue;
    }
    public void subtractVector(double xValue, double yValue) {
        xComp -= xValue;
        yComp -= yValue;
    }
    public String toString() {
        return "(" + xComp + ", " + yComp + ")";
    }
    public String norm() {
        return "(" + getUnitXComp() + ", " + getUnitYComp() + ")";
    }
    public void gravity() {
        if (getY()>=getWorld().getHeight()-20) {
            changeYComp(0.0);
        } else {

            accelerate((3*pi)/2, -1);
        }
    }
    public void move() {
        double x = getX() + getXComp();
        double y = getY() + getYComp();
        setLocation((int)x, (int)y);
    }
    public void accelerate(double direction, double magnitude) {
        addVector(magnitude*Math.cos(direction), magnitude*Math.sin(direction));
    
    }
    public boolean onGround() //Platform detection, stops enemy if he hits a platform and lets him randomly move if he doesn't
    {
        int actorHeight = getImage().getHeight()+5;
        int lookForGround = (int) (actorHeight/2);
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
    public boolean lookForRightWall()
    {
        int actorWidth = getImage().getWidth();
        int lookForRightWall = (int) (actorWidth/2);
        Actor rightWall = getOneObjectAtOffset(lookForRightWall, 0, Platform.class);
        if (rightWall == null)
        {
            return false;
        }
        else
        {
            stopAtRightWall(rightWall);
            return true;
        }
    }
    public void stopAtRightWall(Actor rightWall)
    {
        int wallWidth = rightWall.getImage().getWidth();
        int dX = rightWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(dX - 5, getY());
    }
    public boolean lookForLeftWall()
    {
        int actorWidth = getImage().getWidth();
        int lookForLeftWall = (int) (actorWidth/-2);
        Actor leftWall = getOneObjectAtOffset(lookForLeftWall, 0, Platform.class);
        if (leftWall == null)
        {
            return false;
        }
        else
        {
            stopAtLeftWall(leftWall);
            return true;
        }
    }
    public void stopAtLeftWall(Actor leftWall)
    {
        int wallWidth = leftWall.getImage().getWidth();
        int dX = leftWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(dX+5, getY());
    }
    public void applyGravity()
    {
        if (!onGround())
        {
            gravity();
        }
    }
    public void collisionTest()
    {
        if (canSee(Platform.class))
        {
            accelerate(3*pi/2, -1);
        }
    }
    public boolean canSee(Class clss) 
    {
        return getOneObjectAtOffset(0, 0, clss) != null;
    }
}

