package paint.entity;

/**
 * db entity
 */
public class Shape {
    private int x;

    private int y;

    private String name;

    private int type;

    private String value;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Shape parse() {
        ShapeType shapeType = ShapeType.getByCode(type);
        Shape shape = null;
        String[] data = value.split(",");
        if (shapeType == ShapeType.Cercle) {
            shape = new Cercle(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        } else if (shapeType == ShapeType.Rectangle) {
            shape = new Rectangle(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]),
                Integer.parseInt(data[3]));
        } else if (shapeType == ShapeType.DesCarre) {
            shape = new Descarre(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        } else {
            shape = new Triangle(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]),
                Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]));
        }
        shape.setName(name);
        shape.setValue(value);
        shape.setType(type);
        return shape;
    }

    public void convert() {

    }

    public void move(int x, int y) {

    }
}
