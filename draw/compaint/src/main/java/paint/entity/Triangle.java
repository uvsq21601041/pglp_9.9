package paint.entity;

public class Triangle extends Shape {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Triangle(int x0, int y0, int x1, int y1, int x2, int y2) {
        setX(x0);
        setY(y0);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override public void convert() {
        setType(ShapeType.Triangle.getCode());
        String value = getX() + "," + getY() + "," + x1 + "," + y1 + "," + x2 + "," + y2;
        setValue(value);
    }

    @Override public void move(int x, int y) {
        int xDis = x - getX();
        int yDis = y - getY();
        setX(x);
        setY(y);
        this.x1 += xDis;
        this.y1 += yDis;
        this.x2 += xDis;
        this.y2 += yDis;
    }

    @Override public String toString() {
        return "Triangle {name=" + getName() + " (" + getX() + "," + getY() + ") (" + x1 + ", " + y1 + ") (" + getX2()
            + ", " + getY2() + ") }";
    }
}
