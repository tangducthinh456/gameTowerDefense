package TowerDefense;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameController {
    public static void createEnemyInLevel(int level)
    {
        if (level == 1)
        {
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 2));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 2));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 2));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 2));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 2));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 2));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 2));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 2));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 2));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 2));

            //GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 800, 7));
            //GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 1500, 10));
            //GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 400, 5));
        }
        else if (level == 2)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 3));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 3));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 3));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 3));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 3));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 100, 3));

            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 3000, 7));

        } else if (level == 3)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 120, 3));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 120, 3));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 120, 3));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 120, 3));

            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 600, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 600, 5));

            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 3000, 7));

            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 400, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 400, 5));

            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 3000, 7));


        } else if (level == 4)
        {
            GameField.enemyListInQueue.clear();

            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));



            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 700, 6));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 3000, 10));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 700, 6));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 3000, 10));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 700, 6));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 3000, 10));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 700, 6));

            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 3000, 10));

            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 700, 6));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 700, 6));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 700, 6));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 700, 6));

            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 3000, 10));
        } else if (level == 5)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 100, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));

            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));

            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));

        } else if (level == 6)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 100, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));

            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));

            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
        } else if (level == 7)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 100, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));

            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));

            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
        } else if (level == 8)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 100, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));

            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));

            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
        } else if (level == 9)
        {
            GameField.enemyListInQueue.clear();

            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 100, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));

            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));

            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));

        } else if (level == 10)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));

            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(15, 25, 5, 130, 4));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 100, 7));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));

            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 100, 40, 7000, 15));

            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 70, 30, 4000, 12));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 40, 20, 1000, 7));
        }
    }




}
