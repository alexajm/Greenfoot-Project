/**
 * Write a description of class Coordinate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coordinate  
{
    private int x;
    private int y;
    
    public Coordinate() {
        x = 0;
        y = 0;
    }
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
