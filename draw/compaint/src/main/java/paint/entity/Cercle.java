package paint.entity;

public class Cercle extends Shape {
    private int radius;

    public Cercle(int x, int y, int radius) {
        this.radius = radius;
        setX(x);
        setY(y);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override public void convert() {
        setType(ShapeType.Cercle.getCode());
        String value = getX() + "," + getY() + "," + radius;
        setValue(value);
    }

    @Override public void move(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override public String toString() {
        return "Cercle {name=" + getName() + " (" + getX() + ", " + getY() + ") radius=" + radius + '}';
    }
}
