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
    double bulletDirection;
    List<Bullet> listBullet = new ArrayList<>();

    @Override
    void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);


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
            int dx = x - enemy.x;
            int dy = y - enemy.y;
            if (dx == 0) dx++;
            if (dy == 0) dy++;

            if(dx > 0 && dy < 0) this.setDirection(180 + Math.toDegrees(Math.atan((Math.abs((double)dx / dy)))));
            else if(dx > 0 && dy > 0) this.setDirection(270 + Math.toDegrees(Math.atan((Math.abs((double)dy / dx)))));
            else if(dx < 0 && dy > 0) this.setDirection(0 + Math.toDegrees(Math.atan((Math.abs((double)dx / dy)))));
            else if(dx < 0 && dy < 0) this.setDirection(90 + Math.toDegrees(Math.atan((Math.abs((double)dy / dx)))));

        }
    }

    @Override
    void update() {
        calculateDirection(GameField.entities.get(0));
    }
}

