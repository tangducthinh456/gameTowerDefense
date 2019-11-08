import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

class Plane extends Enemy
{

    Image shadow;


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



        gc.setFill(Color.RED);
        gc.fillOval(GameField.wayPoints[wayPointIndex].x,GameField.wayPoints[wayPointIndex].y,10, 10);

        gc.setFill(Color.BLUE);
        gc.fillOval(x, y,10, 10);
    }
}