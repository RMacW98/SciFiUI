package ie.tudublin;

import ddf.minim.AudioInput;
import ddf.minim.Minim;

public class AudioPad
{
    private float x;
    private float y;
    private float width;
    private float height;
    public static int SAMPLE_RATE;
    public static int RESOLUTION;
    public static int FRAME_SIZE;

    Minim minim;
    AudioInput ai;
    UI ui;
    

    public AudioPad(UI ui, float x, float y, float height, int SAMPLE_RATE, int RESOLUTION, int FRAME_SIZE)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.height = height;
        this.SAMPLE_RATE = SAMPLE_RATE;
        this.RESOLUTION = RESOLUTION;
        this.FRAME_SIZE = FRAME_SIZE;

    }
    
    public void render()
    {
        ui.pushMatrix();
        ui.fill(0);
        ui.rect(x, y, FRAME_SIZE, height);
        ui.popMatrix();
    }

    public void update()
    {
        ui.stroke(0, 190, 0);
        float halfH = y + height / 2;
        for(int i = (int) x ; i < ui.ai.bufferSize() + (int) x; i ++)
        {
            ui.line(i, halfH, i, halfH + ui.ai.left.get(i - (int) x) * halfH * 4);
        }
    }
}