import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameController extends AnimationTimer {
    GameField gameField;
    //GraphicsContext

    @Override
    public void handle(long l) {
        render();
        update();
    }

    public void update() {
        //gameField..forEach(GameEntity::update);
    }
    public void render()
    {
        //GameField.drawMap(gc);
        //gameField.entities.forEach(g -> g.render(gc));
    }
}
