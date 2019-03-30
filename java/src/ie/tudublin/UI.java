package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;

public class UI extends PApplet
{
    public ArrayList<Meter> meters = new ArrayList<Meter>(); 
    SteeringWheel sw;
    AlienPad ap;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        meters.add(new SpeedMeter(this, (3 * width) / 8, (3 * height) / 7, 100));
        meters.add(new RevMeter(this, (5 * width) / 8, (3 * height) / 7, 100));
        sw = new SteeringWheel(this, width / 2, (2 * height) / 3, 175);
        ap = new AlienPad(this, (4 * width) / 5 , (4 * height) / 5, 100, 100);
    }

    public void draw()
    {
        background(0);       
        for(int i= meters.size() - 1; i >= 0; i--)
        {
            Meter m = meters.get(i);
            m.render();
            m.update();
        }  
        sw.render();
        sw.update();
        ap.render();
        ap.update();

    }
}

