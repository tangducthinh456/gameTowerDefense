package TowerDefense;

import javafx.scene.image.Image;
import GameObject.*;

public class GameCreate {
    public static Plane drawPlane()
    {
        Plane plane = new Plane();
        plane.i = 0;
        plane.j = 10;
        plane.armor = 2;
        plane.x = plane.i * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        plane.y = plane.j * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        plane.speed = 10;
        plane.reward = 10;
        plane.damage = 5;
        plane.health = plane.HEALTH;
        plane.setDirection(0);

        plane.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile271.png");
        plane.shadow = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile294.png");
        return plane;
    }

    public static SmallerEnemy drawSmallerEnemy()
    {
        SmallerEnemy sE = new SmallerEnemy();
        sE.i = 0;
        sE.j = 10;
        sE.x = sE.i * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        sE.y = sE.j * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        sE.armor = 1;
        sE.speed = 15;
        sE.reward = 10;
        sE.damage = 5;
        sE.health = sE.HEALTH;
        sE.setDirection(0);
        sE.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile247.png");
        return sE;
    }

    public static Tank drawTank()
    {
        Tank tank = new Tank();
        tank.i = 0;
        tank.j = 10;
        tank.x = tank.i * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        tank.y = tank.j * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        tank.armor = 5;
        tank.health = tank.HEALTH;
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
            tower.fireRange = 192;
            tower.damage = 15;
            tower.period = 10;
            tower.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            tower.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
            tower.bulletImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile251.png");
        }
        else if (type.equals("SnipperTower"))
        {
            tower.damage = 30;
            tower.fireRange = 200;
            tower.period = 20;
            tower.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            tower.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
            tower.bulletImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile252.png");
        }
        else if (type.equals("MachineGunTower"))
        {
            tower.fireRange = 130;
            tower.damage = 6;
            tower.period = 3;
            tower.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
            tower.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
            tower.bulletImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile272.png");
        }

        return tower;
    }

    public static Boss drawBoss()
    {
        Boss boss = new Boss();
        boss.i = 0;
        boss.j = 10;
        boss.x = boss.i * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        boss.y = boss.j * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        boss.armor = 5;
        boss.health = boss.HEALTH;
        boss.speed = 3;
        boss.setDirection(0);
        boss.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile269.png");
        boss.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile292.png");
        return boss;
    }
}
