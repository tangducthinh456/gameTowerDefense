package TowerDefense;

import GameObject.*;
import Entity.*;

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

public class Main extends Application
{

    GraphicsContext gc;
    //List<Enemy> enemy = GameField.enemyList;
    GameField gamefield;

    public static void main(String[] args)
    {
         launch(args);
    }

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
            public void handle(long now)
            {
                render();
                update();
            }
        };
        timer.start();

        if (GameField.timeCount % 10 == 0 && GameField.timeCount < 4000)
            GameField.enemyList.add(GameCreate.drawSmallerEnemy(18, 10, 5, 20, 1));

        //GameField.enemyList.add(GameCreate.drawSmallerEnemy(18, 10, 5, 20, 1));
        //GameField.enemyList.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
        //GameField.enemyList.add(GameCreate.drawTank(5, 20, 20, 150, 5));
        //GameField.enemyList.add(GameCreate.drawPlane(10, 10, 5, 90, 2));



        GameField.towerList.add(GameCreate.drawTower(10, 3, "NormalTower"));

        //GameField.towerList.add(GameCreate.drawTower(15, 9, "SnipperTower"));
        GameField.towerList.add(GameCreate.drawTower(2, 6, "MachineGunTower"));

        GameField.towerList.add(GameCreate.drawTower(7, 8, "SnipperTower"));
        GameField.towerList.add(GameCreate.drawTower(10, 2, "MachineGunTower"));

        GameField.towerList.add(GameCreate.drawTower(1, 2, "NormalTower"));
        //GameField.towerList.add(GameCreate.drawTower(15, 9, "SnipperTower"));
        GameField.towerList.add(GameCreate.drawTower(7, 2, "MachineGunTower"));

    }

    public void update()
    {
        GameField.enemyList.forEach(GameEntity::update);
        GameField.towerList.forEach(Tower::update);
        GameField.timeCount++;
    }

    public void render()
    {
        GameField.drawMap(gc);
        GameField.enemyList.forEach(g -> g.render(gc));
        GameField.towerList.forEach(g->g.render(gc));
    }

}
