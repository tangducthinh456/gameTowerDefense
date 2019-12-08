package TowerDefense;

import GameObject.*;
import Entity.*;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Cursor;
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

import java.awt.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application
{

    GraphicsContext gc;
    GameField gamefield;

    int i = 0;
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

        stage.setTitle("Tower Defense");
        // Them scene vao stage
        stage.setScene(scene);
        GameField.drawMap(gc);
        GameField.drawController(gc);

        //Image startButton = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile300.png");
        ImageView button = new ImageView(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile300.png"));
        button.setX(Config.TILE_SIZE * 21);
        button.setY(150);

        Image normalTower = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
        Image nor = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile206.png");
        //ImageView normal = new ImageView(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png"));
        //normal.setX(Config.TILE_SIZE * 20);
        //normal.setY(Config.TILE_SIZE * 5);
        //ImageView normalGun = new ImageView(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile206.png"));
        //normalGun.setX(Config.TILE_SIZE * 20);
        //normalGun.setY(Config.TILE_SIZE * 5);


        Image snipperTower = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
        Image snip = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
        /*ImageView snipper = new ImageView(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png"));
        snipper.setX(Config.TILE_SIZE * 22);
        snipper.setY(Config.TILE_SIZE * 5);
        ImageView snipperGun = new ImageView(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile250.png"));
        snipperGun.setX(Config.TILE_SIZE * 22);
        snipperGun.setY(Config.TILE_SIZE * 5);

*/

        Image machinegunTower = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
        Image machi = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        /*ImageView machine = new ImageView(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png"));
        machine.setX(Config.TILE_SIZE * 21);
        machine.setY(Config.TILE_SIZE * 7);
        ImageView machineGun = new ImageView(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png"));
        machineGun.setX(Config.TILE_SIZE * 21);
        machineGun.setY(Config.TILE_SIZE * 7);
         */

        TowerButton.addButton(root, normalTower, nor,Config.TILE_SIZE * 20, Config.TILE_SIZE * 5);
        TowerButton.addButton(root, snipperTower, snip,Config.TILE_SIZE * 22, Config.TILE_SIZE * 5);
        TowerButton.addButton(root, machinegunTower, machi,Config.TILE_SIZE * 21, Config.TILE_SIZE * 7);


        root.getChildren().add(button);

        /*EventHandler<MouseEvent> pickTower = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Tower normalTower = GameCreate.drawTower((int)e.getX(), (int)e.getY(), "NormalTower");
                //normalTower.onMouse = true;
                GameField.towerList.add(normalTower);
                //System.out.println("hihi");
            }
        };*/


        root.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            Point p = MouseInfo.getPointerInfo().getLocation();
            if (GameField.onClick && GameField.MAP_SPRITES[p.y/Config.TILE_SIZE][p.x/Config.TILE_SIZE].equals("024")) {
                System.out.println(p.y / Config.TILE_SIZE);
                System.out.println(p.x / Config.TILE_SIZE);
                GameField.towerList.add(GameCreate.drawTower(p.x/Config.TILE_SIZE,p.y/Config.TILE_SIZE, "NormalTower"));
                GameField.onClick = false;
                root.setCursor(Cursor.DEFAULT);
            }
        });


        EventHandler<MouseEvent> startHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                //GameField.onPlay = true;
                GameField.currentLEVEL++;
                GameController.createEnemyInLevel(GameField.currentLEVEL);
                GameField.timeCount = 0;
                i = 0;
                //System.out.println("hihi");
            }
        };

        button.addEventFilter(MouseEvent.MOUSE_CLICKED, startHandler);

        stage.show();


        GameField.towerList.add(GameCreate.drawTower(10, 3, "NormalTower"));

        GameField.towerList.add(GameCreate.drawTower(2, 6, "MachineGunTower"));

        GameField.towerList.add(GameCreate.drawTower(7, 8, "SnipperTower"));
        GameField.towerList.add(GameCreate.drawTower(10, 2, "MachineGunTower"));

        GameField.towerList.add(GameCreate.drawTower(1, 2, "NormalTower"));
        GameField.towerList.add(GameCreate.drawTower(7, 2, "MachineGunTower"));


        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now)
            {
                Point p;
                if (GameField.MYHEALTH <= 0)
                {
                    return;
                }
                render();
                update();

                p = MouseInfo.getPointerInfo().getLocation();
                if (GameField.onClick && p.x < 24 * Config.TILE_SIZE && p.y < 12 * Config.TILE_SIZE && p.x > Config.TILE_SIZE && p.y > Config.TILE_SIZE && GameField.canPut != GameField.MAP_SPRITES[p.y/Config.TILE_SIZE][p.x/Config.TILE_SIZE].equals("024")) {
                    root.setCursor(TowerButton.Cursors(GameField.MAP_SPRITES[p.y/Config.TILE_SIZE][p.x/Config.TILE_SIZE].equals("024")));
                    GameField.canPut = GameField.MAP_SPRITES[p.y / Config.TILE_SIZE][p.x / Config.TILE_SIZE].equals("024");
                }
            }
        };

        timer.start();
    }

    public void update()
    {
        if (GameField.timeCount % 10 == 0 && GameField.timeCount < 10 * GameField.enemyListInQueue.size() - 10 + 1)
        {
            GameField.enemyList.add(GameField.enemyListInQueue.get(i));
            System.out.println(i);
            i++;
        }

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
