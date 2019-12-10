package TowerDefense;

import GameObject.*;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import Entity.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameField
{
    public static List<Enemy> enemyList = new ArrayList<>();
    public static List<Enemy> enemyListInQueue = new ArrayList<>();

    
    
    //public static List<Enemy> enemyListToRemove = new ArrayList<>();
    public static List<Tower> towerList = new ArrayList<>();
    public static int numberEnemyInField;
    public static long timeCount = 0;
    public static int MYHEALTH = 100;
    public static int currentLEVEL = 0;
    public static int onClick = 0;
    public static boolean canPut = true;
    public static Integer money = 100;

    public static final String[][] MAP_SPRITES = new String[][] {
            { "024", "024", "003", "047", "047", "047", "047", "047", "047", "047", "047", "047", "004", "024", "024", "024", "024", "024", "024", "236", "236", "236", "236", "236"},
            { "024", "024", "025", "299", "001", "001", "001", "001", "001", "001", "001", "002", "023", "024", "024", "024", "024", "024", "024", "236", "236", "236", "236", "236"},
            { "024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "236", "236", "236", "236", "236"},
            { "003", "047", "048", "023", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "236", "236", "236", "236", "236"},
            { "025", "299", "001", "027", "024", "024", "024", "024", "024", "024", "024", "025", "046", "047", "047", "047", "047", "004", "024", "236", "236", "236", "236", "236"},
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "026", "001", "001", "001", "001", "002", "023", "024", "236", "236", "236", "236", "236"},
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024", "236", "236", "236", "236", "236"},
            { "025", "046", "047", "047", "047", "047", "004", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024", "236", "236", "236", "236", "236"},
            { "026", "001", "001", "001", "001", "002", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024", "236", "236", "236", "236", "236"},
            { "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024", "236", "236", "236", "236", "236"},
            { "047", "047", "047", "047", "047", "048", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024", "236", "236", "236", "236", "236"},
            { "001", "001", "001", "001", "001", "001", "027", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024", "236", "236", "236", "236", "236"},
    };

    /*public static final String[][] CONTROLLER_SPRITES = new String[][]
            {
                    {"236", "236", "236", "236", "236"},
                    {"236", "236", "236", "236", "236"},
                    {"236", "236", "236", "236", "236"},
                    {"236", "236", "236", "236", "236"},
                    {"236", "236", "236", "236", "236"},
                    {"236", "236", "236", "236", "236"},
                    {"236", "236", "236", "236", "236"},
                    {"236", "236", "236", "236", "236"},
                    {"236", "236", "236", "236", "236"},
                    {"236", "236", "236", "236", "236"},
                    {"236", "236", "236", "236", "236"},
                    {"236", "236", "236", "236", "236"}
            };*/

    public static final Point[] wayPoints = new Point[] {
            //new Point(0, 10 * Config.TILE_SIZE + Config.TILE_SIZE / 2),
            new Point(5 * Config.TILE_SIZE + Config.TILE_SIZE / 2, 10 * Config.TILE_SIZE + Config.TILE_SIZE / 2),
            new Point(5 * Config.TILE_SIZE + Config.TILE_SIZE / 2, 7 * Config.TILE_SIZE + Config.TILE_SIZE / 2),
            new Point(Config.TILE_SIZE / 2, 7 * Config.TILE_SIZE + Config.TILE_SIZE / 2),
            new Point(Config.TILE_SIZE / 2, 3 * Config.TILE_SIZE + Config.TILE_SIZE / 2),
            new Point(2 * Config.TILE_SIZE + Config.TILE_SIZE / 2, 3 * Config.TILE_SIZE + Config.TILE_SIZE / 2),
            new Point(2 * Config.TILE_SIZE + Config.TILE_SIZE / 2,  Config.TILE_SIZE / 2),
            new Point(11 * Config.TILE_SIZE + Config.TILE_SIZE / 2, Config.TILE_SIZE / 2),
            new Point(11 * Config.TILE_SIZE + Config.TILE_SIZE / 2, 4 * Config.TILE_SIZE + Config.TILE_SIZE / 2),
            new Point(16 * Config.TILE_SIZE + Config.TILE_SIZE / 2, 4 * Config.TILE_SIZE + Config.TILE_SIZE / 2),
            new Point(16 * Config.TILE_SIZE + Config.TILE_SIZE / 2, 4 * Config.TILE_SIZE + Config.TILE_SIZE / 2),
            new Point(16 * Config.TILE_SIZE + Config.TILE_SIZE / 2, 11 * Config.TILE_SIZE + Config.TILE_SIZE / 2),
            //new Point(17 * Config.TILE_SIZE + Config.TILE_SIZE / 2, 11 * Config.TILE_SIZE + Config.TILE_SIZE / 2)
    };

    public static void drawMap(GraphicsContext gc) {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                gc.drawImage(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile" + MAP_SPRITES[i][j] + ".png"), j * Config.TILE_SIZE , i * Config.TILE_SIZE);
            }
        }
        Integer level = currentLEVEL;
        Integer health = MYHEALTH;
        gc.setFill(Color.LIGHTGREEN);
        gc.setFont(new Font("Arial", 40));
        gc.fillText("Level :", 19 * Config.TILE_SIZE,40);
        gc.fillText(level.toString(), 19 * Config.TILE_SIZE + 150,40);
        gc.fillText("Money :", 19 * Config.TILE_SIZE, 120);
        gc.fillText(money.toString() + "$", 19 * Config.TILE_SIZE + 150, 120);
        gc.setFill(Color.LIGHTPINK);
        gc.fillText("Health :", 19 * Config.TILE_SIZE, 200);
        gc.fillText(health.toString(), 19 * Config.TILE_SIZE + 150, 200);
        gc.setFill(Color.ALICEBLUE);
        gc.fillText("80$", Config.TILE_SIZE * 20 + 10, Config.TILE_SIZE * 8 + 50);
        gc.fillText("150$", Config.TILE_SIZE * 22 + 10, Config.TILE_SIZE * 8 + 50);
        gc.fillText("50$", Config.TILE_SIZE * 21 + 10, Config.TILE_SIZE * 10 + 50);
    }

    /*public static void drawController(GraphicsContext gc) {
        for (int i = 0; i < CONTROLLER_SPRITES.length; i++) {
            for (int j = 0; j < CONTROLLER_SPRITES[i].length; j++) {
                gc.drawImage(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile" + CONTROLLER_SPRITES[i][j] + ".png"), (j + 19) * Config.TILE_SIZE , i * Config.TILE_SIZE);
            }
        }
    }*/


}
