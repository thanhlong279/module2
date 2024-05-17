package paractice1_geometry;

public class ComparebleCircle extends Circle implements Comparable<ComparebleCircle>{

    public ComparebleCircle() {
    }

    public ComparebleCircle(double radius) {
        super(radius);
    }

    public ComparebleCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparebleCircle o) {
        if(getRadius() > o.getRadius()) return 1;
        else if(getRadius() < o.getRadius()) return -1;
        return 0;
    }
}
