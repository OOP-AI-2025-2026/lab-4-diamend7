package ua.opnu.inheritance.point; // ИСПРАВЛЕННЫЙ ПАКЕТ

/**
 * Класс, который моделирует точку в трехмерном пространстве (x, y, z).
 */
public class Point3D extends Point {

    private int z;

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
        // Мы предполагаем, что Point имеет поля x и y,
        // доступные для наследующих классов (protected).
        // Если у Point нет public геттеров, используем поля напрямую.
        // Вызов Point(int x, int y)
        super(p.getX(), p.getY()); // В Javadoc Point3D конструктор принимал Point,
                                   // предполагаю, что Point имеет геттеры getX/getY.
                                   // Если это не так, замените на super(p.x, p.y);
        this.z = z;
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
        // Используем поля родителя (x и y) напрямую,
        // т.к. "super.x" и "super.y" не требуются, если они protected.
        // Если у родителя нет полей, используем getX/getY.
        // Я использую getX() и getY(), если они есть.
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
        // Результат родителя: (x, y). Нам нужно (x, y, z)
        // Обрезаем последнюю скобку и добавляем ", z)"
        s = s.substring(0, s.length() - 1);
        return s + ", z=" + this.z + ")";
    }
}