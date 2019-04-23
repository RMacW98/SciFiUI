package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;
import ddf.minim.AudioInput;
import ddf.minim.*;

public class UI extends PApplet
{
    public ArrayList<Meter> meters = new ArrayList<Meter>(); 
    public Stars[] stars = new Stars[800];
    public ArrayList<Planet> planets = new ArrayList<Planet>();

    SteeringWheel sw;
    AlienPad ap;
    Static s;
    CockPit cp;
    AudioPad audio;
    TargetSystem ts;
    Lever l;

    public int score = 0;
    public float speed;
    public int SAMPLE_RATE = 44100;
    public int RESOLUTION = 16;
    public int FRAME_SIZE = (int) 150;
    
    public float meterDiameter = (float) 0.625 * width;
    public float wheelDiameter = (float) 1.2 * width;

    Minim minim;
    AudioInput ai;
    AudioPlayer background;

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
        fullScreen();
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, FRAME_SIZE, SAMPLE_RATE, RESOLUTION);
        background = minim.loadFile("SpaceMusic.mp3");
    }

    public void setup()
    {
        meters.add(new SpeedMeter(this, (9 * width) / 20, (6 * height) / 10, meterDiameter));
        meters.add(new RevMeter(this, (11 * width) / 20, (6 * height) / 10, meterDiameter));

        sw = new SteeringWheel(this, width / 2, (2 * height) / 3, wheelDiameter);
        ap = new AlienPad(this, (12 * width) / 20 , (15 * height) / 20, FRAME_SIZE, FRAME_SIZE);
        s = new Static(this, (12 * width) / 20 , (15 * height) / 20, FRAME_SIZE, FRAME_SIZE);
        audio = new AudioPad(this, (6 * width) / 20 , (15 * height) / 20, FRAME_SIZE, SAMPLE_RATE, RESOLUTION, FRAME_SIZE);
        cp = new CockPit(this, width, height);
        ts = new TargetSystem(this, meterDiameter, 10);
        l = new Lever(this, (12 * width) / 20 , (13 * height) / 20, 20);

        for (int i = 0; i < stars.length; i++) 
        {
            stars[i] = new Stars(this);
        }

        for (int i = 0; i < 10; i++) 
        {
            planets.add(new GreenPlanet(this));
            planets.add(new BluePlanet(this));
            planets.add(new RedPlanet(this));
        }
    }

    public void mousePressed()
    {
        float mx = mouseX - (width / 2);
        float my = mouseY - (height / 2);

        if(checkKey(' '))
        {
            fill(155, 0, 0);
            textSize(30);
            textAlign(CENTER);
            text("Cannot Fire!", width / 2, height / 2);
        } else {
            if(mouseY < height / 2)
            {
                strokeWeight(8);
                stroke(255, 0, 0);
                line(mouseX, mouseY, 100, 100);
                line(mouseX, mouseY, width - 100, 100);

                stroke(255, 255, 0);
                line(mouseX, mouseY + 8, 100, 108);
                line(mouseX, mouseY - 8, 100, 92);

                line(mouseX, mouseY + 8, width - 100, 108);
                line(mouseX, mouseY - 8, width - 100, 92);
                noStroke();

                pushMatrix();
                translate(width/2, height/2);
                for(int i = 0 ; i < planets.size() ; i ++)
                {
                    Planet p = planets.get(i);
                    
                    if(dist(p.sx, p.sy, mx, my) <=  p.r)
                    {
                        planets.remove(i);
                        score = score + 1;
                    }
                    
                } 
                popMatrix();
            }
        }
        
    }

    public void draw()
    {
        background(0);

        //Play Music
        if(background.position() == background.length())
        {
            background.rewind();
            background.play();
        }
        else
        {
            background.play();
        }
   
        //Render the stars first
        pushMatrix();
        speed = map(50, 0, width, 0, 50); 
        translate(width/2, height/2);
        for (int i = 0; i < stars.length; i++) 
        {   
            stars[i].update();
            stars[i].show();
        }

        for (Planet p : planets)
        {
            p.update();
            p.colour();
            p.show();
        }  
        popMatrix();
        

        if (mouseY < (height / 2) + 10)
        {
            ts.render();
            ts.update();
        }
        
        //Render Cockpit
        cp.render();

        //Render all devices for Ship
        for(int i= meters.size() - 1; i >= 0; i--)
        {
            Meter m = meters.get(i);
            m.render();
            m.update();
        }  

        if (checkKey(' '))
        {
            s.render();
            s.update();
        } else {
            ap.render();
            ap.update();
        }

        audio.render();
        audio.update();    

        sw.render();
        sw.update();

        l.render();
        l.update();

        textSize(20);
        stroke(255);
        //textFont(Verdana);
        text("Score: " + score, width / 2, height - 20);
        

        if (planets.size() < 27)
        {
            planets.add(new GreenPlanet(this));
            planets.add(new BluePlanet(this));
            planets.add(new RedPlanet(this));

        }
    }
}

