package hw2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Некорректный размер массива!");
    }
}
