package ie.tudublin;

import processing.core.PApplet;

public class CockPit
{
    UI ui;
    public float width;
    public float height;

    public CockPit(UI ui, float width, float height)
    {
        this.ui = ui;
        this.width = width;
        this.height = height;
    }

    public void render()
    {
        ui.pushMatrix();
        ui.stroke(0, 0, 155);

        // //Sides of cockpit
        // ui.line((1 * width) / 10, height, (4 * width) / 10, (height / 2) + 40);
        // ui.line((9 * width) / 10, height, (6 * width) / 10, (height / 2) + 40);

        // //Centre of cockpit
        // ui.line((4 * width) / 10, (height / 2), (4 * width) / 10, (height / 2) + 40);
        // ui.line((6 * width) / 10, (height / 2), (6 * width) / 10, (height / 2) + 40);

        //Standens
        ui.strokeWeight(8);
        ui.line((1 * width) / 10 + 8, 0, ((4 * width) / 10) + 4, (height / 2));
        ui.line((9 * width) / 10 - 8, 0, ((6 * width) / 10) - 4, (height / 2));

        //Centre of cockpit
        // ui.strokeWeight(1);
        // ui.line(((4 * width) / 10) + 8, (height / 2), (width / 2) - 20, (height / 2) + 10);
        // ui.line(((6 * width) / 10) - 8, (height / 2), (width / 2) + 20, (height / 2) + 10);
        
        ui.strokeWeight(1);
        ui.line((width / 2) - 20, (height / 2) + 10, (width / 2) + 20, (height / 2) + 10);

        ui.fill(0, 0, 155);
        ui.noStroke();
        ui.rect(((4 * width) / 10), (height / 2) + 10, (2 * width) / 10, height / 2);
        
        ui.triangle((1 * width) / 10, height, (9 * width) / 10, height, ((4 * width) / 10) + 8, (height / 2) + 10);
        ui.triangle((9 * width) / 10, height, (1 * width) / 10, height, ((6 * width) / 10) - 8, (height / 2) + 10);

        ui.triangle(((4 * width) / 10), (height / 2), (width / 2) - 20, (height / 2) + 10, ((4 * width) / 10), (height / 2) + 10);
        ui.triangle(((6 * width) / 10), (height / 2), (width / 2) + 20, (height / 2) + 10, ((6 * width) / 10), (height / 2) + 10);

        ui.popMatrix();
    }
}