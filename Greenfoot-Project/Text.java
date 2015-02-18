import greenfoot.*;

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends BetterActor
{
    private String text;
    private int x;
    private int y;
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
        textImage.drawString(text, x, y);
        setImage(textImage);
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
