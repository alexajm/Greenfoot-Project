import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private static int level = 1;
    
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld() {    
        super(1000, 600, 1); 
        changeLevel();
    }
    public void changeLevel() {
        /*try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {}*/
        List objects = getObjects(null);
        removeObjects(objects);
        switch (level) {
            case 1:
                level1();
                break;
            default:
                end();
                break;
        }
    }
    public void level1() {
        addObject(new Scorekeeper(), 25, 50);
        addObject(new Platform(), 281, 518);
        addObject(new Platform(), 465, 474);
        addObject(new Platform(), 658, 426);
        addObject(new Exit(), 862, 373);
        addObject(new Diamond(), 287, 450);
        addObject(new Diamond(), 470, 405);
        addObject(new Diamond(), 663, 359);
        addObject(new TestMan(), 57, 574);
        Exit.setText("Level 1 Complete");
    }
    public void end() {
        showText("You Won!", getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }
    public static void incrementLevel() {
        level++;
    }
    public static int getLevel() {
        return level;
    }
}
