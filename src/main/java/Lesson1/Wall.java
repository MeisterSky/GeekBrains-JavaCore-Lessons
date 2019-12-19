package Lesson1;

public class Wall extends Obstacles {

    private double height;

    @Override
    public double getHeight() {
        return height;
    }

    public Wall(double height) {
        this.height = height;
    }
}
