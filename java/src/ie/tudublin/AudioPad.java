package ie.tudublin;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class AudioPad extends PApplet
{
    public static int SAMPLE_RATE = 44100;
    public static int RESOLUTION = 16;
    public static int FRAME_SIZE = 1024;
    private float x;
    private float y;
    private float width;
    private float height;

    Minim minim;
    AudioInput ai;
    UI ui;
    

    public AudioPad(UI ui, float x, float y, float width, float height)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void render()
    {
        ui.rect(x, y, FRAME_SIZE, height);
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, FRAME_SIZE, SAMPLE_RATE, RESOLUTION);

    }

    public void update()
    {
        ui.background(0);
        ui.stroke(0, 190, 0);
        float halfH = height / 2;
        for(int i = 0 ; i < ai.bufferSize() ; i ++)
        {
            ui.line(i, halfH, i, halfH + ai.left.get(i) * halfH * 30);
        }
    }
}