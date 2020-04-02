package hw1.obstacle;

import hw1.contestant.Contestant;

public class Treadmill extends Obstacle {
    public Treadmill(int size) {
        super(size);
    }

    @Override
    public void doIt(Contestant contestant) {
        contestant.run(size);
    }
}
