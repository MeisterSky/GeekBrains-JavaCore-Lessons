package Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

class ObstaclesCourse {
    private static Obstacles[] ourInstance = null;

    public static Obstacles[] getInstance() {
        if (ourInstance == null) {
            createObstacleCourse();
        }
        return ourInstance;
    }

    private ObstaclesCourse() {
    }

    private static void createObstacleCourse() {

        double minLengthOfTrack = 100.00;

        double maxLengthOfTrack = 42000.0;

        double defaultLengthOfTrack = 100.0;

        double lengthOfTrack = defaultLengthOfTrack;

        double minHeightOfWall = 0.1;

        double maxHeightOfWall = 2.5;

        double defaultHeightOfWall = 0.1;

        double heightOfWall = defaultHeightOfWall;

        int defaultAmountOfObstacles = 1;

        int amountOfObstacles = defaultAmountOfObstacles;

        int numberOfObstacles = 1;

        Obstacles[] obstacles = new Obstacles[1];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            while (true) {
                System.out.println("Введите общую длину полосы препятствий от " + minLengthOfTrack + " до " + maxLengthOfTrack + " метров или нажмите \"Enter\" для установки значения по умолчанию (" + defaultLengthOfTrack + " м.)");
                String s = reader.readLine();
                if (s.equals("")) {
                    System.out.println("Задано значение по умолчанию: " + lengthOfTrack + " м.");
                    break;
                } else if (isDouble(s) && Double.parseDouble(s) >= minLengthOfTrack && Double.parseDouble(s) <= maxLengthOfTrack) {
                    lengthOfTrack = Double.parseDouble(s);
                    break;
                } else {
                    System.out.println("Введено некорректное значение. Пожалуйста, попробуйте, еще раз.");
                }
            }

            while (true) {
                System.out.println("Введите количество препятствий от 0 до " + ((int) (lengthOfTrack / 10) - 1) + " шт. или нажмите \"Enter\" для установки значения по умолчанию (" + defaultAmountOfObstacles + " шт.)");
                String s = reader.readLine();
                if (s.equals("")) {
                    System.out.println("Задано значение по умолчанию: " + defaultAmountOfObstacles + " шт.");
                    break;
                } else if (isInteger(s) && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= ((int) (lengthOfTrack / 10) - 1)) {
                    amountOfObstacles = Integer.parseInt(s);
                    break;
                } else {
                    System.out.println("Введено некорректное значение. Пожалуйста, попробуйте, еще раз.");
                }
            }

            if (amountOfObstacles > 0) {

                obstacles = new Obstacles[((amountOfObstacles * 2) + 1)];
                for (int i = 0; i < obstacles.length - 2; i++, numberOfObstacles++) {

                    obstacles[i] = new RunningTrack(lengthOfTrack / (amountOfObstacles + 1));

                    while (true) {
                        if (1 == amountOfObstacles) {
                            System.out.println("Введите высоту препятствия от " + minHeightOfWall + " до " + maxHeightOfWall + " метров или нажмите \"Enter\" для установки значения по умолчанию (" + defaultHeightOfWall + " м.)");
                        } else {
                            System.out.println("Введите высоту препятствия № " + numberOfObstacles + " от " + minHeightOfWall + " до " + maxHeightOfWall + " метров или нажмите \"Enter\" для установки значения по умолчанию (" + defaultHeightOfWall + " м.)");
                        }

                        String s = reader.readLine();
                        if (s.equals("")) {
                            System.out.println("Задано значение по умолчанию: " + defaultHeightOfWall + " м.");
                            break;
                        } else if (isDouble(s) && Double.parseDouble(s) >= minHeightOfWall && Double.parseDouble(s) <= maxHeightOfWall) {
                            heightOfWall = Double.parseDouble(s);
                            break;
                        } else {
                            System.out.println("Введено некорректное значение. Пожалуйста, попробуйте, еще раз.");
                        }
                    }

                    obstacles[++i] = new Wall(heightOfWall);
                }

                obstacles[obstacles.length - 1] = new RunningTrack(lengthOfTrack - ((lengthOfTrack / (amountOfObstacles + 1)) * amountOfObstacles) - (amountOfObstacles * Wall.length));

            } else {
                obstacles[0] = new RunningTrack(lengthOfTrack);
            }

        } catch (Exception e) {
            System.out.println("Ошибка! Пожалуйста, попробуйте, еще раз с самого начала.");
            createObstacleCourse();
        } finally {
            System.out.println();
            System.out.println("Полоса препятствий создана:");
            System.out.print("START ");
            for (Obstacles obstacle : obstacles) {
                if (obstacle instanceof RunningTrack) {
                    System.out.print("__ прямая длиной " + (BigDecimal.valueOf(obstacle.getLength()).setScale(2, BigDecimal.ROUND_CEILING)) + " м. __");
                } else if (obstacle instanceof Wall) {
                    System.out.print("| стена высотой " + BigDecimal.valueOf(obstacle.getHeight()).setScale(2, BigDecimal.ROUND_CEILING) + " м. |");
                }
            }

            System.out.println(" FINISH");
            System.out.println();

            ourInstance = obstacles;

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

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

