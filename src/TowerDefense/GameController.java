package TowerDefense;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameController {
    public static void createEnemyInLevel(int level)
    {
        if (level == 1)
        {
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 3000, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 3000, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 3000, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 3000, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 3000, 1));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 20, 20, 150, 5));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 10, 5, 100, 2));
        }
        else if (level == 2)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 20, 20, 150, 5));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 10, 5, 100, 2));
        } else if (level == 3)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 20, 20, 150, 5));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 10, 5, 100, 2));
        } else if (level == 4)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 20, 20, 150, 5));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 10, 5, 100, 2));
        } else if (level == 5)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 20, 20, 150, 5));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 10, 5, 100, 2));
        } else if (level == 6)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 20, 20, 150, 5));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 10, 5, 100, 2));
        } else if (level == 7)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 20, 20, 150, 5));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 10, 5, 100, 2));
        } else if (level == 8)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 20, 20, 150, 5));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 10, 5, 100, 2));
        } else if (level == 9)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 20, 20, 150, 5));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 10, 5, 100, 2));
        } else if (level == 10)
        {
            GameField.enemyListInQueue.clear();
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawSmallerEnemy(18, 10, 5, 30, 1));
            GameField.enemyListInQueue.add(GameCreate.drawTank(5, 20, 20, 150, 5));
            GameField.enemyListInQueue.add(GameCreate.drawBoss(3, 30, 10, 200, 5));
            GameField.enemyListInQueue.add(GameCreate.drawPlane(10, 10, 5, 100, 2));
        }
    }




}
