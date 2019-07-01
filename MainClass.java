/**
 * Задание:
 * 1. Необходимо написать два метода, которые делают следующее:
 * 1) Создают одномерный длинный массив;
 * 2) Заполняют этот массив единицами;
 * 3) Засекают время выполнения
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * 5) Проверяется время окончания метода System.currentTimeMillis();
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 *
 * Отличие первого метода от второго:
 * Первый просто бежит по массиву и вычисляет значения.
 * Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
 * */

package HW_5;

import java.util.Arrays;

public class MainClass {

    /* Point of entry */
    public static void main(String[] args) throws Exception {
        float[] array = new float[1000000];
        System.out.printf("One thread solves the problem for %d ms.\n", Multithreading.oneThread(array)); // 398 ms.
        System.out.printf("Two threads solves the problem for %d ms.\n", Multithreading.twoThreads(array)); // 219 ms.
    }
}

/**
 * Multithreading
 */
class Multithreading {

    /* The variable stores the time to run the calculation */
    private static long timeBefore;

    /**
     * The oneThread method calculates the formula in one thread (in the  thread main)
     *
     * @param array input array
     * @return time spent on the calculation, ms
     */
    static long oneThread(float[] array) {

        /* Array initialization */
        Arrays.fill(array, 1f);

        /* Notice the start time of the calculation */
        timeBefore = System.currentTimeMillis();

        /* Calculation */
        for (int i = 0, quantity = array.length; i < quantity; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        /* Return the result */
        return System.currentTimeMillis() - timeBefore;
    }

    /**
     * The twoThreads method calculates a formula in two threads.
     *
     * @param array input array
     * @return time spent on the calculation, ms
     */
    static long twoThreads(float[] array) throws Exception {
        int half = array.length / 2;
        float[] threadPart1 = new float[half];
        float[] threadPart2 = new float[half];

        /* Array initialization */
        Arrays.fill(array, 1f);

        /* Notice the start time of the calculation */
        timeBefore = System.currentTimeMillis();

        /* Notice the start time of the calculation */
        System.arraycopy(array, 0, threadPart1, 0, half);
        System.arraycopy(array, half, threadPart2, 0, half);

        /* Implementation threads */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                /* Calculation */
                for (int i = 0; i < half; i++) {
                    threadPart1[i] = (float) (threadPart1[i] * Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                /* Calculation */
                for (int i = 0; i < half; i++) {
                    threadPart2[i] = (float) (threadPart2[i] * Math.sin(0.2f + (i + half) / 5) *
                            Math.cos(0.2f + (i + half) / 5) * Math.cos(0.4f + (i + half) / 2));
                }
            }
        });

        /* Run the threads */
        thread1.start();
        thread2.start();

        /* Waiting for threads to complete */
        thread1.join();
        thread2.join();

        /* To collect arrays in one */
        System.arraycopy(threadPart1, 0, array, 0, half);
        System.arraycopy(threadPart2, 0, array, half, half);

        /* Return the result */
        return System.currentTimeMillis() - timeBefore;
    }
}