package ie.tudublin;

public class GreenPlanet extends Planet
{
    public GreenPlanet(UI ui)
    {
        super(ui);
    }
    
    public void colour()
    {
        ui.fill(0, 155, 0);
    }
}