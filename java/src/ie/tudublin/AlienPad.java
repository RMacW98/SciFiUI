package ie.tudublin;

import java.util.Random;

import processing.core.PApplet;

public class AlienPad
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;

    public AlienPad(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.rect(x, y, width, height);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
    }

    public void update()
    {
        Random rand = new Random();

        int rand1 = rand.nextInt(255);
        int numRect = 10;
         

        for (int i = 0; i < numRect; i++)
        {
            for (int j = 0; j < numRect; j++)
            {
                noStroke();
                fill(rand1, 0, 0);
                rect(x, y, numRect, numRect);
                y = y + numRect;
            }

            x = x + numRect;
            y = 0;
        }
        
    }
}