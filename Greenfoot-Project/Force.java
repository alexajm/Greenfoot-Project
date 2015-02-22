````import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

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
    public void move(BetterActor actor) { //Applies movement to actors based on the x-component, y-component, and torque
        double x = actor.getX() + xComp;
        double y = actor.getY() + yComp;
        double z = actor.getRotation() + zComp;
        double height = actor.getImage().getHeight()/2 - actor.botExcess - 1;
        actor.setLocation((int)x, (int)y); //The new position after movement is set
        actor.setRotation((int)z);
        Actor platform = actor.betterGetOneObjectAtOffset(0, (int)height, Platform.class); //Searches for platforms the actor overlaps with after movement
        while (actor.getY()>=actor.getWorld().getHeight()-height || platform!=null) { //Runs if there is overlap with a platform or the ground
            actor.setLocation(actor.getX(), actor.getY()-1); //Actor is moved up one cell
            platform = actor.betterGetOneObjectAtOffset(0, (int)height, Platform.class); //Searches for more overlapping platforms and starts again
        }
    }
    public void move2(BetterActor actor) {
        double x = actor.getX() + xComp;
        double y = actor.getY() + yComp;
        double z = actor.getRotation() + zComp;
        actor.setLocation((int)x, (int)y); //The new position after movement is set
        actor.setRotation((int)z);
        lookForGround(actor);
        lookForWall2(actor);
        lookForCeiling2(actor);
    }
    public void gravity(BetterActor actor) { //Applies gravity to actors
        double height = actor.getImage().getHeight()/2;
        Actor platform = actor.betterGetOneObjectAtOffset(0, (int)height, Platform.class);
        if (actor.getY()>=actor.getWorld().getHeight()-height || platform!=null) { //If the actor collides with a platform or the ground, it stops falling
            setYComp(0);
        } else {
            addVectorInDirection(270, -1); //Otherwise velocity increases under the influence of gravity
        }
    }
    public void lookForGround(BetterActor actor) {
        while (isTouchingGround2(actor)) {
            actor.setLocation(actor.getX(), actor.getY()-1); 
        }
    }
    public void lookForWall(BetterActor actor) { //Looks for walls the object might be colliding with and prevents it from moving through them
        double widthRight = actor.getImage().getWidth()/2 - actor.rightExcess - 1; //Actual width of the object taking into account whitespace in its image
        double widthLeft = actor.getImage().getWidth()/2 - actor.leftExcess - 1; //Actual width on the object's left side
        double heightBot = actor.getImage().getHeight()/2 - actor.botExcess - 1;
        double heightTop = actor.getImage().getHeight()/2 - actor.topExcess - 1;
        Actor platformBotRight = actor.betterGetOneObjectAtOffset((int)widthRight, 0, Platform.class);
        Actor platformBotLeft = actor.betterGetOneObjectAtOffset(-(int)widthLeft, 0, Platform.class);
        while (platformBotRight!=null) { //While there's a platform to its right, the object keeps being pushed left
            actor.setLocation(actor.getX()-1, actor.getY());
            platformBotRight = actor.betterGetOneObjectAtOffset((int)widthRight, (int)heightBot, Platform.class);
        }
        while (platformBotLeft!=null) { //While there's a platform to its left, the object keeps being pushed right
            actor.setLocation(actor.getX()+1, actor.getY());
            platformBotLeft = actor.betterGetOneObjectAtOffset(-(int)widthLeft, (int)heightBot, Platform.class);
        }
    }
    public void lookForWall2(BetterActor actor) {
        while (isTouchingLeftWall(actor)) {
            actor.setLocation(actor.getX()+1, actor.getY());
        }
        while (isTouchingRightWall(actor)) {
            actor.setLocation(actor.getX()-1, actor.getY());
        }
    }
    public void lookForCeiling(BetterActor actor) { //Looks for ceilings
        double height = actor.getImage().getHeight()/2 - actor.topExcess - 1;
        Actor platform = actor.betterGetOneObjectAtOffset(0, -(int)height, Platform.class);
        while (actor.getY()<=height || platform!=null) { //While there's a platform or the top of the world above it, the object moves downwards
            actor.setLocation(actor.getX(), actor.getY()+1); //Actor is moved down one cell
            platform = actor.betterGetOneObjectAtOffset(0, -(int)height, Platform.class);
            setYComp(0); //Object also loses upward momentum as a result of these collisions
        }
    }
    public void lookForCeiling2(BetterActor actor) {
        while (isTouchingCeiling2(actor)) {
            actor.setLocation(actor.getX(), actor.getY()+1);
            setYComp(0);
        }
    }
    public boolean isTouchingCeiling(BetterActor actor) {
        boolean result = true;
        double height = actor.getImage().getHeight()/2 - actor.topExcess - 1;
        Actor platform = actor.betterGetOneObjectAtOffset(0, -(int)height, Platform.class);
        if (actor.getY()<=height || platform!=null)
            result = false;
        return result;
    }
    public boolean isTouchingCeiling2(BetterActor actor) {
        boolean result = false;
        double height = (actor.getImage().getHeight()-actor.botExcess-actor.topExcess)/4 - 1; //This represents a quarter of the image's actual height
        ArrayList ceilingPoints = new ArrayList(); //This is the array in which all points involved with detection of ceilings will be kept
        for (int i=0; i<actor.detectPoints.size(); i++) { //The loop checks through all the points defined in the object's detectPoints ArrayList
            if (actor.detectPoints.get(i).getY()<=(-height)) { //If a point is more than 3/4 of the way up the image, it will be used to detect ceilings
                ceilingPoints.add(actor.betterGetOneObjectAtOffset(actor.detectPoints.get(i).getX(), actor.detectPoints.get(i).getY(), Platform.class));
            }
        }
        for (int i=0; i<ceilingPoints.size(); i++) { //Another loop then checks all of the points singled out for ceiling detection
            if (ceilingPoints.get(i)!=null) { //If there is a platform at any of those points, the methods returns true
                result = true;
            }
        }
        if (actor.getY()<=(actor.getImage().getHeight()/2-actor.topExcess-1))
            result = true;
        return result;
    }
    public boolean isTouchingWall(BetterActor actor) {
        boolean result = true;
        double widthRight = actor.getImage().getWidth()/2 - actor.rightExcess - 1;
        double widthLeft = actor.getImage().getWidth()/2 - actor.leftExcess - 1;
        double heightBot = actor.getImage().getHeight()/4 - actor.botExcess - 1;
        double heightTop = actor.getImage().getHeight()/2 - actor.topExcess - 1;
        Actor platformTopRight = actor.betterGetOneObjectAtOffset((int)widthRight, -(int)heightTop, Platform.class);
        Actor platformTopLeft = actor.betterGetOneObjectAtOffset(-(int)widthLeft, -(int)heightTop, Platform.class);
        Actor platformBotRight = actor.betterGetOneObjectAtOffset((int)widthRight, (int)heightBot, Platform.class);
        Actor platformBotLeft = actor.betterGetOneObjectAtOffset(-(int)widthLeft, (int)heightBot, Platform.class);
        if (platformBotRight==null && platformBotLeft==null && platformTopRight==null && platformTopLeft==null && !actor.isAtEdge())
            result = false;
        return result;
    }
    public boolean isTouchingWall2(BetterActor actor) {
        boolean result = false;
        double height = (actor.getImage().getHeight()-actor.botExcess-actor.topExcess)/4 - 1;
        ArrayList wallPoints = new ArrayList();
        for (int i=0; i<actor.detectPoints.size(); i++) {   //Implementation is similar to isTouchingCeiling2(), but looks for
            if (actor.detectPoints.get(i).getY()<=height) { //points more than 1/4 of the way up the image
                wallPoints.add(actor.betterGetOneObjectAtOffset(actor.detectPoints.get(i).getX(), actor.detectPoints.get(i).getY(), Platform.class));
            }
        }
        for (int i=0; i<wallPoints.size(); i++) {
            if (wallPoints.get(i)!=null) {
                result = true;
            }
        }
        return result;
    }
    public boolean isTouchingRightWall(BetterActor actor) {
        boolean result = false;
        double height = (actor.getImage().getHeight()-actor.botExcess-actor.topExcess)/4 - 1;
        double width = actor.getImage().getHeight()/2 - actor.rightExcess - 1;
        ArrayList rightWallPoints = new ArrayList();
        for (int i=0; i<actor.detectPoints.size(); i++) {
            if (actor.detectPoints.get(i).getX()>=0 && actor.detectPoints.get(i).getY()<=height && actor.detectPoints.get(i).getY()>=-height) {
                rightWallPoints.add(actor.betterGetOneObjectAtOffset(actor.detectPoints.get(i).getX(), actor.detectPoints.get(i).getY(), Platform.class));
            }
        }
        for (int i=0; i<rightWallPoints.size(); i++) {
            if (rightWallPoints.get(i)!=null) {
                result = true;
            }
        }
        if (actor.getX()+width>=actor.getWorld().getWidth())
            result = true;
        return result;
    }
    public boolean isTouchingLeftWall(BetterActor actor) {
        boolean result = false;
        double height = (actor.getImage().getHeight()-actor.botExcess-actor.topExcess)/4 - 1;
        double width = actor.getImage().getHeight()/2 - actor.leftExcess - 1;
        ArrayList leftWallPoints = new ArrayList();
        for (int i=0; i<actor.detectPoints.size(); i++) {
            if (actor.detectPoints.get(i).getX()<=0 && actor.detectPoints.get(i).getY()<=height && actor.detectPoints.get(i).getY()>=-height) {
                leftWallPoints.add(actor.betterGetOneObjectAtOffset(actor.detectPoints.get(i).getX(), actor.detectPoints.get(i).getY(), Platform.class));
            }
        }
        for (int i=0; i<leftWallPoints.size(); i++) {
            if (leftWallPoints.get(i)!=null) {
                result = true;
            }
        }
        if (actor.getX()<=width)
            result = true;
        return result;
    }
    public boolean isTouchingGround(BetterActor actor) {
        boolean result = false;
        double height = actor.getImage().getHeight()/2 - actor.botExcess - 1;
        Actor platform = actor.betterGetOneObjectAtOffset(0, (int)height, Platform.class);
        if (actor.getY()>=actor.getWorld().getHeight()-height || platform!=null)
            result = true;
        return result;
    }
    public boolean isTouchingGround2(BetterActor actor) {
        boolean result = false;
        double height = (actor.getImage().getHeight()-actor.botExcess-actor.topExcess)/4 - 1;
        ArrayList groundPoints = new ArrayList();
        for (int i=0; i<actor.detectPoints.size(); i++) {   //Implementation is similar to isTouchingCeiling2(), but looks for
            if (actor.detectPoints.get(i).getY()>height) {  //points less than 1/4 of the way up the image
                groundPoints.add(actor.betterGetOneObjectAtOffset(actor.detectPoints.get(i).getX(), actor.detectPoints.get(i).getY(), Platform.class));
            }
        }
        for (int i=0; i<groundPoints.size(); i++) {
            if (groundPoints.get(i)!=null) {
                result = true;
            }
        }
        if (actor.getY()>=actor.getWorld().getHeight()-(actor.getImage().getHeight()/2 - actor.botExcess - 1))
            result = true;
        return result;
    }
    public boolean canSee(Class clss, BetterActor actor) {
        return actor.betterGetOneObjectAtOffset(0, 0, clss) != null;
    }
}
