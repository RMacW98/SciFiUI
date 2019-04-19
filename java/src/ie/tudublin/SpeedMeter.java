package ie.tudublin;

public class SpeedMeter extends Meter
{
    public SpeedMeter(UI ui, float x, float y, float diameter)
    {
        super(ui, x, y, diameter);
    }
    public void update()
    {
        

        forward.x = (float) Math.sin(rotation);
        forward.y = - (float) Math.cos(rotation);

        if(rotation > 0)
        {
            rotation -= 0.05f;
        }

        if (rotation < 3.14f)
        {
            if (ui.checkKey(' '))
            {
                rotation += 0.07f;  
            }
        } else {
            rotation = 3.14f;
        }     
    }
}