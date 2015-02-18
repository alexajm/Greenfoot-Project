import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends World
{
    /**
     * Constructor for objects of class TestWorld.
     * 
     */
    public TestWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        addObject(new Scorekeeper(), 25, 50);
        addObject(new Platform(), 281, 518);
        addObject(new Platform(), 465, 474);
        addObject(new Platform(), 658, 426);
        addObject(new Exit(), 872, 373);
        addObject(new Diamond(), 287, 450);
        addObject(new Diamond(), 470, 405);
        addObject(new Diamond(), 663, 359);
        addObject(new TestMan(), 57, 574);
    }
}
