package ie.tudublin;


public class AlienPad
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private float tx;
    private float ty;

    public AlienPad(UI ui, float x, float y, float width, float height)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render()
    {
        ui.fill(0);
        ui.stroke(255);
        ui.noStroke();
        ui.rect(x, y, width, height);
    }

    public void update()
    {
        float mx = ui.mouseX;
        float my = ui.mouseY;

        tx = ui.map(mx, 0, ui.width, x + 5, x + width - 5);
        ty = ui.map(my, 0, ui.height/2, y + 5, y + height - 5);

        
        if(ui.mouseY < height*2.4)
        {
            ui.noFill();
            ui.stroke(255, 0, 0);
            ui.circle(tx, ty, 10);
            ui.circle(tx, ty, 20);
            ui.line(tx + 5, ty, tx - 5, ty);
            ui.line(tx, ty + 5, tx, ty - 5);
            ui.noStroke();
        }
        

    }
}