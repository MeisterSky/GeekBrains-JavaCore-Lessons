package Lesson1;

public class Cat {

    private String name;

    private double jumpPower;

    private double stamina;

    public Cat(String name, double jumpPower, double stamina) {
        this.name = name;
        this.jumpPower = jumpPower;
        this.stamina = stamina;
    }

    public void run() {
        System.out.println(name + " бежит");
    }

    public void jump() {
        System.out.println(name + " прыгает");
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
}