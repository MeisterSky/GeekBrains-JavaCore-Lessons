package Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        createObstacleCourse();


    }

    private static void createObstacleCourse() {

        double lengthOfTrack = 100.0, heightOfWall = 0.5;

        int amountOfObstacles = 1, numberOfObstacles = 0;

        Obstacle[] obstacleCourse = new Obstacle[1];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            while (true) {
                System.out.println("Введите общую длину полосы препятствий от 100 до 1000 метров или нажмите Enter для установки значения по умолчанию (" + lengthOfTrack + " м.)");
                String s = reader.readLine();
                if (s.equals("")) {
                    break;
                } else if (isDouble(s) && Double.parseDouble(s) >= 100 && Double.parseDouble(s) <= 1000) {
                    lengthOfTrack = Double.parseDouble(s);
                    break;
                } else {
                    System.out.println("Введено некорректное значение. Пожалуйста, попробуйте, еще раз.");
                }
            }

            System.out.println("Введите количество препятствий от 0 до " + ((int) (lengthOfTrack / 10) - 1));

            amountOfObstacles = Integer.parseInt(reader.readLine());
            // TODO: 18.12.2019 Добавить проверку

            if (amountOfObstacles > 0) {

                obstacleCourse = new Obstacle[((amountOfObstacles * 2) + 1)];
                for (int i = 0; i < obstacleCourse.length - 2; i++) {

                    obstacleCourse[i] = new RunningTrack(lengthOfTrack / (amountOfObstacles + 1));

                    System.out.println("Введите высоту препятствия №" + ++numberOfObstacles + " от 0.5 до 2.5 метров");


                    heightOfWall = Double.parseDouble(reader.readLine());
                    // TODO: 18.12.2019 Добавить проверку


                    obstacleCourse[++i] = new Wall(heightOfWall);
                }
                obstacleCourse[obstacleCourse.length - 1] = new RunningTrack(lengthOfTrack - ((lengthOfTrack / (amountOfObstacles + 1)) * amountOfObstacles) - (amountOfObstacles * 0.1));
            } else {
                obstacleCourse[0] = new RunningTrack(lengthOfTrack);
            }
        } catch (Exception e) {
            System.out.println("Ошибка! Пожалуйста, попробуйте, еще раз с самого начала.");
            createObstacleCourse();
        } finally {
            System.out.println();
            System.out.println("Полоса препятствий создана:");
            System.out.print("START");
            for (Obstacle obstacles : obstacleCourse) {
                if (obstacles instanceof RunningTrack) {
                    System.out.print("__ прямая длиной " + (BigDecimal.valueOf(obstacles.getLength()).setScale(2, BigDecimal.ROUND_CEILING)) + " м. __");
                } else if (obstacles instanceof Wall) {
                    System.out.print("|стена высотой " + BigDecimal.valueOf(obstacles.getHeight()).setScale(2, BigDecimal.ROUND_CEILING) + " м. |");
                }
            }
            System.out.print("FINISH");
            System.out.println();
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