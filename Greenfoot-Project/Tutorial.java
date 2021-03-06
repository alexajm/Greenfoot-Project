import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends BetterActor
{
    int text = 0;
    
    /**
     * Act - do whatever the Tutorial wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        runTutorial();
    }  
    public Tutorial() {
    }
    public void runTutorial() { //Runs a tutorial to teach the player how to play
        boolean complete = false;
        switch (text) {
            case 0:
                getWorld().showText("Use WASD to move", getWorld().getWidth()/2, getWorld().getHeight()/2);
                if (Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("S") || Greenfoot.isKeyDown("D"))
                    complete = true;
                break;
            case 1:
                getWorld().showText("Pick up bullets\nUse left and right arrow keys to fire them at enemies", getWorld().getWidth()/2, getWorld().getHeight()/2);
                if (Greenfoot.isKeyDown("Left") || Greenfoot.isKeyDown("Right"))
                    complete = true;
                break;
            case 2:
                getWorld().showText("Collect at least 3 diamonds on each level", getWorld().getWidth()/2, getWorld().getHeight()/2);
                if (Scorekeeper.getScore()>=3)
                    complete = true;
                break;
            case 3:
                getWorld().showText("Stand on the red bricks to proceed to the next level\nDon't touch blue water tiles", getWorld().getWidth()/2, getWorld().getHeight()/2);
                break;
        }
        if (complete)
            text++;
    }
    public int getText() { //Returns which part of the tutorial the player is on
        return text;
    }
}
