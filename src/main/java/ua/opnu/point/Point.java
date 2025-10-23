package ua.opnu.point;

public class Point {

  public static void main(String[] args) {

    Point p = new Point();
    Point p1 = new Point(1, 2);
    Point p2 = new Point(new Point(3, 4));

    System.out.println(p.distance(p1));
    System.out.println(p1.distanceFromOrigin());
  }

  public int x, y;

  public Point() {
    this(0, 0);
  }

  public Point(int x, int y) {
    setX(x);
    setY(y);
  }

  public Point(Point p) {
    this.x = p.x;
    this.y = p.y;
  }

  public double distance(Point p) {
    return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
  }

  public double distanceFromOrigin() {
    return distance(new Point(0, 0));
  }


  public final int getX() {
    return this.x;
  }

  public final int getY() {
    return this.y;
  }

  public void setLocation(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "Point{" + "x=" + x + ", y=" + y + '}';
  }
}