package ie.tudublin;


public class Static
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private float tx;
    private float ty;

    public Static(UI ui, float x, float y, float width, float height)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render()
    {
        ui.pushMatrix();
        ui.translate(x, y);
        ui.fill(0);
        ui.stroke(255);
        ui.noStroke();
        ui.rect(x, y, width, height);
        ui.popMatrix();
    }

    public void update()
    {
        tx = ui.map(ui.mouseX, 0, ui.width, x, width);
        ty = ui.map(ui.mouseY, y, height, 0, ui.height);

        ui.noFill();
        ui.stroke(255);
        ui.circle(tx, ty, 10);
        ui.circle(tx, ty, 20);
        ui.line(tx + 5, 0, tx - 5, 0);
        ui.line(0, ty + 5, 0, ty - 5);
        ui.noStroke();

    }
}