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
}