package ie.tudublin;

public class TargetSystem
{
    UI ui;
    public float diameter;
    public float crossHair;

    public TargetSystem(UI ui, float diameter, float crossHair)
    {
        this.ui = ui;
        this.diameter = diameter;
        this.crossHair = crossHair;
    }

    public void render()
    {
        ui.strokeWeight(2);
        ui.stroke(255, 0, 0);
        ui.noFill();
        ui.circle(ui.mouseX, ui.mouseY, diameter);
        ui.circle(ui.mouseX, ui.mouseY, diameter + 60);

        ui.line(ui.mouseX, ui.mouseY, ui.mouseX + crossHair, ui.mouseY);
        ui.line(ui.mouseX, ui.mouseY, ui.mouseX - crossHair, ui.mouseY);
        ui.line(ui.mouseX, ui.mouseY, ui.mouseX, ui.mouseY + crossHair);
        ui.line(ui.mouseX, ui.mouseY, ui.mouseX, ui.mouseY - crossHair);

    }

    public void update()
    {
    }
}
