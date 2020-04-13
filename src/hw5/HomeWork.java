package hw5;

import java.util.Arrays;

public class HomeWork {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        float[] newArr = new float[SIZE];
        Arrays.fill(arr, 1);
       useOneThread(arr);
       System.out.println(" ");
        Arrays.fill(newArr, 1);
        useTwoThread(newArr);
    }

    public static void useOneThread(float[] floats) {
        long a = System.currentTimeMillis();
        changeValues(floats);
        System.currentTimeMillis();
               System.out.println(System.currentTimeMillis() - a);
    }


    public static void useTwoThread (float[] floats){
        long a = System.currentTimeMillis();
        float[]arr1 = new float[HALF];
        float[]arr2 = new float[HALF];
        System.arraycopy(floats, 0, arr1, 0, HALF);
        System.arraycopy(floats, HALF, arr2, 0, HALF);

        new Thread(() -> changeValues(arr1)).start();
        new Thread(() -> changeValues(arr2)).start();

        System.arraycopy(arr1, 0, floats, 0, HALF);
        System.arraycopy(arr2, 0, floats, HALF, HALF);
        System.currentTimeMillis();

        System.out.println(System.currentTimeMillis() - a);
    }

    private static void changeValues(float[] floats) {
        for (int i = 0; i < floats.length; i++) {
            floats[i] = (float) (floats[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }


}
