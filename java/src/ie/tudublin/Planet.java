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
     * @return the sx
     */
    public float getSx() {
        return sx;
    }

    /**
     * @param sx the sx to set
     */
    public void setSx(float sx) {
        this.sx = sx;
    }

    /**
     * @return the sy
     */
    public float getSy() {
        return sy;
    }

    /**
     * @param sy the sy to set
     */
    public void setSy(float sy) {
        this.sy = sy;
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
     * @return the r
     */
    public float getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(float r) {
        this.r = r;
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