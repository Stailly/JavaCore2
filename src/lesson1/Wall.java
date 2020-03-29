package lesson1;

import java.util.Random;

public class Wall {
    public int wallHeight;
    private static final Random RANDOM = new Random();

    public Wall () {
        this.wallHeight = RANDOM.nextInt(40);
    }

    @Override
    public String toString() {
        return "Wall{" +
                "wallHeight=" + wallHeight +
                '}';
    }
}
