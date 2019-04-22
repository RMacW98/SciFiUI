package ie.tudublin;

import processing.core.PVector; 

public class Lever
{
    UI ui;
    public float x;
    public float y;
    public float diameter;
    private float original;

    public Lever(UI ui, float x, float y, float diameter)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        original = y;
    }

    public void render()
    {
        ui.stroke(155);
        ui.strokeWeight(5);
        ui.line(x, original + 15, x, original - 15);

        ui.noStroke();
        ui.fill(255);
        ui.strokeWeight(1);
        ui.ellipse(x, y, diameter, diameter);
    }

    public void update()
    {
        if(ui.checkKey('w') && y > original - 15)
        {
            y = y - 2;
        } else if (ui.checkKey('s') && y < original + 15)
        {
            y = y + 2;
        }

        if(y > original )
        {
            y--;
        } else if (y < original)
        {
            y++;
        }
    }
}