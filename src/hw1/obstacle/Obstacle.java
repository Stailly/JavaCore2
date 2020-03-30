package hw1.obstacle;

import hw1.contestant.Contestant;

public abstract class Obstacle {
    int size;

    public Obstacle(int size) {
        this.size = size;
    }

    public abstract void doIt (Contestant contestant);
}
