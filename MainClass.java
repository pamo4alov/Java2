package HW_2_2;

import java.util.Arrays;

/*
1	Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2	Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3	В методе main() вызвать полученный метод, обработать возможные исключения
MySizeArrayException и MyArrayDataException и вывести результат расчета.
 */

public class MainClass {
    /* The correct size of the input matrix */
    private static final int SIZE = 4;

    /**
     * Returns the sum of the elements of an array..
     *
     * @param stringArray String[][]
     * @return int
     * @throws MyExceptions
     */
    private static int calcSum(String[][] stringArray) throws MyExceptions {
        if (stringArray[1].length > SIZE | stringArray.length > SIZE)
            throw new MyArraySizeException("The size of the matrix is too high");
        int sum = 0;
        int j = 0;
        while (j < SIZE) {
            int i = 0;
            while (i < SIZE) {
                try {
                    sum += Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Value Conversion Error \"" + stringArray[i][j] +
                            "\" by coordinates (" + (j + 1) + "," + (i + 1) + ") in number");
                }
                i++;
            }
            j++;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        // Option 1. A 4x4 matrix // no exceptions
        String[][] input = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};

        // Option 2. A 4х5 matrix // MyArraySizeException
        //String[][] input = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}, {"17", "18", "19", "20"}};

        // Option 3. A 4x4 matrix instead of a number // MyArrayDataException
        //String[][] input = new String[][]{{"1", "2", "3", "@"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};

        System.out.println("Input data:");
        for (String[] row : input) System.out.println(Arrays.toString(row));

        System.out.println("The result of the calculation of the amount: " + calcSum(input));
    }
}


