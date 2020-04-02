package hw1.contestant;

import hw1.Jumper;
import hw1.Runner;

public abstract class Contestant implements Runner, Jumper {
    private String name;
    private int runLength;
    private int jumpHeight;
    private boolean onDistance;

    public Contestant(String name, int runLength, int jumpHeight) {
        this.name = name;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
        this.onDistance = true;
    }

    @Override
    public void run(int distance) {
        if (runLength >= distance) {
            printResult("пробежал", distance, true);
        } else {
            printResult("пробежал", distance, false);
            onDistance = false;
        }
    }

    @Override
    public void jump(int distance) {
        if (jumpHeight >= distance) {
            printResult("перепрыгнул", distance, true);
        } else {
            printResult("перепрыгнул", distance, false);
            onDistance = false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    private void printResult(String actionName, int distance, boolean result) {
        System.out.printf("%s %s%s %d%n",
                name,
                result ? "" : "не ",
                actionName,
                distance);
    }
}