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
        gravity();
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
    public void setMagnitude(double mag){ //Sets magnitude
        magnitude = mag;
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
            setMagnitude(-1);
            accelerate((3*pi)/2, magnitude);
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
    public void applyGravity()
    {
       Actor main = getOneIntersectingObject(Platform.class);
       if (main == null)
        {
            gravity();
        }
       else
       {
           setMagnitude(0);
           accelerate(pi, magnitude);
       }
    }
}
