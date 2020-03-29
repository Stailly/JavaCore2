package lesson1;

import java.util.Random;

public class Cat implements CanJump, CanRun {
    private String name;
    private int jumpHeight;
    private int runLenght;
    private static final Random RANDOM = new Random();

    public Cat (String name) {
        this.name = name;
        this.jumpHeight = RANDOM.nextInt(10) + 14;
        this.runLenght = RANDOM.nextInt(11) + 22;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", runLenght=" + runLenght +
                '}';
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
}
