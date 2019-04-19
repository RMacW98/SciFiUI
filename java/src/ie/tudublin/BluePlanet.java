package ie.tudublin;

public class BluePlanet extends Planet
{
    public BluePlanet(UI ui)
    {
        super(ui);
    }
    
    public void colour()
    {
        ui.fill(0, 0, 155);
    }
}