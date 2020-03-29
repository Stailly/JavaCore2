package lesson1;

import java.util.Random;

public class Human implements CanRun, CanJump {
    private String name;
    private int jumpHeight;
    private int runLenght;
    private static final Random RANDOM = new Random();

    public Human(String name) {
        this.name = name;
        this.jumpHeight = RANDOM.nextInt(11) + 25;
        this.runLenght = RANDOM.nextInt(27) + 12;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean jump(Wall wall) {
        System.out.print(name + " совершил(а) прыжок на высоту " + wall.wallHeight + ": ");
        return jumpHeight>= wall.wallHeight;
    }

    @Override
    public boolean run(Treadmill treadmill) {
        System.out.print(name + " пробежал(а) расстояние " + treadmill.distance + ": ");
        return runLenght>= treadmill.distance;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", runLenght=" + runLenght +
                '}';
    }
}
