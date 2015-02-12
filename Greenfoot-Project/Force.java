import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Force here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Force  
{
    private double xComp; //X-component of the force vector in the plane
    private double yComp; //Y-component of the force vector in the plane
    private double zComp; //Torque vector
    private double pi = Math.PI;
    
    public Force() { //Default constructor
        xComp = 0;
        yComp = 0;
        zComp = 0;
    }
    public Force(double x, double y, double z) { //Constructor taking values for the x-component, y-component, and torque
        xComp = x;
        yComp = y;
        zComp = z;
    }
    
    public double getXComp() { //Returns the x-component of the vector
        return xComp;
    }
    public double getYComp() { //Returns the y-component of the vector
        return yComp;
    }
    public double getZComp() { //Returns magnitude of torque
        return zComp;
    }
    public double getDirectionOfForce() { //The direction of the forces acting in the plane in degrees
        return Math.toDegrees(Math.tan(yComp/xComp));
    }
    public double getMagnitudeOfForce() { //The magnitude of the forces acting in the plane in cells
        return Math.sqrt(Math.pow(xComp, 2)+Math.pow(yComp, 2));
    }
    public double getDirectionOfTorque() { //The direction of the torque
        int direction = 0; //Means the object is not rotating
        if (getZComp()>0)
            direction = -1; //Clockwise
        if (getZComp()<0)
            direction = 1; //Counterclockwise
        return direction;
    }
    public void setXComp(double xValue) { //Changes the force's x-component
        xComp = xValue;
    }
    public void setYComp(double yValue) { //Changes the force's y-component
        yComp = yValue;
    }
    public void setZComp(double zValue) { //Changes the torque
        zComp = zValue;
    }
    public void addVector(double xValue, double yValue) { //Adds one vector to another
        xComp += xValue;
        yComp += yValue;
    }
    public void addVectorInDirection(int direction, double magnitude) { //Adds one vector to another, direction is in degrees (0-359)
        addVector(magnitude*Math.cos(Math.toRadians(direction)), magnitude*Math.sin(Math.toRadians(direction)));
    }
    public void addVector(Force force) { //Adds one vector to another
        addVector(force.getXComp(), force.getYComp());
    }
    public void subtractVector(double xValue, double yValue) { //Subtracts one vector from another
        xComp -= xValue;
        yComp -= yValue;
    }
    public void subtractVector(int direction, double magnitude) { //Subtracts one vector from another, direction is in degrees (0-359)
        subtractVector(magnitude*Math.cos(Math.toRadians(direction)), magnitude*Math.sin(Math.toRadians(direction)));
    }
    public void subtractVector(Force force) { //Subtracts one vector from another
        subtractVector(force.getXComp(), force.getYComp());
    }
    public void addTorque(double torque) { //Adds torque of a certain magnitude
        zComp += torque;
    }
    public void subtractTorque(double torque) { //Subtracts torque of a certain magnitude
        zComp -= torque;
    }
    public String toString() { //Converts vector to string
        return "(" + xComp + ", " + yComp + ", " + zComp + ")";
    }
    public void move(Actor actor) { //Applies movement to actors based on the x-component, y-component, and torque
        double x = actor.getX() + xComp;
        double y = actor.getY() + yComp;
        double z = actor.getRotation() + zComp;
        actor.setLocation((int)x, (int)y);
        actor.setRotation((int)z);
    }
    public void gravity(Actor actor) { //Applies gravity to actors
        double height = actor.getImage().getHeight()/2;
        //Actor platform = actor.getOneObjectAtOffset(0, (int)height, Platform.class);
        if (actor.getY()>=actor.getWorld().getHeight()-height) {
            setYComp(0);
        } else {
            addVectorInDirection(270, -1);
        }
    }
}
