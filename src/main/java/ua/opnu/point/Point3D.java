package ua.opnu.point;

public class Point3D extends Point {

  public static void main(String[] args) {

    Point3D p = new Point3D(1, 1, 1);

    p.setLocation(2, 2);

    System.out.println(p.getZ());

    System.out.println(p);
  }

  private int z;

  public Point3D() {
    this(0, 0, 0);
  }

  public Point3D(int x, int y, int z) {
    setX(x);
    setY(y);
    setZ(z);
  }

  private void setZ(int z) {
    this.z = z;
  }


  public int getZ() {
      return this.z;
  }

  @Override
  public void setLocation(int x, int y) {
    setX(x);
    setY(y);
    setZ(0);
  }

  public void setLocation(int x, int y, int z) {
    setX(x);
    setY(y);
    setZ(z);
  }

  public double distance(Point3D p) {
    return Math.sqrt(
        Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2) + Math.pow(this.z - p.z, 2));
  }

  @Override
  public String toString() {
    return "Point{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
  }

  @Override
  public double distanceFromOrigin() {
        return distance(new Point3D(0, 0, 0));
    }
}