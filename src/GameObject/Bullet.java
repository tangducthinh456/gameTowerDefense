package GameObject;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import Entity.*;
import TowerDefense.*;

//import java.awt.*;
//import java.sql.BatchUpdateException;

public class Bullet extends GameEntity
{
    public  int damage;
    public  int speed;
    public int type;
    public final double bulletDirection;

    public Bullet(int damage, int speed, double x, double y, double bulletDirection)
    {
        this.damage = damage;
        this.speed = speed;
        this.type = type;
        this.x = x;
        this.y = y;
        this.bulletDirection = bulletDirection;
    }

    public Bullet drawBullet(int damage, int speed, double x, double y, double bulletDirection)
    {
        Bullet bullet = new Bullet(damage, speed, x, y, bulletDirection);
        return bullet;
    }
    Image base;

    public boolean isCollision(Enemy enemy)
    {
        return Point.distance(enemy.x, enemy.y, x, y) < 25;
    }

    @Override
    public void render(GraphicsContext gc) {
        ImageView iv = new ImageView(img);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        params.setTransform(new Rotate(this.getDirection(), Config.TILE_SIZE / 2, Config.TILE_SIZE / 2));
        //ImageView iv = new ImageView(gunImg);
        params.setViewport(new Rectangle2D(0, 0, Config.TILE_SIZE, Config.TILE_SIZE));

        base = iv.snapshot(params, null);

        gc.drawImage(base, x, y);
    }

    @Override
    public void update() {

    }
}
