package ua.opnu.inheritance.point; 

public class Point3D extends Point {

    private int z;
    
    // --- Конструкторы (без изменений) ---
    public Point3D() {
        this(0, 0, 0);
    }
    
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(Point p, int z) {
        super(p.getX(), p.getY()); 
        this.z = z;
    }
    
    // --- Метод setLocation(int, int, int) (без изменений) ---
    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y); 
        this.z = z;              
    }
    
    // --- ПЕРЕОПРЕДЕЛЕНИЕ setLocation(int, int) для сброса Z в 0 (Task3 Fix) ---
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y); 
        this.z = 0;              // Сбрасываем Z в 0, как требуется тестами для 2D-операции
    }

    // ---------------------------------------------------------------------------------
    // --- НОВОЕ ИСПРАВЛЕНИЕ: Переопределение distance(Point) для 3D логики (Task3 Fix) ---
    // ---------------------------------------------------------------------------------
    /**
     * Переопределяет метод для вычисления 3D расстояния.
     * Корректно обрабатывает случай, когда p является Point (z=0) или Point3D (z=pz).
     */
    @Override
    public double distance(Point p) {
        double dx = this.getX() - p.getX();
        double dy = this.getY() - p.getY();
        
        int pz = 0;
        if (p instanceof Point3D) {
            // Если другая точка 3D, берем ее Z
            pz = ((Point3D) p).getZ();
        }
        
        double dz = this.getZ() - pz;
        
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
    
    // --- distance(Point3D p) оставляем, как есть, он вызывает distance(Point p)
    // --- или, если он нужен тестам явно, убедимся, что он вызывает переопределенный
    public double distance(Point3D p) {
        return this.distance((Point)p); // Вызываем наш новый 3D-метод
    }
    
    public double distanceFromOrigin() {
        // Используем 3D-формулу
        return Math.sqrt((long) getX() * getX() + (long) getY() * getY() + (long) z * z);
    }

    // --- Геттеры/Сеттеры/ToString/Equals (без изменений) ---
    public int getZ() { return z; }
    public void setZ(int z) { this.z = z; }
    
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Point3D)) return false;
        Point3D other = (Point3D) o;
        return this.z == other.z;
    }

    @Override
    public String toString() {
        String s = super.toString(); 
        s = s.substring(0, s.length() - 1);
        return s + ", z=" + this.z + ")";
    }
}