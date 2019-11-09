
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TowerDefense extends Application
{

    GraphicsContext gc;
    List<GameEntity> enemy = GameField.entities;
    GameField gamefield;

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        Canvas canvas = new Canvas(Config.SCREEN_WIDTH,  Config.SCREEN_HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();



        enemy.add(GameDraw.drawPlane());
        enemy.add(GameDraw.drawTank());
        enemy.add(GameDraw.drawTower());
    }

    public void update() {
        enemy.forEach(GameEntity::update);
    }

    public void render()
    {
        GameField.drawMap(gc);
        enemy.forEach(g -> g.render(gc));
    }

}
