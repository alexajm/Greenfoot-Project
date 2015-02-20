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
    public void changeLevel() { //Manages game's levels and changes between them
        List objects = getObjects(null);
        removeObjects(objects); //Removes all objects from the world before instantiating the next level's objects
        switch (level) { //Determines which level to build for the player
            case 1:
                level1();
                break;
            default:
                end();
                break;
        }
    }
    public void level1() { //Object placement for Level 1
        addObject(new Tutorial(), 300, 300);
        addObject(new Scorekeeper(), 25, 50);
        addObject(new Health(), 900, 50);
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
    public void end() { //The game's end screen
        showText("You Won!", getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }
    public static void incrementLevel() { //Increases the level the player is on
        level++;
    }
    public static int getLevel() { //Returns the level the player is on
        return level;
    }
}
