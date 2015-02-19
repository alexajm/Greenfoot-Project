/**
 * Write a description of class Coordinate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coordinate  
{
    private int x; //X-coordinate
    private int y; //X-coordinate
    
    public Coordinate() {
        x = 0;
        y = 0;
    }
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() { //Returns the coordinates in (x, y) format
        return "(" + x + ", " + y + ")";
    }
    public int getX() { //Returns x-coordinate
        return x;
    }
    public int getY() { //Returns y-coordinate
        return y;
    }
}
