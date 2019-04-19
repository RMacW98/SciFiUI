package ie.tudublin;

public class RevMeter extends Meter
{
    public RevMeter(UI ui, float x, float y, float diameter)
    {
        super(ui, x, y, diameter);
    }

    public void update()
    {

        forward.x = (float) Math.sin(rotation);
        forward.y = - (float) Math.cos(rotation);

        if(rotation > -0.5f) 
        {
            rotation -= 0.05f;
        }

        if (rotation < 2.5)
        {
            if (ui.checkKey(' '))
            {
                rotation += 0.13f;  
            } 
            if (rotation > 2.49f)
            {
                rotation = 0.45f;
            }
        }
    }
}