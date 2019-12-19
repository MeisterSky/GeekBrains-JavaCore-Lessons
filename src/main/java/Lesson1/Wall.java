package Lesson1;

public class Wall extends Obstacles {

    private double height;
    static double length = 0.1;

    @Override
    public double getHeight() {
        return height;
    }

    Wall(double height) {
        this.height = height;
    }
}
