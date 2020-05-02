package paint.entity;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override public void convert() {
        setType(ShapeType.Rectangle.getCode());
        String value = getX() + "," + getY() + "," + width + "," + height;
        setValue(value);
    }

    @Override public String toString() {
        return "Rectangle {name=" + getName() + " (" + getX() + ", " + getY() + ") width=" + width + ", height=" + height + '}';
    }

    @Override public void move(int x, int y) {
        setX(x);
        setY(y);
    }
}
