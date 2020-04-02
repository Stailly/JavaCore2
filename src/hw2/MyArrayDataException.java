package hw2;

public class MyArrayDataException extends RuntimeException {
    int i;
    int j;

    public MyArrayDataException(int i, int j) {
        super("В ячейке [" + i + "],[" + j + "] находится тип отличный от int.");
        this.i = i;
        this.j = j;

    }
}
