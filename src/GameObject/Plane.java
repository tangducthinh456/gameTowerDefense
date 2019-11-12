package GameObject;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import Entity.*;
import TowerDefense.*;

public class Plane extends Enemy
{
    public Image shadow;
    public final int HEALTH = 50;

    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        ImageView iv2 = new ImageView(shadow);
        iv2.setRotate(this.getDirection());
        Image base2 = iv2.snapshot(params, null);
        gc.drawImage(base2, x - Config.TILE_SIZE / 2, y - Config.TILE_SIZE / 2);



        ImageView iv = new ImageView(img);
        iv.setRotate(this.getDirection());
        Image base = iv.snapshot(params, null);

        gc.drawImage(base, x, y);

        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(x, y, Config.TILE_SIZE, 4);

        gc.setFill(Color.RED);
        gc.fillRect(x, y, (int)((double)(HEALTH - health) / HEALTH * Config.TILE_SIZE), 4);

    }
}