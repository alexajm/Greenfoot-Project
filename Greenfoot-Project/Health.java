import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Player
{
    private GreenfootImage transparent = new GreenfootImage("transparent.png");
    private GreenfootImage HealthFull = new GreenfootImage("HealthFull.png");
    private GreenfootImage Health2_5 = new GreenfootImage("Health2.5.png");
    private GreenfootImage Health2 = new GreenfootImage("Health2.png");
    private GreenfootImage Health1_5 = new GreenfootImage("Health1.5.png");
    private GreenfootImage Health1 = new GreenfootImage("Health1.png");
    private GreenfootImage Health0_5 = new GreenfootImage("Health0.5.png");
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
    public void displayHealth(){
        //System.out.println(health);
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
            Greenfoot.playSound("TriageAtDawn.mp3");
            try {
                Thread.sleep(8250);
            } catch (InterruptedException e) {}
            System.exit(0);
        }
    }
    
    public static double getHealth(){
        return health;
    }
    public static void setHealth(double hlth) {
        health = hlth;
    }
}