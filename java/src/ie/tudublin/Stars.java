package ie.tudublin;

public class Stars
{
    public float x;
    public float y;
    public float z;
    public float pz;
    public float speed;
    UI ui;

    public Stars(UI ui)
    {
        this.ui = ui;
        x = ui.random( ui.width/2, ui.width/2);
        y = ui.random( ui.height/2, ui.height/2);
        z = ui.random(ui.width/2);
        pz = z;
    }
 

    public void update() 
    {
        z = z - ui.speed;

        if (z < 1) {
            z = ui.width/2;
            x = ui.random(-ui.width/2, ui.width/2);
            y = ui.random(-ui.height/2, ui.height/2);
            pz = z;
        }
    }

    public void show() 
    {
        ui.fill(255);
        ui.noStroke();

        float sx = ui.map(x / z, 0, 1, 0, ui.width/2);
        float sy = ui.map(y / z, 0, 1, 0, ui.height/2);

        float r = ui.map(z, 0, ui.width/2, 6, 0);
        ui.ellipse(sx, sy, r, r);

        float px = ui.map(x / pz, 0, 1, 0, ui.width/2);
        float py = ui.map(y / pz, 0, 1, 0, ui.height/2);

        pz = z;
        
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
            ui.speed = ui.speed * 1.001f;
        } 

        ui.stroke(255);
        ui.line(px, py, sx, sy);
    }
}