package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;

public class UI extends PApplet
{
    public ArrayList<Meter> meters = new ArrayList<Meter>(); 
    public Stars[] stars = new Stars[800];
    SteeringWheel sw;
    AlienPad ap;

    public float speed;

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
        ap = new AlienPad(this, 500 , 500, 100, 100);
        for (int i = 0; i < stars.length; i++) 
        {
            stars[i] = new Stars(this);
        }
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

        pushMatrix();
        speed = map(50, 0, width, 0, 50); 
        translate(width/2, height/2);
        for (int i = 0; i < stars.length; i++) 
        {

            
            stars[i].update();
            stars[i].show();
        }
        popMatrix();

        ap.render();
        ap.update();  
        sw.render();
        sw.update();
    }
}

