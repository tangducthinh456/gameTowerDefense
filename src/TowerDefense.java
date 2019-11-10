
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
    //List<Enemy> enemy = GameField.enemyList;
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

        GameField.enemyList.add(GameDraw.drawPlane());
        GameField.enemyList.add(GameDraw.drawTank());

        GameField.towerList.add(GameDraw.drawTower(4, 2, "NormalTower"));
        GameField.towerList.add(GameDraw.drawTower(15, 9, "SnipperTower"));
        GameField.towerList.add(GameDraw.drawTower(2, 6, "MachineGunTower"));
        GameField.towerList.add(GameDraw.drawTower(2, 9, "NormalTower"));

    }

    public void update()
    {
        GameField.enemyList.forEach(GameEntity::update);
        GameField.towerList.forEach(Tower::update);
    }

    public void render()
    {
        GameField.drawMap(gc);
        GameField.enemyList.forEach(g -> g.render(gc));
        GameField.towerList.forEach(g->g.render(gc));
    }

}
