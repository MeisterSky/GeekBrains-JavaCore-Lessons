package Lesson1;

import java.math.BigDecimal;

public class Cat {

    private String name;

    private double jumpPower;

    private double stamina;

    private boolean canMove;


    public Cat(String name, double jumpPower, double stamina) {
        this.name = "Объект \"" + name + "\"";
        this.jumpPower = jumpPower;
        this.stamina = stamina;
        if (stamina > 0) {
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

    public double getStamina() {
        return stamina;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void move(Double obstacleLength) {
        if (stamina <= 0) {
            System.out.println(name + " не может бежать дальше из-за усталости и истощения");
            this.canMove = false;
        } else if (obstacleLength < stamina) {
            System.out.println(name + " пробегает растояние " + (BigDecimal.valueOf(obstacleLength).setScale(2, BigDecimal.ROUND_CEILING)) + " м.");
            stamina = stamina - obstacleLength;
        } else if (obstacleLength == stamina) {
            System.out.println(name + " полность пробегает растояние " + (BigDecimal.valueOf(obstacleLength).setScale(2, BigDecimal.ROUND_CEILING)) + " м. и останавливается из-за усталости и истощения");
            stamina = stamina - obstacleLength;
            this.canMove = false;
        } else {
            System.out.println(name + " пробегает растояние " + (BigDecimal.valueOf(stamina).setScale(2, BigDecimal.ROUND_CEILING)) + " м. и останавливается из-за усталости и истощения");
            stamina = 0.0;
            this.canMove = false;
        }
    }

    public void jump(Double obstacleHeight) {
        if (stamina <= 0) {
            System.out.println(name + " не может прыгать из-за усталости и истощения");
            this.canMove = false;
        } else if (obstacleHeight <= jumpPower && stamina >= Wall.length) {
            System.out.println(name + " перепрыгивает через препятствие высотой " + BigDecimal.valueOf(obstacleHeight).setScale(2, BigDecimal.ROUND_CEILING) + " м.");
            stamina = stamina - Wall.length;
            jumpPower = jumpPower - 0.1;
        } else if (obstacleHeight > jumpPower) {
            System.out.println(name + " не смог перепрыгнуть препятствие, либо препятствие слишком высокое, либо из-за усталости и истощения");
            this.canMove = false;
        } else if (stamina < 0.1) {
            System.out.println(name + " не смог перепрыгнуть препятствие из-за усталости и истощения");
            this.canMove = false;
        }
    }
}