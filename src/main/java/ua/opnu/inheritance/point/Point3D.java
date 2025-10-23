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
    // --- НОВОЕ ИСПРАВЛЕНИЕ: Переопределение setLocation(int, int) для сброса Z в 0 (для test6) ---
    // ---------------------------------------------------------------------------------------
    /**
     * Переопределяет 2D метод setLocation. 
     * Устанавливает новую локацию (x, y) и сбрасывает z в 0.
     */
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y); // Устанавливаем X и Y
        this.z = 0;              // Сбрасываем Z в 0
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
    
    // ... (остальные методы без изменений)

    /**
     * Возвращает координату z
     * @return координата z
     */
    public int getZ() {
        return z;
    }
    
    // ... (остальные методы)
    
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

    @Override
    public String toString() {
        // Используем метод toString родителя для (x, y)
        String s = super.toString(); 
        // Результат родителя: (x, y). Обрезаем последнюю скобку и добавляем ", z)"
        s = s.substring(0, s.length() - 1);
        return s + ", z=" + this.z + ")";
    }
}