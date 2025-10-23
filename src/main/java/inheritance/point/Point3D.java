package ua.opnu.java.inheritance.bill;

/** 3D point that extends Point by adding z coordinate and 3D behavior. */
public class Point3D extends Point {
    private int z;

    public Point3D() {
        super(0, 0);
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    /** For 2D setLocation, z must reset to 0. */
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    public double distance(Point3D p) {
        long dx = (long) getX() - p.getX();
        long dy = (long) getY() - p.getY();
        long dz = (long) this.z - p.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceFromOrigin() {
        long dx = getX();
        long dy = getY();
        long dz = this.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}
