package ie.tudublin;

public class Lever
{
    UI ui;
    public float x;
    public float y;
    public float diameter;
    private float original;

    public Lever(UI ui, float x, float y, float diameter)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        original = y;
    }

    public void render()
    {
        ui.stroke(155);
        ui.strokeWeight(5);
        ui.line(x, original + 15, x, original - 15);

        ui.noStroke();
        ui.fill(255);
        ui.strokeWeight(1);
        ui.ellipse(x, y, diameter, diameter);
    }

    public void update()
    {
        if(ui.checkKey('w') && y > original - 15)
        {
            y = y - 2;
        } else if (ui.checkKey('s') && y < original + 15)
        {
            y = y + 2;
        }

        if(y > original )
        {
            y--;
        } else if (y < original)
        {
            y++;
        }
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
     * @return the diameter
     */
    public float getDiameter() {
        return diameter;
    }

    /**
     * @param diameter the diameter to set
     */
    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    /**
     * @return the original
     */
    public float getOriginal() {
        return original;
    }

    /**
     * @param original the original to set
     */
    public void setOriginal(float original) {
        this.original = original;
    }
}