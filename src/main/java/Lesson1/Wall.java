package Lesson1;

public class Wall extends Obstacle {

    private double height;


    @Override
    public double getHeight() {
        return height;
    }

    public Wall(double height) {
        this.height = height;
    }
}
