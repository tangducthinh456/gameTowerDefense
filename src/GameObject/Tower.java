package GameObject;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
//import org.w3c.dom.ls.LSOutput;
import Entity.*;
import TowerDefense.*;

import java.util.*;

public class Tower extends GameEntity{

    public int period;
    public int fireRate; // bullets per second
    public double fireRange;
    public Image gunImg;
    public Image bulletImg;
    public int damage;
    public int fee;
    Queue<Enemy> enemyInScope = new LinkedList<>();
    List<Bullet> listBullet = new ArrayList<>();
    public boolean onMouse = false;


    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);

        if (!listBullet.isEmpty())
        {
            for(Bullet bullet : listBullet)
            {
                ImageView iv = new ImageView(bulletImg);
                SnapshotParameters params = new SnapshotParameters();
                params.setFill(Color.TRANSPARENT);
                params.setTransform(new Rotate(bullet.bulletDirection, Config.TILE_SIZE / 2, Config.TILE_SIZE / 2));
                //ImageView iv = new ImageView(gunImg);
                params.setViewport(new Rectangle2D(0, 0, Config.TILE_SIZE, Config.TILE_SIZE));

                Image base = iv.snapshot(params, null);
                gc.drawImage(base, bullet.x, bullet.y);
            }
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
        double dx = x - enemy.x;
        double dy = y - enemy.y;
        if (dx == 0) dx++;
        if (dy == 0) dy++;

        this.setDirection(270 + Math.toDegrees(Math.atan2((double)dy, (double)dx)));

        if (GameField.timeCount % period == 0)
        {
            listBullet.add( new Bullet(10, 45, x, y, this.getDirection()));
            //double a= listBullet.get(0).direction
        }

        for(Iterator<Bullet> itr = listBullet.iterator(); itr.hasNext();)
        {
            Bullet bullet = itr.next();
            bullet.x += Math.sin(Math.toRadians(bullet.bulletDirection)) * (double)bullet.speed;

            bullet.y -= Math.cos(Math.toRadians(bullet.bulletDirection)) * (double)bullet.speed;

            if (bullet.isCollision(enemy))
            {
                enemy.health -= damage;
                //System.out.println(enemy.health);
                if (enemy.health <= 0)
                {
                    /*if(enemy instanceof Boss) GameField.money += 70;
                    if(enemy instanceof Plane) GameField.money += 40;
                    if(enemy instanceof Tank) GameField.money += 50;
                    if(enemy instanceof SmallerEnemy) GameField.money += 20;*/
                    GameField.money += enemy.reward;

                    if (enemyInScope.contains(enemy)) enemyInScope.remove(enemy);
                    GameField.enemyList.remove(enemy);
                    GameField.numberEnemyInField--;
                    //System.out.println(GameField.numberEnemyInField);
                }
            }
            if (bullet.x <= 0 || bullet.y <= 0 || bullet.x >= Config.GAMEFIELD_WIDTH || bullet.y >= Config.SCREEN_HEIGHT || bullet.isCollision(enemy)) itr.remove();
            //if (enemyInScope.isEmpty()) listBullet.remove(0);
        }
    }
    @Override
    public void update()
    {
        for(Enemy enemy : GameField.enemyList)
        {
            //double m = Point.distance(enemy.x, enemy.y, x, y);
            if (Point.distance(enemy.x, enemy.y, x, y) <= fireRange)
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

        if(!enemyInScope.isEmpty()) calculateDirection(enemyInScope.peek());
        else if (!listBullet.isEmpty()) {
            for (Iterator<Bullet> itr = listBullet.iterator(); itr.hasNext(); ) {
                Bullet bullet = itr.next();
                bullet.x += Math.sin(Math.toRadians(bullet.bulletDirection)) * (double) bullet.speed;

                bullet.y -= Math.cos(Math.toRadians(bullet.bulletDirection)) * (double) bullet.speed;

                if (bullet.x <= 0 || bullet.y <= 0 || bullet.x >= Config.GAMEFIELD_WIDTH || bullet.y >= Config.SCREEN_HEIGHT)
                    itr.remove();
                //if (enemyInScope.isEmpty()) listBullet.remove(0);
            }
        }
    }
}

