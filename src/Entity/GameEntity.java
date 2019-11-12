package Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameEntity
{
    public int i = 0, j = 0;
    public double x = 0;
    public double y = 0;
    public Image img;
    public double direction = 0;

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public abstract void render(GraphicsContext gc);
    public abstract void update();
}


