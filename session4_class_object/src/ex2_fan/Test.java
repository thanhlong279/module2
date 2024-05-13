package ex2_fan;

public class Test {
    private static final int MEDIUM = 3;
    private static final int FAST = 1;
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(FAST);
        fan1.setColor("yellow");
        fan1.setRadius(10);
        fan1.setOn(true);

        Fan fan2 = new Fan();
        fan2.setSpeed(MEDIUM);
        fan2.setColor("blue");
        fan2.setRadius(5);
        fan2.setOn(false);

        System.out.println("Fan 1: " + fan1.toString());
        System.out.println("Fan 2: " + fan2.toString());

    }
}
