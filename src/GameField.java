import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class GameField
{
    static List<Enemy> enemyList = new ArrayList<>();
    static List<Tower> towerList = new ArrayList<>();
    static long timeCount = 0;

    public static final String[][] MAP_SPRITES = new String[][] {
            { "024", "024", "003", "047", "047", "047", "047", "047", "047", "047", "047", "047", "004", "024", "024", "024", "024", "024", "024" },
            { "024", "024", "025", "299", "001", "001", "001", "001", "001", "001", "001", "002", "023", "024", "024", "024", "024", "024", "024" },
            { "024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "024", "024" },
            { "003", "047", "048", "023", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "024", "024" },
            { "025", "299", "001", "027", "024", "024", "024", "024", "024", "024", "024", "025", "046", "047", "047", "047", "047", "004", "024" },
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "026", "001", "001", "001", "001", "002", "023", "024" },
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024" },
            { "025", "046", "047", "047", "047", "047", "004", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024" },
            { "026", "001", "001", "001", "001", "002", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024" },
            { "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024" },
            { "047", "047", "047", "047", "047", "048", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024" },
            { "001", "001", "001", "001", "001", "001", "027", "024", "024", "024", "024", "024", "024", "024", "024", "024", "025", "023", "024" },
    };

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
    };

    public static void drawMap(GraphicsContext gc) {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                gc.drawImage(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile" + MAP_SPRITES[i][j] + ".png"), j * Config.TILE_SIZE , i * Config.TILE_SIZE);
            }
        }
    }
}
