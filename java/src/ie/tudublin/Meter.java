package ie.tudublin;

import processing.core.PVector; 

public abstract class Meter
{
    UI ui;
    public float x;
    public float y;
    public float diameter;
    public PVector pos;
    public PVector forward;
    public float rotation;

    public Meter(UI ui, float x, float y, float diameter)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        pos = new PVector(x, y);
        forward = new PVector(0, -1);
        this.diameter = diameter;
    }

    public void render()
    {
        float radius = diameter / 2;
        
        ui.pushMatrix();
        ui.translate(pos.x, pos.y);
        ui.fill(0);
        ui.stroke(255);
        ui.ellipse(0, 0, diameter, diameter);
        ui.rotate(rotation);

        ui.noFill();

        ui.line(0, 0, -radius, 0);
        ui.popMatrix();
    }

    public void update()
    {
        
    }
}