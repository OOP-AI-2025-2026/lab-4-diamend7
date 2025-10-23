package ua.opnu.inheritance.bill;

/** 2D point with int coordinates. */
public class Point {
    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        setLocation(x, y);
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public double distance(Point p) {
        long dx = (long) x - p.x;
        long dy = (long) y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distanceFromOrigin() {
        long dx = x;
        long dy = y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
