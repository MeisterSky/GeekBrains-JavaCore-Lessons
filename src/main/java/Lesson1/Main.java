package Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        createObstacleCourse();


    }

    private static void createObstacleCourse() {

        double lengthOfTrack = 100.0, heightOfWall = 0.5;

        int amountOfObstacles = 9, numberOfObstacles = 0;

        Obstacle[] obstacleCourse = new Obstacle[1];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            System.out.println("Введите длину дорожки от 100 до 1000 метров");

            lengthOfTrack = Double.parseDouble(reader.readLine());
            // TODO: 18.12.2019 Добавить проверку

            System.out.println("Введите количество препятствий от 0 до " + ((int) (lengthOfTrack / 10) - 1));

            amountOfObstacles = Integer.parseInt(reader.readLine());
            // TODO: 18.12.2019 Добавить проверку

            if (amountOfObstacles > 0) {

                obstacleCourse = new Obstacle[((amountOfObstacles * 2) + 1)];
                for (int i = 0; i < obstacleCourse.length - 2; i++) {

                    obstacleCourse[i] = new RunningTrack(lengthOfTrack / obstacleCourse.length);

                    System.out.println("Введите высоту препятствия №" + ++numberOfObstacles + " от 0.5 до 2.5 метров");


                    heightOfWall = Double.parseDouble(reader.readLine());
                    // TODO: 18.12.2019 Добавить проверку


                    obstacleCourse[++i] = new Wall(heightOfWall);

                    obstacleCourse[obstacleCourse.length - 1] = new RunningTrack(lengthOfTrack - ((lengthOfTrack / obstacleCourse.length) * amountOfObstacles));
                }
            } else {
                obstacleCourse[0] = new RunningTrack(lengthOfTrack);
            }
        } catch (Exception e) {
            System.out.println("Введено некорректное значение. Пожалуйста, попробуйте, еще раз.");
            createObstacleCourse();
        } finally {
            numberOfObstacles = 0;
            for (Obstacle obstacles : obstacleCourse) {
                if (obstacles instanceof Wall) {
                    System.out.print("|" + obstacles.getHeight() + "|");
                } else if (obstacles instanceof RunningTrack) {
                    System.out.print("__" + obstacles.getLength() + "__");
                }
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}