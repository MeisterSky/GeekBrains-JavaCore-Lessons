package Lesson1;

import java.math.BigDecimal;

public class Robot {

    private String name;

    private double jumpPower;

    private double movePower;

    private boolean canMove;


    public Robot(String name, double jumpPower, double movePower) {
        this.name = "Объект \"" + name + "\"";
        this.jumpPower = jumpPower;
        this.movePower = movePower;
        if (movePower > 0) {
            this.canMove = true;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public double getJumpPower() {
        return jumpPower;
    }

    public double getMovePower() {
        return movePower;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void move(Double obstacleLength) {
        if (movePower <= 0) {
            System.out.println(name + " не может дальше двигаться из-за разряда батареи");
            this.canMove = false;
        } else if (obstacleLength < movePower) {
            System.out.println(name + " проходит растояние " + (BigDecimal.valueOf(obstacleLength).setScale(2, BigDecimal.ROUND_CEILING)) + " м.");
        } else if (obstacleLength == movePower) {
            System.out.println(name + " полность проходит растояние " + (BigDecimal.valueOf(obstacleLength).setScale(2, BigDecimal.ROUND_CEILING)) + " м. и останавливается из-за разряда батареи");
            this.canMove = false;
        } else {
            System.out.println(name + " проходит растояние " + (BigDecimal.valueOf(movePower).setScale(2, BigDecimal.ROUND_CEILING)) + " м. и останавливается из-за разряда батареи");
            this.canMove = false;
        }
    }

    public void jump(Double obstacleHeight) {
        if (movePower <= 0) {
            System.out.println(name + " не может дальше двигаться из-за разряда батареи");
            this.canMove = false;
        } else if (obstacleHeight <= jumpPower && movePower >= Wall.length) {
            movePower = movePower - Wall.length;
            System.out.println(name + " переступает через препятствие высотой " + BigDecimal.valueOf(obstacleHeight).setScale(2, BigDecimal.ROUND_CEILING) + " м.");
        } else if (obstacleHeight > jumpPower) {
            System.out.println(name + " не смог перешагнуть препятствие, препятствие слишком высокое");
            this.canMove = false;
        } else if (movePower < 0.1) {
            System.out.println(name + " не смог перешагнуть препятствие, закончилась энергия");
            this.canMove = false;
        }
    }
}