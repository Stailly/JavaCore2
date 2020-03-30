package hw1;

import hw1.contestant.Contestant;

public class Team {
    private String name;
    private Contestant[] contestants;

    public Team(String name, Contestant... contestants) {
        this.name = name;
        this.contestants = contestants;
    }

    public Contestant[] getContestants() {
        return contestants;
    }
    void printResult() {
        System.out.println("Команда: " + name);
        for (Contestant contestant : contestants) {
            System.out.println("\t" + contestant.getName());
        }
        System.out.println("");
    }

    void printWinners() {
        System.out.println("Команда: " + name);
        System.out.println("Прошли дистанцию:");
        for (Contestant contestant : contestants) {
            if (contestant.isOnDistance()) {
                System.out.println("\t" + contestant.getName());
            }
        }
        System.out.println("");
    }
}
