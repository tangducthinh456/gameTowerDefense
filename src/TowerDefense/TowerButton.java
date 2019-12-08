package TowerDefense;

import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
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
        Button button = new Button("", gunButton);
        button.setOnMouseClicked(actionEvent -> {
            root.setCursor(new ImageCursor(img, Config.TILE_SIZE, Config.TILE_SIZE));
            //GameEntities.clicked=1;
        });
        button.setLayoutX(16 * 64);
        button.setLayoutY(0);
        root.getChildren().add(button);
    }
}
