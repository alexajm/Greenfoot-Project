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


    
    GreenfootSound theme = new GreenfootSound("theme.mp3");
    int height = 24;
    int width = 72;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld() {    
        super(1000, 600, 1); 
        changeLevel();
    }
    public void act() {
        theme.playLoop();
        if (Health.getHealth()==0)
        {
            theme.setVolume(0);
        }
    }
    public void changeLevel() { //Manages game's levels and changes between them
        List objects = getObjects(null);
        removeObjects(objects); //Removes all objects from the world before instantiating the next level's objects
        switch (level) { //Determines which level to build for the player
            case 0:
                tutorial();
                break;
            case 1:
                level1();
                break;
            case 2:
                level2();
                break;
            case 3:
                level3();
                break;
            default:
                end();
                break;
        }
    }
    public void tutorial() { //Object placement for Level 1
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
        addObject(new Player(), 57, 574);
        Exit.setText("Tutorial Complete");
    }
    public void level1() { //Object placement for Level 1
        int pheight1 = 250;
        addObject(new Player(), 91, 531);
        addObject(new Platform(), 100, 575);
        addObject(new Platform(), 150, 550);
        addObject(new Platform(), 200, 525);
        addObject(new Platform(), 350, 450);
        addObject(new Platform(), 530, 450);
        addObject(new Platform(), 700, 500);
        addObject(new Platform(), 772, 500);
        addObject(new Platform(), 844, 500);
        addObject(new Platform(), 914, 500);
        addObject(new Platform(), 780, 400);
        addObject(new Water(), 250, 588);
        addObject(new Water(), 250+width, 588);
        addObject(new Water(), 250+(width*2), 588);
        addObject(new Water(), 250+ (width*3), 588);
        addObject(new Water(), 250+(width*4), 588);
        addObject(new Water(), 250+(width*5), 588);
        addObject(new Water(), 250+(width*6), 588);
        addObject(new Platform(), 650, 300);
        addObject(new Platform(), 620-width, pheight1);
        addObject(new Platform(), 620-width*2, pheight1);
        addObject(new Platform(), 620-width*3, pheight1);
        addObject(new Water(), 620-width*4, pheight1);
        addObject(new Platform(), 620-width*5, pheight1-height);
        addObject(new Platform(), 620-width*5, pheight1-height*2);
        addObject(new Platform(), 150, 150);
        addObject(new Platform(), 36, 300);
        addObject(new Platform(), 420, 120);
        addObject(new Platform(), 420+width, 120);
        addObject(new Platform(), 420+width*2, 120);
        addObject(new Platform(), 420+width*3, 120);
        addObject(new Platform(),420+width*4, 120);
        addObject(new Exit(), 875, 250);
        addObject(new Diamond(), 900, 460);
        addObject(new Diamond(), 36, 260);
        addObject(new Diamond(), 532, 410);
        addObject(new Scorekeeper(), 25, 50);
        addObject(new Health(), 900, 50);
        Exit.setText("Level 1 Complete");
    }
    public void level2() {
        for (int i=0; i<=5; i++) {
            addObject(new Platform(), 36+72*i, 500);
            addObject(new Platform(), 36+72*i, 330);
            addObject(new Water(), 36+72*i, 320);
        }
        for (int i=0; i<=1; i++) {
            addObject(new Water(), getWidth()-36-72*i, 490);
            addObject(new Platform(), getWidth()-36-72*2-72*i, 490);
        }
        for (int i=0; i<=5; i++) {
            addObject(new Platform(), getWidth()-36-72*i, 500);
        }
        addObject(new Platform(), 460, 588);
        addObject(new Platform(), 550, 510);
        addObject(new Platform(), 460, 432);
        addObject(new Platform(), 550, 344);
        addObject(new Platform(), 460, 256);
        addObject(new Exit(), 550, 168);
        for (int i=0; i<=13; i++) {
            addObject(new Platform(), 660, 400-24*i);
        }
        addObject(new Platform(), 930, 440);
        addObject(new Platform(), 830, 350);
        addObject(new Platform(), 730, 260);
        addObject(new Platform(), 830, 170);
        addObject(new Platform(), 930, 80);
        addObject(new Platform(), 730, 80);
        for (int i=0; i<=2; i++) {
            addObject(new Platform(), 36+144*i, 280);
        }
        for (int i=0; i<=4; i++) {
            addObject(new Platform(), 658-72*i, 80);
        }
        addObject(new Platform(), 260, 100);
        addObject(new Platform(), 150, 120);
        addObject(new Diamond(), 150, 70);
        addObject(new Diamond(), 38, 415);
        addObject(new Diamond(), 932, 30);
        addObject(new Enemy(), 38, 415);
        addObject(new Enemy(), 932, 30);
        addObject(new Enemy(), 259, 58);
        addObject(new Enemy(), 730, 222);
        addObject(new Scorekeeper(), 25, 50);
        addObject(new Player(), 57, 574);
        addObject(new Health(), 900, 50);
        Exit.setText("Level 2 Complete");
    }
    public void level3() { //Object placement for level 3
        addObject(new Scorekeeper(), 25, 50);
        addObject(new Health(), 900, 50);
        addObject(new Platform(), 36, 588);
        for (int i=1; i<5; i++) {
            addObject(new Platform(), 36+(i*width), 588-(i*height/2));
            addObject(new Platform(), 330+i*width, 100);
        }
        for (int i=1; i<22; i++) {
             addObject(new Platform(), 618, 100+i*height);
        }
        addObject(new Platform(), 450, 500);
        addObject(new Platform(), 400, 390);
        addObject(new Platform(), 350, 280);
        addObject(new Platform(), 250, 390);
        addObject(new Platform(), 175, 280);
        addObject(new Platform(), 100, 350);
        addObject(new Platform(), 285, 170);
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
    public void fadeWorld() { //Fades the world to white
        List objects = getObjects(null);
        Scorekeeper.setDiamonds(-1);
        Scorekeeper.setAmmo(-1);
        for (int i=255; i>=0; i--) { //Cycles through all of the levels of transparency
            for (int j=0; j<objects.size(); j++) { //Cycles through all the objects in the world
                ((Actor)objects.get(j)).getImage().setTransparency(i);
            }
            getBackground().setTransparency(i);
            Greenfoot.delay(2); //Makes the process more gradual
        }
    }
}
