package Entity;
import GameObject.*;
import TowerDefense.*;
import javafx.scene.canvas.GraphicsContext;


public abstract class Enemy extends GameEntity {

    public double speed;
    public int health;
    public double reward;
    public int damage;
    public int armor;

    public final int HEALTH;

    public Enemy(int HEALTH)
    {
        this.HEALTH = HEALTH;
    }

    int wayPointIndex = 0;

    public Point getNextWayPoint()
    {
        if (wayPointIndex < GameField.wayPoints.length - 1)
            return GameField.wayPoints[++wayPointIndex];
        return null;
    }

    void calculateDirection() {
        // Tinh huong di tiep theo cho Object
        /*if (wayPointIndex >= GameField.wayPoints.length) {
            // Enemy den way point cuoi
          //  GameField.enemyList.remove(this);
            //GameField.MYHEALTH -= this.damage;

        }*/

            Point currentWP = GameField.wayPoints[wayPointIndex];

            if (Point.distance(x, y, currentWP.x, currentWP.y) <= speed) {
                x = currentWP.x;
                y = currentWP.y;
                Point nextWayPoint = getNextWayPoint();
                if (nextWayPoint == null && GameField.enemyList.contains(this))
                {
                    this.x = 9999;
                    this.y = 9999;
                    this.direction = 20;
                    GameField.numberEnemyInField--;
                    GameField.MYHEALTH -= this.damage;
                    return;
                }
                double deltaX = nextWayPoint.x - x;
                double deltaY = nextWayPoint.y - y;
                if (deltaX > speed) direction = 0;
                else if (deltaX < -speed) direction = 180;
                else if (deltaY > speed) direction = 90;
                else if (deltaY <= -speed) direction = 270;

            }

    }

    @Override
    public void update()
    {
        calculateDirection();
        //System.out.println(this.x);
        switch ((int)direction) {
            case 270:
                y -= speed;
                break;
            case 90:
                y += speed;
                break;
            case 180:
                x -= speed;
                break;
            case 0:
                x += speed;
                break;
        }
    }

    @Override

    abstract public void render(GraphicsContext gc);
}
