package TowerDefense;

import GameObject.*;
import Entity.*;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main extends Application {

    GraphicsContext gc;
    GameField gamefield;

    int i = 0;

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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        Canvas canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        stage.setTitle("Tower Defense");
        // Them scene vao stage


        Image background = new Image("file:AssetsKit_2/PNG/Default size/background.png");
        gc.drawImage(background, 0, 0);
        Text newGame = new Text("New Game");
        newGame.setFont(Font.font("Forte", 100));
        newGame.setFill(Color.BLACK);
        newGame.setX(Config.TILE_SIZE * 3);
        newGame.setY(Config.TILE_SIZE * 3);
        
        Text Continue = new Text("Continue");
        Continue.setFont(Font.font("Forte", 100));
        Continue.setFill(Color.BLACK);
        Continue.setX(Config.TILE_SIZE * 3);
        Continue.setY(Config.TILE_SIZE * 6);
        
        Text Exit = new Text("Exit");
        Exit.setFont(Font.font("Forte", 100));
        Exit.setFill(Color.BLACK);
        Exit.setX(Config.TILE_SIZE * 3);
        Exit.setY(Config.TILE_SIZE * 9);



        newGame.fillProperty().bind(Bindings.when(newGame.hoverProperty()).then(Color.RED).otherwise(Color.BLACK));
        Continue.fillProperty().bind(Bindings.when(Continue.hoverProperty()).then(Color.RED).otherwise(Color.BLACK));
        Exit.fillProperty().bind(Bindings.when(Exit.hoverProperty()).then(Color.RED).otherwise(Color.BLACK));

        root.getChildren().addAll(newGame, Continue, Exit);

        newGame.setOnMouseClicked(actionEvent -> {

            root.getChildren().removeAll(newGame, Continue, Exit);

            ImageView button_m = new ImageView(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile300.png"));
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            Image img = button_m.snapshot(params, null);
            ImageView button = new ImageView(img);
            button.setX(Config.TILE_SIZE * 20);
            button.setY(250);

            Image normalTower = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            Image nor = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile206.png");


            Image snipperTower = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            Image snip = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile250.png");

            Image machinegunTower = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            Image machi = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png");

            TowerButton.addButton(root, "file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png", "file:AssetsKit_2/PNG/Default size/towerDefense_tile206.png",Config.TILE_SIZE * 20, Config.TILE_SIZE * 7);
            TowerButton.addButton(root, "file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png", "file:AssetsKit_2/PNG/Default size/towerDefense_tile250.png",Config.TILE_SIZE * 22, Config.TILE_SIZE * 7);
            TowerButton.addButton(root, "file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png", "file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png",Config.TILE_SIZE * 21, Config.TILE_SIZE * 9);


            root.getChildren().add(button);


            root.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
                Point p = MouseInfo.getPointerInfo().getLocation();
                if ((GameField.onClick != 0) && GameField.MAP_SPRITES[p.y/Config.TILE_SIZE - 1][p.x/Config.TILE_SIZE].equals("024")) {
                    String towerType = "";
                    if (GameField.onClick == 1) towerType = "NormalTower";
                    else if (GameField.onClick == 2) towerType = "SnipperTower";
                    else if (GameField.onClick == 3) towerType = "MachineGunTower";
                    GameField.towerList.add(GameCreate.drawTower(p.x/Config.TILE_SIZE,p.y/Config.TILE_SIZE - 1, towerType));
                    GameField.MAP_SPRITES[p.y/Config.TILE_SIZE - 1][p.x/Config.TILE_SIZE] = "306";
                    GameField.onClick = 0;
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
                }
            };

            button.addEventFilter(MouseEvent.MOUSE_CLICKED, startHandler);

            stage.show();



            AnimationTimer timer = new AnimationTimer() {

                @Override
                public void handle(long now)
                {


                    if (GameField.MYHEALTH <= 0)
                    {
                        gc.setFill(Color.RED);
                        gc.setFont(Font.font("Forte", 150));
                        gc.fillText("Game Over!", Config.TILE_SIZE * 8, Config.TILE_SIZE * 4);
                        try {
                            TimeUnit.SECONDS.sleep(5);
                            //break outer;
                            stage.close();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    render();
                    update();
                    Point p = MouseInfo.getPointerInfo().getLocation();
                    if ((GameField.onClick != 0) && p.x < 19 * Config.TILE_SIZE && p.y < 12 * Config.TILE_SIZE && p.x > Config.TILE_SIZE && p.y > Config.TILE_SIZE && GameField.canPut != GameField.MAP_SPRITES[p.y/Config.TILE_SIZE - 1][p.x/Config.TILE_SIZE].equals("024")) {
                        if (GameField.onClick == 1)
                        {
                            root.setCursor(TowerButton.Cursors(GameField.MAP_SPRITES[p.y/Config.TILE_SIZE - 1][p.x/Config.TILE_SIZE].equals("024"), normalTower, nor));
                        }
                        else if (GameField.onClick == 2)
                        {
                            root.setCursor(TowerButton.Cursors(GameField.MAP_SPRITES[p.y/Config.TILE_SIZE - 1][p.x/Config.TILE_SIZE].equals("024"), snipperTower, snip));
                        }
                        else if (GameField.onClick == 3)
                        {
                            root.setCursor(TowerButton.Cursors(GameField.MAP_SPRITES[p.y/Config.TILE_SIZE - 1][p.x/Config.TILE_SIZE].equals("024"), machinegunTower, machi));
                        }
                        GameField.canPut = GameField.MAP_SPRITES[p.y / Config.TILE_SIZE - 1][p.x / Config.TILE_SIZE].equals("024");
                    }
                }
            };

            timer.start();
        });


        Exit.setOnMouseClicked(actionEvent -> {
        stage.close();
                });

        stage.setScene(scene);

        stage.show();
    }
}
