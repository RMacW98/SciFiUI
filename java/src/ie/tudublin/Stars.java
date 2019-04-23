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
        //Z coordinate to decrease Z with increase in speed
        z = z - ui.speed;

        //When z is past the screen it replaces it back on the screen
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

        //Map the stars position from a range 0 - 1
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

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public float getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(float z) {
        this.z = z;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }
}