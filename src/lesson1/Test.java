package lesson1;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Муся");
        Human human1 = new Human("Виктор");
        Robot robot1 = new Robot("C3PO");
        Wall wall1 = new Wall();
        Treadmill treadmill1 = new Treadmill();

        System.out.println(cat1);
        System.out.println(human1);
        System.out.println(robot1);
        System.out.println(wall1);
        System.out.println(treadmill1);
        System.out.println();
        System.out.println(cat1.jump(wall1));
        System.out.println(cat1.run(treadmill1));
        System.out.println(human1.jump(wall1));
        System.out.println(human1.run(treadmill1));
        System.out.println(robot1.jump(wall1));
        System.out.println(robot1.run(treadmill1));


    }
}
