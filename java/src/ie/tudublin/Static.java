package ie.tudublin;


public class Static
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;

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
        ui.noFill();
        ui.stroke(255);
        ui.noStroke();
        ui.rect(x, y, width, height);
    }

    public void update()
    {
        int numSquares = 35;
        float spacing = width / numSquares;
        float tempX = x;
        float tempY = y;

        //Code to change each square a different shade
		for(int i = 0; i < numSquares; i++)
		{
			for(int j = 0; j < numSquares; j++)
			{
                ui.noStroke();
				ui.fill(ui.random(255));
				ui.rect(x, y, spacing, spacing);
				y = y + spacing;
			}
			
			x = x + spacing;
			y = tempY;
        }

        x = tempX;
        y = tempY;

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
     * @return the width
     */
    public float getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(float height) {
        this.height = height;
    }
}