package paint.service;

import java.sql.SQLException;
import paint.dao.ShapeDaoImpl;
import paint.entity.Shape;
import paint.entity.ShapeType;

public class CreateCommand implements Command {

    private ShapeType shapeType;

    private String name;

    private Shape shape;

    public CreateCommand(ShapeType shapeType, String name, Shape shape) {
        this.shapeType = shapeType;
        this.name = name;
        this.shape = shape;
    }

    @Override public String execute() {
        shape.setName(name);
        shape.setType(shapeType.getCode());
        try {
            ShapeDaoImpl.getInstance().insert(shape);
        } catch (SQLException e) {
            return "Create failed";
        }
        return "Create Success";
    }
}
