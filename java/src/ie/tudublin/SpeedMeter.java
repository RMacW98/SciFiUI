package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector; 

public class SpeedMeter extends Meter
{
    public SpeedMeter(UI ui, float x, float y, float diameter)
    {
        super(ui, x, y, 100);
    }
    public void update()
    {
        

        forward.x = (float) Math.sin(rotation);
        forward.y = - (float) Math.cos(rotation);

        if(rotation > 0)
        {
            rotation -= 0.05f;
        }

        if (rotation < 3.14)
        {
            if (ui.checkKey('w'))
            {
                rotation += 0.07f;  
            }
        }        
    }
}