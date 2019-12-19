package Lesson1;



public class Main {
    public static void main(String[] args) {

//        ObstaclesCourse.getInstance();
        Object[] members = new Object[3];
        members[0] = new Human("Чак Норрис", 2, 42195);
        members[1] = new Cat("Кот Бегемот", 2.5, 2000);
        members[2] = new Robot("R2-D2", 0.3, 1000);

        Race race = new Race(members, ObstaclesCourse.getInstance());
        race.doRace();



    }
}
