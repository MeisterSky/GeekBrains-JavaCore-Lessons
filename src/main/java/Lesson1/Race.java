package Lesson1;

import java.util.ArrayList;

public class Race {

    private Object[] members;

    private Obstacles[] obstaclesCourses;

    public Race(Object[] members, Obstacles[] obstaclesCourses) {
        this.members = members;
        this.obstaclesCourses = obstaclesCourses;
    }

    public void doRace() {

        for (Object member : members) {

            System.out.println();

            if (canMove(member)) {

                if (member instanceof Human) {
                    for (int i = 0; i < obstaclesCourses.length; i++) {
                        if (canMove(member)) {
                            Obstacles obstacles = obstaclesCourses[i];
                            if (obstacles instanceof RunningTrack) {
                                ((Human) member).move(obstacles.getLength());
                            } else if (obstacles instanceof Wall) {
                                ((Human) member).jump(obstacles.getHeight());
                            } else {
                                System.out.println(member.toString() + " не может принимать далнейшее участие");
                                break;
                            }
                        } else {
                            System.out.println(member.toString() + " не может принимать далнейшее участие");
                            break;
                        }

                        if (i == obstaclesCourses.length - 1 && ((Human) member).isCanMove()) {
                            System.out.println(member.toString() + " достигает финиша");
                        }
                    }
                } else if (member instanceof Cat) {
                    for (int i = 0; i < obstaclesCourses.length; i++) {
                        Obstacles obstacles = obstaclesCourses[i];
                        if (canMove(member)) {
                            if (obstacles instanceof RunningTrack) {
                                ((Cat) member).move(obstacles.getLength());
                            } else if (obstacles instanceof Wall) {
                                ((Cat) member).jump(obstacles.getHeight());
                            } else {
                                System.out.println(member.toString() + " не может принимать далнейшее участие");
                                break;
                            }
                        } else {
                            System.out.println(member.toString() + " не может принимать далнейшее участие");
                            break;
                        }

                        if (i == obstaclesCourses.length - 1 && ((Cat) member).isCanMove()) {
                            System.out.println(member.toString() + " достигает финиша");
                        }
                    }
                } else if (member instanceof Robot) {
                    for (int i = 0; i < obstaclesCourses.length; i++) {
                        Obstacles obstacles = obstaclesCourses[i];
                        if (canMove(member)) {
                            if (obstacles instanceof RunningTrack) {
                                ((Robot) member).move(obstacles.getLength());
                            } else if (obstacles instanceof Wall) {
                                ((Robot) member).jump(obstacles.getHeight());
                            } else {
                                System.out.println(member.toString() + " не может принимать далнейшее участие");
                                break;
                            }
                        } else {
                            System.out.println(member.toString() + " не может принимать далнейшее участие");
                            break;
                        }

                        if (i == obstaclesCourses.length - 1 && ((Robot) member).isCanMove()) {
                            System.out.println(member.toString() + " достигает финиша");
                        }
                    }
                }

            } else {
                System.out.println(member.toString() + " не может принимать далнейшее участие");
                break;
            }
        }
    }

    private boolean canMove(Object object) {
        if (object instanceof Human) {
            return ((Human) object).isCanMove();
        } else if (object instanceof Cat) {
            return ((Cat) object).isCanMove();
        } else if (object instanceof Robot) {
            return ((Robot) object).isCanMove();
        } else {
            return false;
        }
    }
}
