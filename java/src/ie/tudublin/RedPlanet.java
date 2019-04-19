package ie.tudublin;

public class RedPlanet extends Planet
{
    public RedPlanet(UI ui)
    {
        super(ui);
    }
    
    public void colour()
    {
        ui.fill(155, 0, 0);
    }
}