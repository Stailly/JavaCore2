package hw2;

public class hw2 {
    public static void main(String[] args) {
        String[][] array1 = new String[][]{
                {"8", "5", "3", "fdgsd"},
                {"2", "4", "8", "1"},
                {"5", "sdfsd", "7", "22"},
                {"36", "58", "fger", "55"}
        };

        String[][] array2 = new String[][]{
                {"8", "13", "25", "-20"},
                {"-32", "42", "18", "13"},
                {"50", "22", "-17", "4"},
                {"14", "-58", "3", "9"}
        };

        String[][] array3 = new String[4][2];

        checkArray(array1);
        checkArray(array2);
        checkArray(array3);
    }

    public static void checkArray (String[][] arrays) {
        try {
            changeArray(arrays);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void changeArray(String[][] arrays) {
        int sum = 0;
        if (arrays.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arrays[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(arrays[i][j]);
                } catch (RuntimeException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Cумма массива = " + sum);
    }
}
