package ex2_fan;

public class Fan {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    // phương thức khởi tạo ko tham số, đối tượng fan mặc định
    public Fan() {
        speed = SLOW;
        on = false;
        radius = 5;
        color = "blue";
    }
    // các getter và setter cho các thuộc tính


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // phương thức toString
    public String toString() {
        if (on) {
            return "Fan is on. Speed: " + speed + ", Color: " + color + ", Radius: " + radius;
        } else {
            return "Fan is off. Color: " + color + ", Radius: " + radius;
        }
    }


}
