
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

        //enemy.add(createTank());

        enemy.add(GameDraw.drawPlane());
        enemy.add(createTower());
    }

    // TODO: Factory Method






    public Tower createTower() {
        Tower tower = new Tower();
        tower.x = 4 * Config.TILE_SIZE;
        tower.y = 2 * Config.TILE_SIZE;
        tower.radiusScope = 192;
        tower.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
        tower.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        tower.setDirection(270);
        return tower;
    }

    /*public static final String[][] MAP_SPRITES = new String[][] {
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

    private void drawMap(GraphicsContext gc) {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                gc.drawImage(new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile" + MAP_SPRITES[i][j] + ".png"), j * Config.TILE_SIZE , i * Config.TILE_SIZE);
            }
        }
    }*/

    public void update() {
        enemy.forEach(GameEntity::update);
    }

    public void render()
    {
        GameField.drawMap(gc);
        enemy.forEach(g -> g.render(gc));
    }


}



abstract class GameObject {
    int i, j;
    int x;
    int y;
    Image img;

    abstract void render(GraphicsContext gc);
    abstract void update();

}

/*abstract class MovableObject extends GameObject {
    double speed;
    Direction direction;

    int wayPointIndex = 0;
    public Point getNextWayPoint()
    {
        if (wayPointIndex < TowerDefense.wayPoints.length - 1)
            return TowerDefense.wayPoints[++wayPointIndex];
        return null;
    }

    void calculateDirection() {
        // Tinh huong di tiep theo cho Object
        if (wayPointIndex >= TowerDefense.wayPoints.length) {
            // Enemy den way point cuoi
            return;
        }

        Point currentWP = TowerDefense.wayPoints[wayPointIndex];

        if (TowerDefense.distance(x, y, currentWP.x, currentWP.y) <= speed) {
            x = currentWP.x;
            y = currentWP.y;
            Point nextWayPoint = getNextWayPoint();
            if (nextWayPoint == null) return;
            double deltaX = nextWayPoint.x - x;
            double deltaY = nextWayPoint.y - y;
            if (deltaX > speed) direction = Direction.RIGHT;
            else if (deltaX < -speed) direction = Direction.LEFT;
            else if (deltaY > speed) direction = Direction.DOWN;
            else if (deltaY <= -speed) direction = Direction.UP;

        }
    }

    @Override
    void update() {

        calculateDirection();

        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
        }
    }

}

abstract class VulnerableObject extends MovableObject {
    int health;
    double reward;
    int damage;
}

abstract class AttackableObject extends GameObject {
    double damage;
    double fireRate;
    double fireRange;
}*/





/*class Tank extends VulnerableObject
{
    Image gunImg;
    int gunRotation;

    @Override
    void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView(img);
        iv.setRotate(this.direction.getDegree());
        Image base = iv.snapshot(params, null);

        ImageView iv2 = new ImageView(gunImg);
        iv2.setRotate(this.direction.getDegree());
        Image gun = iv2.snapshot(params, null);

        gc.drawImage(base, x, y);
        gc.drawImage(gun, x, y);

        gc.setFill(Color.RED);
        gc.fillOval(TowerDefense.wayPoints[wayPointIndex].x,TowerDefense.wayPoints[wayPointIndex].y,10, 10);

        gc.setFill(Color.BLUE);
        gc.fillOval(x, y,10, 10);
    }


}
*/
