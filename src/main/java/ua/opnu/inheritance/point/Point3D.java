package ua.opnu.inheritance.point; 

/**
 * Класс, который моделирует точку в трехмерном пространстве (x, y, z).
 */
public class Point3D extends Point {

    private int z;

    // ----------------------------------------------------------------
    // --- ИСПРАВЛЕНИЕ 1: Добавление конструктора по умолчанию (для test1, test5) ---
    // ----------------------------------------------------------------
    /**
     * Создает объект Point3D с координатами (0, 0, 0)
     */
    public Point3D() {
        this(0, 0, 0);
    }
    
    /**
     * Создает объект Point3D с координатами (x, y, z)
     * @param x координата по оси X
     * @param y координата по оси Y
     * @param z координата по оси Z
     */
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    /**
     * Создает объект Point3D с координатами (Point.x, Point.y, z)
     * @param p объект Point, из которого берутся x и y
     * @param z координата по оси Z
     */
    public Point3D(Point p, int z) {
        // Вызов Point(int x, int y). Предполагаем, что Point имеет геттеры getX/getY.
        super(p.getX(), p.getY()); 
        this.z = z;
    }
    
    // ---------------------------------------------------------------------------------------
    // --- ИСПРАВЛЕНИЕ 2: Добавление setLocation(int, int, int) (для test7, test8, test9, test10) ---
    // ---------------------------------------------------------------------------------------
    /**
     * Устанавливает новое расположение точки в 3D пространстве.
     * @param x новая координата x
     * @param y новая координата y
     * @param z новая координата z
     */
    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y); // Используем родительский метод для X и Y
        this.z = z;              // Устанавливаем Z
    }

    /**
     * Возвращает координату z
     * @return координата z
     */
    public int getZ() {
        return z;
    }

    /**
     * Устанавливает новую координату z
     * @param z новая координата z
     */
    public void setZ(int z) {
        this.z = z;
    }

    /**
     * Возвращает расстояние от начала координат (0, 0, 0) до точки (x, y, z)
     * @return расстояние
     */
    public double distanceFromOrigin() {
        // Формула: sqrt(x^2 + y^2 + z^2)
        return Math.sqrt(getX() * getX() + getY() * getY() + z * z);
    }
    
    /**
     * Возвращает расстояние от этой точки до другой точки (x, y, z)
     * @param p другая точка
     * @return расстояние
     */
    public double distance(Point3D p) {
        // Вычисляем разницу по всем трем осям
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        double dz = this.z - p.getZ();
        
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * Переопределяет метод equals
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        // Должна быть проверка на тип, чтобы избежать ClassCastException
        if (!(o instanceof Point3D)) {
            return false;
        }
        
        Point3D other = (Point3D) o;
        return this.z == other.z;
    }

    /**
     * Переопределяет метод toString
     */
    @Override
    public String toString() {
        // Используем метод toString родителя для (x, y)
        String s = super.toString(); 
        // Результат родителя: (x, y). Обрезаем последнюю скобку и добавляем ", z)"
        s = s.substring(0, s.length() - 1);
        return s + ", z=" + this.z + ")";
    }
}