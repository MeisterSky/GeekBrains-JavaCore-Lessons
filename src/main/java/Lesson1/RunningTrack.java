package Lesson1;

public class RunningTrack extends Obstacles {

    private double length;

    @Override
    public double getLength() {
        return length;
    }

    public RunningTrack(double length) {
        this.length = length;
    }
}