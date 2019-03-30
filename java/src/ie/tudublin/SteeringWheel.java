package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector; 

public class SteeringWheel
{
    UI ui;
    public float x;
    public float y;
    public float diameter;
    public PVector pos;
    public PVector forward;
    public float rotation;

    public SteeringWheel(UI ui, float x, float y, float diameter)
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
        ui.rotate(rotation);

        ui.stroke(255);
        ui.noFill();
        ui.ellipse(0, 0, diameter, diameter);
        ui.ellipse(0, 0, diameter - 5, diameter - 5);

        ui.line(radius, 0, -radius, 0);
        ui.line(0, radius, 0, 0);
        ui.popMatrix();
    }

    public void update()
    {
        

        forward.x = (float) Math.sin(rotation);
        forward.y = - (float) Math.cos(rotation);

        // If statement to check if wheel rotates more than twice
        if (rotation < 6.0f && rotation > -6.0f)
        {
            //Centre steering wheel
            if (rotation > 0.0f && !ui.checkKey('a'))
            {
                rotation -= 0.04f;
            }

            if (rotation < 0.0f && !ui.checkKey('d'))
            {
                rotation += 0.04f;
            }  

            //Turn wheel
            if (ui.checkKey('a'))
            {
                rotation -= 0.11f;  
            }   
            
            if (ui.checkKey('d'))
            {
                rotation += 0.11f;  
            } 
        }
        else if (rotation >= 6.0f)  //Stop glitches and freezing wheel
        {
            rotation = 5.99f;
        } else {
            rotation = -5.99f;
        }
    }
}