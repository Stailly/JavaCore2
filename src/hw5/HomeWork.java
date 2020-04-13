package hw5;

import java.util.Arrays;

public class HomeWork {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[SIZE];
        float[] newArr = new float[SIZE];
        Arrays.fill(arr, 1);
        useOneThread(arr);
        System.out.println("");
        Arrays.fill(newArr, 1);
        useTwoThread(newArr);
        System.out.println(Arrays.equals(arr, newArr));
    }

    public static void useOneThread(float[] floats) {
        long a = System.currentTimeMillis();
        changeValues(floats, 0);
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);
    }


    public static void useTwoThread(float[] floats) throws InterruptedException {
        long a = System.currentTimeMillis();
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(floats, 0, arr1, 0, HALF);
        System.arraycopy(floats, HALF, arr2, 0, HALF);

        Thread thread1 = new Thread(() -> changeValues(arr1, 0));
        Thread thread2 = new Thread(() -> changeValues(arr2, HALF));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.arraycopy(arr1, 0, floats, 0, HALF);
        System.arraycopy(arr2, 0, floats, HALF, HALF);
        System.currentTimeMillis();

        System.out.println(System.currentTimeMillis() - a);
    }

    private static void changeValues(float[] floats, int newI) {
        for (int i = 0; i < floats.length; i++, newI++) {
            floats[i] = (float) (floats[i] * Math.sin(0.2f + newI / 5.0) * Math.cos(0.2f + newI / 5.0) * Math.cos(0.4f + newI / 2.0));
        }
    }
}
