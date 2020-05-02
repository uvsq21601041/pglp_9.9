package paint.entity;

public class Descarre extends Rectangle {

    public Descarre(int x, int y, int length) {
        super(x, y, length, length);
    }

    @Override public void convert() {
        setType(ShapeType.DesCarre.getCode());
        String value = getX() + "," + getY() + "," + getWidth();
        setValue(value);
    }

    @Override public String toString() {
        return "Descarre {name=" + getName() + " (" + getX() + ", " + getY() + ") width=" + getWidth() + '}';
    }
}
