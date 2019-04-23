package ie.tudublin;

import ddf.minim.AudioInput;
import ddf.minim.Minim;

public class AudioPad
{
    private float x;
    private float y;
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

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * @return the minim
     */
    public Minim getMinim() {
        return minim;
    }

    /**
     * @param minim the minim to set
     */
    public void setMinim(Minim minim) {
        this.minim = minim;
    }

    /**
     * @return the ai
     */
    public AudioInput getAi() {
        return ai;
    }

    /**
     * @param ai the ai to set
     */
    public void setAi(AudioInput ai) {
        this.ai = ai;
    }

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }
}