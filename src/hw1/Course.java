package hw1;

import hw1.contestant.Contestant;
import hw1.obstacle.Obstacle;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt (Team team) {
        for (Contestant contestant : team.getContestants()) {
            for (Obstacle obstacle : obstacles) {
                if (!contestant.isOnDistance()) {
                    break;
                }
                obstacle.doIt(contestant);
            }
            System.out.printf("%s прошёл полосу препятствий: %b%n",
                    contestant.getName(),
                    contestant.isOnDistance());
        }
    }
}
