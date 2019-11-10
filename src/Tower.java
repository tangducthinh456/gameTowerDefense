
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Tower extends GameEntity{

    long curentTime = 0;
    int period = 500;
    int fireRate; // bullets per second
    double radiusScope;
    Image gunImg;
    Image bulletImg;
    public  int damage;
    String type;
    Queue<Enemy> enemyInScope = new LinkedList<>();
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

    void calculateDirection(Enemy enemy)
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
            /*if (listBullet.isEmpty())
            {
                listBullet.add( new Bullet(10, 30, x, y, this.getDirection()));
                //double a= listBullet.get(0).direction
            }*/
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            listBullet.add( new Bullet(10, 30, x, y, direction));
                        }
                    },
                    period
            );
        }
        /*if (!listBullet.isEmpty())
        {
            listBullet.get(0).x += Math.sin(Math.toRadians(listBullet.get(0).bulletDirection)) * (double)listBullet.get(0).speed;

            listBullet.get(0).y -= Math.cos(Math.toRadians(listBullet.get(0).bulletDirection)) * (double)listBullet.get(0).speed;

            if (listBullet.get(0).x <= 0 || listBullet.get(0).y <= 0 || listBullet.get(0).x >= Config.GAMEFIELD_WIDTH || listBullet.get(0).y >= Config.SCREEN_HEIGHT || listBullet.get(0).isCollision(enemy)) listBullet.remove(0);
            //if (enemyInScope.isEmpty()) listBullet.remove(0);
        }*/
        for (Bullet bullet : listBullet)
        {
            bullet.x += Math.sin(Math.toRadians(bullet.bulletDirection)) * (double)bullet.speed;

            bullet.y -= Math.cos(Math.toRadians(bullet.bulletDirection)) * (double)bullet.speed;

            if (bullet.x <= 0 || bullet.y <= 0 || bullet.x >= Config.GAMEFIELD_WIDTH || bullet.y >= Config.SCREEN_HEIGHT || bullet.isCollision(enemy)) listBullet.remove(bullet);
            //if (enemyInScope.isEmpty()) listBullet.remove(0);
        }
    }
    @Override
    void update()
    {
        for(Enemy enemy : GameField.enemyList)
        {
            //double m = Point.distance(enemy.x, enemy.y, x, y);
            if (Point.distance(enemy.x, enemy.y, x, y) <= radiusScope)
            {
                if(!enemyInScope.contains(enemy)) enemyInScope.add(enemy);
                //else if (enemyInScope.contains(enemy)) enemyInScope.add(enemy);
            }
            else if (!enemyInScope.isEmpty())
            {
                if (enemy == enemyInScope.peek())
                {
                    Object firstElement = enemyInScope.remove();
                }
            }
        }
        if(!enemyInScope.isEmpty()){ calculateDirection(enemyInScope.peek());
            long a = GameField.timeStart - System.currentTimeMillis();
    }
        else if (!listBullet.isEmpty())
        {
            for (Bullet bullet : listBullet)
            {
                bullet.x += Math.sin(Math.toRadians(bullet.bulletDirection)) * (double)bullet.speed;

                bullet.y -= Math.cos(Math.toRadians(bullet.bulletDirection)) * (double)bullet.speed;

                if (bullet.x <= 0 || bullet.y <= 0 || bullet.x >= Config.GAMEFIELD_WIDTH || bullet.y >= Config.SCREEN_HEIGHT) listBullet.remove(bullet);
                //if (enemyInScope.isEmpty()) listBullet.remove(0);
            }
           // listBullet.get(0).x += Math.sin(Math.toRadians(listBullet.get(0).bulletDirection)) * (double)listBullet.get(0).speed;

           // listBullet.get(0).y -= Math.cos(Math.toRadians(listBullet.get(0).bulletDirection)) * (double)listBullet.get(0).speed;

           // if (listBullet.get(0).x <= 0 || listBullet.get(0).y <= 0 || listBullet.get(0).x >= Config.GAMEFIELD_WIDTH || listBullet.get(0).y >= Config.SCREEN_HEIGHT) listBullet.remove(0);
        }
    }
}

