package TowerDefense;

import javafx.scene.image.Image;
import GameObject.*;

public class GameCreate {
    public static Plane drawPlane(double speed, int reward, int damage, int health, int armor)
    {
        Plane plane = new Plane(health);
        plane.i = 0;
        plane.j = 10;
        plane.armor = armor; //2;
        plane.x = plane.i * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        plane.y = plane.j * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        plane.speed = speed;    //10;
        plane.reward = reward;       //10;
        plane.damage = damage;   //5;
        plane.health = plane.HEALTH;
        plane.setDirection(0);

        plane.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile271.png");
        plane.shadow = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile294.png");
        return plane;
    }

    public static SmallerEnemy drawSmallerEnemy(double speed, int reward, int damage, int health, int armor)
    {
        SmallerEnemy sE = new SmallerEnemy(health);
        sE.i = 0;
        sE.j = 10;
        sE.x = sE.i * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        sE.y = sE.j * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        sE.armor = armor; //1;
        sE.speed = speed; //18;
        sE.reward = reward;// 10;
        sE.damage = damage;  //5;
        sE.health = sE.HEALTH;
        sE.setDirection(0);
        sE.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile247.png");
        return sE;
    }

    public static Tank drawTank(double speed, int reward, int damage, int health, int armor)
    {
        Tank tank = new Tank(health);
        tank.i = 0;
        tank.j = 10;
        tank.x = tank.i * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        tank.y = tank.j * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        tank.armor = armor; //5;
        tank.health = tank.HEALTH;
        tank.damage = damage; //20;
        tank.speed = speed; //5;
        tank.reward = reward;  // 20
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
            tower.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile206.png");
            tower.bulletImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile251.png");
        }
        else if (type.equals("SnipperTower"))
        {
            tower.damage = 40;
            tower.fireRange = 300;
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

    public static Boss drawBoss(double speed, int reward, int damage, int health, int armor)
    {
        Boss boss = new Boss(health);
        boss.i = 0;
        boss.j = 10;
        boss.x = boss.i * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        boss.y = boss.j * Config.TILE_SIZE + Config.TILE_SIZE / 2;
        boss.armor = armor; //5;
        boss.health = boss.HEALTH;
        boss.speed = speed; //3;
        boss.setDirection(0);
        boss.img = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile269.png");
        boss.gunImg = new Image("file:AssetsKit_2/PNG/Default size/towerDefense_tile292.png");
        return boss;
    }
}
