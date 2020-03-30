package hw1;


import hw1.contestant.Cat;
import hw1.contestant.Contestant;
import hw1.contestant.Human;
import hw1.contestant.Robot;
import hw1.obstacle.Treadmill;
import hw1.obstacle.Wall;

import java.util.Random;

public class Test {
    private static final Random RND = new Random();

    public static void main(String[] args) {
        Team team = new Team( "Team1",
                new Cat("Муся", 120, 70),
                new Robot("c3po", 70, 110),
                new Human("Василий", 90, 90)
        );
        Course course = new Course(
                new Wall(RND.nextInt(100) + 20),
                new Treadmill(RND.nextInt(100) + 20)
        );
       course.doIt(team);
       team.printResult();
       team.printWinners();
    }
}
