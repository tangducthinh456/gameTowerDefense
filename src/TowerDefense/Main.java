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
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

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
        GameField.drawMap(gc);
        //GameField.drawController(gc);

        Image startButton = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile300.png");
        //if (startButton != null) System.out.println("null");
        //ImageView button = new ImageView(startButton);
        gc.drawImage(startButton, Config.TILE_SIZE * 21, 150);

        stage.show();


        //GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 10, 2000, 1));
        //GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 10, 2000, 1));
        //GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 10, 2000, 1));
        //GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 10, 2000, 1));
        /*GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 10, 30, 1));
        GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 10, 30, 1));
        GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 10, 30, 1));
        GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 10, 30, 1));
        GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 10, 30, 1));
        GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 10, 30, 1));*/


        GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
        GameField.enemyListInQueue.add(GameCreate.drawTank(5, 20, 20, 150, 5));
        GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
        GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 10, 5, 100, 2));

        GameField.numberEnemyInField = GameField.enemyListInQueue.size();

        GameField.towerList.add(GameCreate.drawTower(10, 3, "NormalTower"));

        //GameField.towerList.add(GameCreate.drawTower(15, 9, "SnipperTower"));
        GameField.towerList.add(GameCreate.drawTower(2, 6, "MachineGunTower"));

        GameField.towerList.add(GameCreate.drawTower(7, 8, "SnipperTower"));
        GameField.towerList.add(GameCreate.drawTower(10, 2, "MachineGunTower"));

        GameField.towerList.add(GameCreate.drawTower(1, 2, "NormalTower"));
        //GameField.towerList.add(GameCreate.drawTower(15, 9, "SnipperTower"));
        GameField.towerList.add(GameCreate.drawTower(7, 2, "MachineGunTower"));


        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now)
            {
                if (GameField.MYHEALTH <= 0)
                {
                    GameField.onPlay = false;
                }
                render();
                if (GameField.onPlay) update();
            }
        };

        timer.start();
    }

    int i = 0;
    public void update()
    {
        if (GameField.timeCount % 10 == 0 && GameField.timeCount < 10 * GameField.enemyListInQueue.size() - 10 + 1)
        {
            GameField.enemyList.add(GameField.enemyListInQueue.get(i));
            i++;
        }


        GameField.enemyList.forEach(GameEntity::update);
        GameField.towerList.forEach(Tower::update);
        GameField.timeCount++;

        if (GameField.numberEnemyInField == 0)
        {
            //GameField.timeCount = 0;
            //i = 0;
            //GameField.numberEnemyInField =  GameField.enemyListInQueue.size();
        }

        /*if (GameField.timeCount % 10 == 0 && GameField.timeCount < 11)
            GameField.enemyList.add(GameCreate.drawSmallerEnemy(18, 10, 5, 2000, 1));
        if (GameField.timeCount % 20 == 0 && GameField.timeCount < 21)
            GameField.enemyList.add(GameCreate.drawTank(5, 20, 20, 1500, 5));
        if (GameField.timeCount % 30 == 0 && GameField.timeCount < 31)
            GameField.enemyList.add(GameCreate.drawBoss(3, 30, 10, 2000, 5));
        if (GameField.timeCount % 40 == 0 && GameField.timeCount < 41)
            GameField.enemyList.add(GameCreate.drawPlane(10, 10, 5, 9000, 2));*/
    }

    public void render()
    {
        GameField.drawMap(gc);
        if (GameField.onPlay) GameField.enemyList.forEach(g -> g.render(gc));
        GameField.towerList.forEach(g->g.render(gc));
    }

}
