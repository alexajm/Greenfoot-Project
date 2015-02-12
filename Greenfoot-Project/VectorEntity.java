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
    final double pi = Math.PI; //Writing Math.PI all the time is annoying
    
    /**
     * Act - do whatever the VectorEntity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        gravity();
    }   
    public VectorEntity(double xValue, double yValue) { //A constructor that accepts x- and y-components
        xComp = xValue;
        xComp = xValue;
    }
    public VectorEntity() { //Default constructor
        xComp = 0;
        yComp = 0;
    }
    public double getXComp() { //Returns the x-component of the vector
        return xComp;
    }
    public double getYComp() { //Returns the y-component of the vector
        return yComp;
    }
    public double getUnitXComp() { //Returns the x-component of the unit vector
        return xComp/Math.sqrt(Math.pow(xComp, 2)+Math.pow(yComp, 2));
    }
    public double getUnitYComp() { //Returns the y-component of the unit vector
        return yComp/Math.sqrt(Math.pow(xComp, 2)+Math.pow(yComp, 2));
    }
    public double getDirection() { //The vector's direction in radians
        return Math.tan(yComp/xComp);
    }
    public double getMagnitude() { //The vector's magnitude in cells
        return Math.sqrt(Math.pow(xComp, 2)+Math.pow(yComp, 2));
    }
    public void changeXComp(double xValue) { //Changes the vector's x-component
        xComp = xValue;
    }
    public void changeYComp(double yValue) { //Changes the vector's y-component
        yComp = yValue;
    }
    public void multiplyXComp(double xValue) { //Multiplies the vector's x-component
        xComp = xComp*xValue;
    }
    public void addVector(double xValue, double yValue) { //Adds one vector to another
        xComp += xValue;
        yComp += yValue;
    }

    public void subtractVector(double xValue, double yValue) { //Subtracts one vector from another
        xComp -= xValue;
        yComp -= yValue;
    }
    public String toString() { //Converts vector to string
        return "(" + xComp + ", " + yComp + ")";
    }
    public String norm() { //Converts unit vector to string
        return "(" + getUnitXComp() + ", " + getUnitYComp() + ")";
    }
    public void move() { //Applies movement based on the direction and magnitude of an object's force vector
        double x = getX() + getXComp();
        double y = getY() + getYComp();
        setLocation((int)x, (int)y);
    }
    public void accelerate(double direction, double magnitude) { //Accelerates an object in a certain direction with a certain magnitude
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
    public void gravity() { //Applies gravity when object is not on either a platform or the ground
        double height = getImage().getHeight()/2;
        Actor platform = getOneObjectAtOffset(0, (int)height, Platform.class);
        if (getY()>=getWorld().getHeight()-height || platform!=null) { //If the object is at the bottom of the screen or there's a platform below its feet,
            changeYComp(0);                                            //it will stop falling under the influence of gravity
        } else {
            accelerate((3*pi)/2, -1);
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
        setLocation(dX - 50, getY());
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
        setLocation(dX+50, getY());
    }
    public void applyGravity()
    {
        if (!onGround())
        {
            gravity();
        }
        else 
        {
            yComp = 0;
        }
    }
    //public boolean hitBottomOfPlatform()
    //{
       //int actorHeight = getImage().getHeight();
       //int vDistance = (int) (actorHeight / 2);
       
    //}
    public boolean canSee(Class clss) 
    {
        return getOneObjectAtOffset(0, 0, clss) != null;
    }
}   
