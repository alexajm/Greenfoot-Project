/**
 * Write a description of class Torque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TorqueEntity extends VectorEntity
{
    /**
     * Act - do whatever the VectorEntity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }
    public TorqueEntity() { //For torque, yComp is redundant and therefore not used. Only xComp will be used from here
        super(0, 0);         //onwards and refers to the rotational forces. Positive values represent counterclockwise rotation.
    }
    public double getDirection() { //Override of VectorEntity's getDirection()
        int direction = 0; //0 means the object is not rotating
        if (getXComp()>0)
            direction = 1; //Counterclockwise
        if (getXComp()<0)
            direction = -1; //Clockwise
        return direction;
    }
    public double getMagnitude() { //Override of VectorEntity's getMagnitude()
        return getXComp();
    }
    public void addTorque(double xValue) { //Adds torque of a certain magnitude
        super.addVector(xValue, 0);
    }
    public void subtractTorque(double xValue) { //Subtracts torque of a certain magnitude
        super.subtractVector(xValue, 0);
    }
    public void move() { //Movement is rotation of the object
        double x = getRotation() - getXComp();
        setRotation((int)x);
    }
}
