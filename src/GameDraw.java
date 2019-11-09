import javafx.scene.image.Image;

public class GameDraw {
    public static Plane drawPlane()
    {
        Plane plane = new Plane();
        plane.i = 0;
        plane.j = 10;
        plane.x = plane.i * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        plane.y = plane.j * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        plane.speed = 7;
        plane.reward = 10;
        plane.damage = 5;
        plane.health = 10;
        plane.setDirection(0);

        plane.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile271.png");
        plane.shadow = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile294.png");
        return plane;
    }

    public static Tank drawTank()
    {
        Tank tank = new Tank();
        tank.i = 0;
        tank.j = 10;
        tank.x = tank.i * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        tank.y = tank.j * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        tank.speed = 5;
        tank.setDirection(0);
        tank.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile268.png");
        tank.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile291.png");
        return tank;
    }

    public static Tower drawTower()
    {
        Tower tower = new Tower();
        tower.x = 5 * Config.TILE_SIZE;
        tower.y = 3 * Config.TILE_SIZE;
        tower.radiusScope = 192;
        tower.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
        tower.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        tower.setDirection(100);
        tower.bulletImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile251.png");
        return tower;
    }
}
