import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

abstract class GameEntity
{
    protected int i = 0, j = 0;
    protected double x = 0;
    protected double y = 0;
    Image img;
    protected double direction = 0;

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    abstract void render(GraphicsContext gc);
    abstract void update();
}


