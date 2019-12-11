package TowerDefense;

import GameObject.*;
import Entity.*;

import java.io.*;
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
            //System.out.println(i);
            i++;
        }

        GameField.enemyList.forEach(GameEntity::update);
        GameField.towerList.forEach(Tower::update);
        GameField.timeCount++;
    }

    public void render()
    {
        GameField.drawMap(gc);
        GameField.enemyList.forEach(g->g.render(gc));
        GameField.towerList.forEach(g->g.render(gc));
    }

    public void startPlay(Group root, final GraphicsContext gc, Stage stage)
    {


            ImageView button_m = new ImageView(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile300.png"));
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            Image img = button_m.snapshot(params, null);
            ImageView button = new ImageView(img);
            button.setX(Config.TILE_SIZE * 20);
            button.setY(230);

            ImageView button2_m = new ImageView(new Image("file:AssetsKit_2/PNG/Default size/pause.png"));
            SnapshotParameters params2 = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            Image img2 = button2_m.snapshot(params2, null);
            ImageView button2 = new ImageView(img2);
            button2.setX(Config.TILE_SIZE * 20);
            button2.setY(300);

            Text quit = new Text("Quit");
            quit.setFill(Color.RED);
            quit.setFont(Font.font("Forte", 70));
            quit.setX(Config.TILE_SIZE * 20);
            quit.setY(Config.TILE_SIZE * 11 + 50);

            Image normalTower = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            Image nor = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile206.png");


            Image snipperTower = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            Image snip = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile250.png");

            Image machinegunTower = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            Image machi = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png");

            TowerButton.addButton(root, "file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png", "file:AssetsKit_2/PNG/Default size/towerDefense_tile206.png",Config.TILE_SIZE * 20, Config.TILE_SIZE * 7);
            TowerButton.addButton(root, "file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png", "file:AssetsKit_2/PNG/Default size/towerDefense_tile250.png",Config.TILE_SIZE * 22, Config.TILE_SIZE * 7);
            TowerButton.addButton(root, "file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png", "file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png",Config.TILE_SIZE * 21, Config.TILE_SIZE * 9);


            root.getChildren().addAll(button, button2);


            root.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
                Point p = MouseInfo.getPointerInfo().getLocation();
                if ((GameField.onClick != 0) && GameField.MAP_SPRITES[p.y/Config.TILE_SIZE - 1][p.x/Config.TILE_SIZE].equals("024")) {
                    String towerType = "";
                    if (GameField.onClick == 1) towerType = "NormalTower";
                    else if (GameField.onClick == 2) towerType = "SnipperTower";
                    else if (GameField.onClick == 3) towerType = "MachineGunTower";
                    GameField.towerList.add(GameCreate.drawTower(p.x/Config.TILE_SIZE,p.y/Config.TILE_SIZE - 1, towerType));
                    System.out.println(p.x/Config.TILE_SIZE);
                    System.out.println(p.y/Config.TILE_SIZE - 1);
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

            quit.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> {

                try {
                    GameField.writeContinue();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.close();
            });

            root.getChildren().add(quit);

            EventHandler<MouseEvent> pauseHandler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    if (!GameField.onPause)
                    {
                        GameField.onPause = true;
                    }
                    else
                    {
                        GameField.onPause = false;
                    }
                }
            };

            button.addEventFilter(MouseEvent.MOUSE_CLICKED, startHandler);
            button2.addEventFilter(MouseEvent.MOUSE_CLICKED, pauseHandler);

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

                        try
                        {
                            GameField.writeContinue();
                        } catch (FileNotFoundException e)
                        {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            TimeUnit.SECONDS.sleep(5);
                            stage.close();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    render();
                    if (!GameField.onPause) update();
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

            startPlay(root, gc, stage);
        });


        Exit.setOnMouseClicked(actionEvent -> {
        stage.close();
                });

        Continue.setOnMouseClicked(actionEvent -> {

            root.getChildren().removeAll(newGame, Continue, Exit);

            List<Integer> list = new ArrayList<Integer>();
            File file = new File("continue.txt");
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(file));
                String text = null;

                while ((text = reader.readLine()) != null) {
                    for (String num : text.split(" "))
                    {
                        list.add(Integer.parseInt(num));
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                }
            }

            for (int m = 0; m < list.size(); m++)
            {
                if (list.get(m) == 1 || list.get(m) == 2|| list.get(m) == 3)
                {
                    String type = "";

                    if (list.get(m) == 1) type = "MachineGunTower";
                    if (list.get(m) == 2) type = "NormalTower";
                    if (list.get(m) == 3) type = "SnipperTower";

                    GameField.towerList.add(GameCreate.drawTower( (m - 2) % 19 - 1, (m - 2) / 19, type));
                }
            }

            GameField.currentLEVEL = list.get(0);
            GameField.money = list.get(1);
            GameField.MYHEALTH = list.get(2);

            startPlay(root, gc, stage);
        });

        stage.setScene(scene);

        stage.show();
    }
}
