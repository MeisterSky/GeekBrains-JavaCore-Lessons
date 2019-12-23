package Lesson2;

public class Main {
    public static void main(String[] args) {

        String[][] stringArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] symbolsArray = {{"1", "2", "3", "$"}, {"%", "^", "&", "*"}, {"(", ")", "!!", "!@"}, {"13", "14", "15", "16"}};
        String[][] twoByTwoArray = {{"1", "2"}, {"3", "4"}};

        try {

            System.out.println(arrayStringToIntConverter(stringArray));
            System.out.println(arrayStringToIntConverter(twoByTwoArray));
            System.out.println(arrayStringToIntConverter(symbolsArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());

        }
    }

    private static int arrayStringToIntConverter(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int sum = 0, i = 0, j = 0;
        int lengthArray = 4;

        try {

            if (array.length == lengthArray) {
                for (String[] arr : array) {
                    if (arr.length != lengthArray) throw new MyArraySizeException("Ошибка длины массива");
                }
            } else {
                throw new MyArraySizeException("Ошибка длины массива");
            }

            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array.length; j++) {
                    sum += Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException e) {

            throw new MyArrayDataException("Ошибка формата в ячейке №[" + i + "][" + j + "], в этой ячейке находится: " + "\"" + array[i][j] + "\"");
        }

        return sum;
    }
}