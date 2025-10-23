package ua.opnu.java.inheritance.point; // Тот же пакет, что и у Point

/**
 * Расширяет класс Point, добавляя третью z-координату.
 */
public class Point3D extends Point {

    // 1. Дополнительное поле для хранения z-координаты
    private int z;

    /**
     * Создает точку с координатами (0,0,0)
     */
    public Point3D() {
        // 2. Вызываем конструктор родителя Point()
        super(); 
        // 3. Инициализируем z
        this.z = 0;
    }

    /**
     * Создает точку с заданными координатами (x,y,z)
     */
    public Point3D(int x, int y, int z) {
        // 2. Вызываем конструктор родителя Point(int x, int y)
        super(x, y); 
        // 3. Инициализируем z
        this.z = z;
    }

    /**
     * Возвращает координату z
     */
    public int getZ() {
        return this.z;
    }

    /**
     * Устанавливает новые координаты точки (x, y, z)
     */
    public void setLocation(int x, int y, int z) {
        // 1. Используем метод родителя для установки x и y
        super.setLocation(x, y);
        // 2. Устанавливаем z
        this.z = z;
    }

    /**
     * Возвращает расстояние от текущей точки до входиной точки p
     * с учетом всех трех координат.
     */
    public double distance(Point3D p) {
        // Используем геттеры родителя getX() и getY()
        int dx = super.getX() - p.getX();
        int dy = super.getY() - p.getY();
        int dz = this.z - p.getZ(); // Используем z из этого класса
        
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    // --- Переопределение методов ---

    /**
     * Переопределенный метод. 
     * Устанавливает новіе координаті точки (x, y), а z устанавливает в 0.
     */
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0; // По требованию задания
    }

    /**
     * Переопределенный метод. 
     * Возвращает расстояние от точки до начала координат (0,0,0).
     */
    @Override
    public double distanceFromOrigin() {
        int x = super.getX();
        int y = super.getY();
        // Используем this.z
        return Math.sqrt(x * x + y * y + this.z * this.z);
    }

    /**
     * Переопределенный метод. 
     * Возвращает строковое представление точки в формате (x, y, z).
     */
    @Override
    public String toString() {
        return "(" + super.getX() + ", " + super.getY() + ", " + this.z + ")";
    }
}
