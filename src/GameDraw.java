import javafx.scene.image.Image;

public class GameDraw {
    public static Plane drawPlane()
    {
        Plane plane = new Plane();
        plane.i = 0;
        plane.j = 10;
        plane.x = plane.i * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        plane.y = plane.j * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        plane.speed = 10;
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

    public static Tower drawTower(int m, int n, String type)
    {
        Tower tower = new Tower();
        tower.x = m * Config.TILE_SIZE;
        tower.y = n * Config.TILE_SIZE;
        tower.setDirection(0);
        if (type.equals("NormalTower"))
        {
            tower.radiusScope = 192;
            tower.damage = 4;
            tower.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            tower.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
            tower.bulletImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile251.png");
        }
        else if (type.equals("SnipperTower"))
        {
            tower.damage = 6;
            tower.radiusScope = 200;
            tower.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            tower.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
            tower.bulletImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile252.png");
        }
        else if (type.equals("MachineGunTower"))
        {
            tower.radiusScope = 130;
            tower.damage = 2;
            tower.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            tower.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
            tower.bulletImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile272.png");
        }

        return tower;
    }
}
