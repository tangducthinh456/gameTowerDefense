import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

public class Tower extends GameEntity{

    double fireRate;
    double radiusScope;
    Image gunImg;
    Image bulletImg;
    List<Bullet> listBullet = new ArrayList<>();

    @Override
    void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);

        if (!listBullet.isEmpty())
        {
            ImageView iv = new ImageView(bulletImg);
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            params.setTransform(new Rotate(listBullet.get(0).bulletDirection, Config.TILE_SIZE / 2, Config.TILE_SIZE / 2));
            //ImageView iv = new ImageView(gunImg);
            params.setViewport(new Rectangle2D(0, 0, Config.TILE_SIZE, Config.TILE_SIZE));

            Image base = iv.snapshot(params, null);
            gc.drawImage(base, listBullet.get(0).x, listBullet.get(0).y);
        }



        ImageView iv = new ImageView(gunImg);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        params.setTransform(new Rotate(this.getDirection(), Config.TILE_SIZE / 2, Config.TILE_SIZE / 2));
        //ImageView iv = new ImageView(gunImg);
        params.setViewport(new Rectangle2D(0, 0, Config.TILE_SIZE, Config.TILE_SIZE));


        Image base = iv.snapshot(params, null);
        gc.drawImage(base, x, y);


    }

    void calculateDirection(GameEntity enemy)
    {
        if (Point.distance(x, y, enemy.x, enemy.y) < radiusScope)
        {
            double dx = x - enemy.x;
            double dy = y - enemy.y;
            if (dx == 0) dx++;
            if (dy == 0) dy++;

            if (dx > 0 && dy < 0)
            {
                this.setDirection(180 + Math.toDegrees(Math.atan((Math.abs((double)dx / dy)))));
            }
            else if (dx > 0 && dy > 0)
            {
                this.setDirection(270 + Math.toDegrees(Math.atan((Math.abs((double)dy / dx)))));

            }
            else if (dx < 0 && dy > 0)
            {
                this.setDirection(0 + Math.toDegrees(Math.atan((Math.abs((double)dx / dy)))));
            }
            else if (dx < 0 && dy < 0)
            {
                this.setDirection(90 + Math.toDegrees(Math.atan((Math.abs((double)dy / dx)))));
            }
            if (listBullet.isEmpty())
            {
                listBullet.add( new Bullet(10, 30, 1, x, y, this.getDirection()));
                //double a= listBullet.get(0).direction
            }
        }
        if (!listBullet.isEmpty())
        {
            listBullet.get(0).x += Math.sin(Math.toRadians(listBullet.get(0).bulletDirection)) * (double)listBullet.get(0).speed;
            double m = Math.sin(listBullet.get(0).bulletDirection);
            listBullet.get(0).y -= Math.cos(Math.toRadians(listBullet.get(0).bulletDirection)) * (double)listBullet.get(0).speed;
            double n = Math.cos(listBullet.get(0).bulletDirection);
            if (listBullet.get(0).x <= 0 || listBullet.get(0).y <= 0 || listBullet.get(0).x >= Config.GAMEFIELD_WIDTH || listBullet.get(0).y >= Config.SCREEN_HEIGHT || listBullet.get(0).isCollision(enemy)) listBullet.remove(listBullet.get(0));
        }
    }
    @Override
    void update()
    {
        calculateDirection(GameField.entities.get(1));
    }
}

