import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends BetterActor
{
    private GreenfootImage transparent = new GreenfootImage("transparent.png");
    private GreenfootImage HealthFull = new GreenfootImage("HealthFull.png");
    private GreenfootImage Health2_5 = new GreenfootImage("Health2.5.png");
    private GreenfootImage Health2 = new GreenfootImage("Health2.png");
    private GreenfootImage Health1_5 = new GreenfootImage("Health1.5.png");
    private GreenfootImage Health1 = new GreenfootImage("Health1.png");
    private GreenfootImage Health0_5 = new GreenfootImage("Health0.5.png");
    GreenfootSound death = new GreenfootSound("TriageAtDawn.mp3");
    private static double health = 3.0;
    
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        displayHealth();
    }    
    public Health(){
        setImage(HealthFull);
    }
    public void displayHealth(){ //Changes the image to reflect the player's health
        if (health==2.5)
        {
            setImage(Health2_5);
        }
        else if (health==2)
        {
            setImage(Health2);
        }
        else if (health==1.5)
        {
            setImage(Health1_5);
        }
        else if (health==1)
        {
            setImage(Health1);
        }
        else if (health==0.5)
        {
            setImage(Health0_5);
        }
        else if (health==0)
        {
            setImage(transparent);
            getWorld().showText("You Died", getWorld().getWidth()/2, getWorld().getHeight()/2);
            ((GameWorld) getWorld()).theme.setVolume(0);
            ((GameWorld) getWorld()).themeRandom.setVolume(0);
            death.play();
            ((GameWorld)getWorld()).fadeWorld(); //Sad death scene occurs
            death.stop();
            ((GameWorld) getWorld()).theme.setVolume(100);
            getWorld().getBackground().setTransparency(255);
            if (Scorekeeper.getAmmo()>0) //Player loses a bullet if they die
                Scorekeeper.decrementAmmo();
            ((GameWorld) getWorld()).changeLevel();
        }
    }
    public static double getHealth(){ //Returns the player's health
        return health;
    }
    public static void setHealth(double hlth) { //Sets the player's health
        health = hlth;
    }
}