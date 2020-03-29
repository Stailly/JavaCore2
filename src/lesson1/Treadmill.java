package lesson1;

import java.util.Random;

public class Treadmill {
    public int distance;
    private static final Random RANDOM = new Random();

    public Treadmill () {
        this.distance = RANDOM.nextInt(40);
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "distance=" + distance +
                '}';
    }
}
