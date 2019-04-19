package ie.tudublin;


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

        //Standens
        ui.strokeWeight(8);
        ui.line((1 * width) / 10 + 8, 0, ((4 * width) / 10) + 4, (height / 2));
        ui.line((9 * width) / 10 - 8, 0, ((6 * width) / 10) - 4, (height / 2));
        ui.line(0, (ui.height/2)+20, ui.width, (ui.height/2)+20);

        //Guns
        ui.strokeWeight(30);
        ui.line(0, 0, 100, 100);
        ui.line(ui.width, 0, ui.width - 100, 100);

        ui.stroke(255, 255, 0);
        ui.line(94, 94, 100, 100);
        ui.line(ui.width - 97, 97, ui.width - 100, 100);


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