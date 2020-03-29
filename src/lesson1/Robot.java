package lesson1;

import java.util.Random;

public class Robot implements CanJump, CanRun {
    private String name;
    private int jumpHeight;
    private int runLenght;
    private static final Random RANDOM = new Random();

    public Robot(String name) {
        this.name = name;
        this.jumpHeight = RANDOM.nextInt(38) + 3;
        this.runLenght = RANDOM.nextInt(5) + 11;
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
        return "Robot{" +
                "name='" + name + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", runLenght=" + runLenght +
                '}';
    }
}
