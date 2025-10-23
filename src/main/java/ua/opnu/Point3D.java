package ua.opnu.point;

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

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;   // ВАЖЛИВО: 3D перетворюється на 2D → z = 0
    }

    public double distance(Point3D p) {
        long dx = this.getX() - p.getX();
        long dy = this.getY() - p.getY();
        long dz = this.z - p.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceFromOrigin() {
        long dx = this.getX();
        long dy = this.getY();
        long dz = this.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}
