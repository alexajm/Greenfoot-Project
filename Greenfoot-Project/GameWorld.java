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
    private static int level = 4;
    GreenfootSound theme = new GreenfootSound("theme.mp3"); //Game's main theme
    GreenfootSound themeRandom = new GreenfootSound("randomTheme.wav"); //A random theme
    private int randomNum = Greenfoot.getRandomNumber(4);
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
        if (randomNum==3) {
            themeRandom.playLoop();
        }
        else {
            theme.playLoop();
        }
        if (Health.getHealth()==0)
        {
            theme.setVolume(0);
        }
    }
    public void changeLevel() { //Manages game's levels and changes between them
        List objects = getObjects(null);
        removeObjects(objects); //Removes all objects from the world before instantiating the next level's objects
        showText("", getWidth()/2, getHeight()/2); //Removes any text in the center
        addObject(new Health(), 900, 50);
        Health.setHealth(3);
        addObject(new Scorekeeper(), 25, 50);
        Scorekeeper.setDiamonds(0);
        for (int i=0; i<=2; i++) //Randomly places three ammo drops
            addObject(new Ammo(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
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
    public void tutorial() { //Object placement for the tutorial
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
        addObject(new Exit(), 860, 250);
        addObject(new Diamond(), 900, 460);
        addObject(new Diamond(), 36, 260);
        addObject(new Diamond(), 532, 410);
        addObject(new Scorekeeper(), 25, 50);
        addObject(new Health(), 900, 50);
        addObject(new Enemy(), 500, pheight1-38);
        addObject(new Enemy(), 825, 460);
        addObject(new Enemy(), 575, pheight1-175);
        Exit.setText("Level 1 Complete");
    }
    public void level2() { //Object placements for Level 2
        for (int i=0; i<=5; i++) {
            addObject(new Water(), 36+72*i, 320);
            addObject(new Platform(), 36+72*i, 500);
            addObject(new Platform(), 36+72*i, 330);
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
        addObject(new Player(), 57, 574);
        Exit.setText("Level 2 Complete");
    }
    public void level3() { //Object placement for level 3
       
        addObject(new Player(), 36, 550);
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
        addObject(new Platform(), 750, 250);
        addObject(new Platform(), 825, 200);
        addObject(new Exit(), 900, 350);
        for (int i=1; i<35; i++) {
            addObject(new Water(), 150+i*height, 588);
        }
        addObject(new Diamond(), 400, 350);
        addObject(new Diamond(), 182, 240);
        addObject(new Diamond(), 625, 60);
        addObject(new Enemy(), 395, 350);
        addObject(new Enemy(), 600, 60);
        addObject(new Enemy(), 820, 160);
        Exit.setText("Level 3 Complete");
    }
    public void level4() {
        for (int i=0; i<=4; i++) {
            addObject(new Platform(), 36, 550-120*i);
        }
        for (int i=0; i<=3; i++) {
            addObject(new Platform(), 190, 500-120*i);
        }
        for (int i=0; i<=15; i++) {
            addObject(new Platform(), 262, getHeight()-12-24*i);
        }
        for (int i=0; i<=15; i++) {
            addObject(new Platform(), 262+72*i, 140);
        }
        addObject(new Platform(), 334, 500);
        addObject(new Platform(), 860, 500);
        addObject(new Platform(), 430, 230);
        addObject(new Platform(), 560, 290);
        addObject(new Exit(), 500, 80);
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
        showText("", 55, 27); //Clears text
        showText("", 55, 75);
        List objects = getObjects(null);
        for (int i=255; i>=0; i--) { //Cycles through all of the levels of transparency
            for (int j=0; j<objects.size(); j++) { //Cycles through all the objects in the world
                ((Actor)objects.get(j)).getImage().setTransparency(i);
            }
            getBackground().setTransparency(i);
            Greenfoot.delay(2); //Makes the process more gradual
        }
    }
}
