package ie.tudublin;



public class Stars
{
    public float x;
    public float y;
    public float z;
    public float speed;
    UI ui;

    public Stars(UI ui)
    {
        this.ui = ui;
        x = ui.random( ui.width/2, ui.width/2);
        y = ui.random( ui.height/2, ui.height/2);
        z = ui.random(ui.width/2);
    }
 

    public void update() 
    {
        z = z - ui.speed;

        if (z < 1) {
            z = ui.width/2;
            x = ui.random(-ui.width/2, ui.width/2);
            y = ui.random(-ui.height/2, ui.height/2);
        }
    }

    public void show() 
    {
        ui.fill(255);
        ui.noStroke();

        float sx = ui.map(x / z, 0, 1, 0, ui.width/2);
        float sy = ui.map(y / z, 0, 1, 0, ui.height/2);

        float r = ui.map(z, 0, ui.width/2, 5, 0);
        ui.ellipse(sx, sy, r, r);
        
        if (ui.checkKey('a'))
        {
            x = x + 5;
        }

        if (ui.checkKey('d'))
        {
            x = x - 5;
        } 

        if (ui.checkKey('w'))
        {
            y = y + 5;
        }

        if (ui.checkKey('s'))
        {
            y = y - 5;
        } 

        if (ui.checkKey(' '))
        {
            ui.speed = ui.speed * 1.002f;
        } 
    }
}