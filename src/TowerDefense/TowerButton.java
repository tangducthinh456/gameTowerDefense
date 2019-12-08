package TowerDefense;

import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public class TowerButton {
    public static void addButton(Group root, Image towerImg, Image gunImg, int x, int y)
    {
        ImageView towerIv = new ImageView(towerImg);
        ImageView gunIv = new ImageView(gunImg);

        Group gunButton = new Group(towerIv, gunIv);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image img = gunButton.snapshot(params, null);

        //ImageView abss = new ImageView(img);

        Button button = new Button("", gunButton);
        button.setOnMouseClicked(actionEvent -> {
            root.setCursor(new ImageCursor(img, Config.TILE_SIZE, Config.TILE_SIZE));
            GameField.onClick = true;
        });
        button.setLayoutX(x);
        button.setLayoutY(y);
        root.getChildren().add(button);
    }

    static ImageCursor Cursors(boolean color) {
        Image towerImg = new Image("file:resources/towerDefense_tile181.png", Config.TILE_SIZE, Config.TILE_SIZE, true, false);
        Image gunImg = new Image("file:resources/towerDefense_tile249.png", Config.TILE_SIZE, Config.TILE_SIZE, true, false);
        Image red = new Image("file:resources/red.png", Config.TILE_SIZE, Config.TILE_SIZE, true, false);
        Image green = new Image("file:resources/green.png", Config.TILE_SIZE, Config.TILE_SIZE, true, false);
        ImageView towerIv = new ImageView(towerImg);
        ImageView gunIv = new ImageView(gunImg);
        ImageView redIv = new ImageView(red);
        ImageView greenIv = new ImageView(green);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView towerIv2 = new ImageView(towerImg);
        ImageView gunIv2 = new ImageView(gunImg);
        redIv.setBlendMode(BlendMode.OVERLAY);
        Group gunRed = new Group(towerIv, gunIv,redIv);
        greenIv.setBlendMode(BlendMode.OVERLAY);
        Group gunGreen = new Group(towerIv2, gunIv2,greenIv);
        Image greenImg = gunGreen.snapshot(params, null);
        Image redImg = gunRed.snapshot(params, null);
        ImageCursor redImageCursor = new ImageCursor(redImg, Config.TILE_SIZE, Config.TILE_SIZE);
        ImageCursor greenImageCursor = new ImageCursor(greenImg, Config.TILE_SIZE, Config.TILE_SIZE);
        if (!color) return redImageCursor;
        else return greenImageCursor;
    }
}