import greenfoot.*;
import java.awt.*;

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends BetterActor
{
    private String text; //The text this object represents
    private int x; //The text's x-coordinate
    private int y; //The text's y-coordinate
    GreenfootImage textImage = new greenfoot.GreenfootImage(100, 20);
    
    public Text() {
        text = "";
        x = 0;
        y = 0;
        textImage.drawString(text, x, y);
    }
    public Text(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
        textImage.drawString(text, 100, 20);
        this.setImage(textImage);
        //getWorld().addObject(this, x, y);
    }
    public String getText() { //Returns the text
        return text;
    }
    public void setText(String text) { //Changes the text
        this.text = text;
    }
}
