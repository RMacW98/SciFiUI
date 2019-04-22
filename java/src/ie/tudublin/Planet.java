package ie.tudublin;

public abstract class Planet
{
    public float x;
    public float y;
    public float sx;
    public float sy;
    public float z;
    public float r;
    public float speed;
    UI ui;

    public Planet(UI ui)
    {
        this.ui = ui;
        x = ui.random( ui.width/2, ui.width/2);
        y = ui.random( ui.height/2, ui.height/2);
        z = ui.random(ui.width/2);
    }
 

    public void update() 
    {
        // ui.pushMatrix();
        // ui.translate(ui.width/2, ui.height/2);
        z = z - (float) (ui.speed * .5);

        if (z < 1) {
            z = ui.width/2;
            x = ui.random(-ui.width/2, ui.width/2);
            y = ui.random(-ui.height/2, ui.height/2);
        }

    }

    public void colour()
    {
        
    }

    public void show() 
    {
        // ui.pushMatrix();
        // ui.translate(ui.width/2, ui.height/2);
        ui.noStroke();

        sx = ui.map(x / z, 0, 1, 0, ui.width/2);
        sy = ui.map(y / z, 0, 1, 0, ui.height / 2); 

        r = ui.map(z, 0, ui.width/2, 100, 0);
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
            ui.speed = ui.speed * 1.001f;
        } 
        // ui.popMatrix();
    }
}