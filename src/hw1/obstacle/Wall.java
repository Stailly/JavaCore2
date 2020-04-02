package hw1.obstacle;

import hw1.contestant.Contestant;

public class Wall extends Obstacle {
    public Wall(int size) {
        super(size);
    }

    @Override
    public void doIt(Contestant contestant) {
        contestant.jump(size);
    }
}
