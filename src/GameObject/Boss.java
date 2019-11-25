package GameObject;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import Entity.*;
import TowerDefense.*;

public class Boss extends Enemy
{
    public Image gunImg;
    //int gunRotation;
    public Boss(int HEALTH)
    {
        super(HEALTH);
    }


    @Override
    public void render(GraphicsContext gc)
    {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView(img);
        iv.setRotate(this.getDirection());
        Image base = iv.snapshot(params, null);

        ImageView iv2 = new ImageView(gunImg);
        iv2.setRotate(this.getDirection());
        Image gun = iv2.snapshot(params, null);

        gc.drawImage(base, x, y);
        gc.drawImage(gun, x, y);

        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(x, y, Config.TILE_SIZE, 4);

        gc.setFill(Color.RED);
        gc.fillRect(x, y, (int)((double)(HEALTH - health) / HEALTH * Config.TILE_SIZE) , 4);
    }
}