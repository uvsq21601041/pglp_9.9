package paint.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import paint.dao.ShapeDaoImpl;
import paint.entity.MoveEntity;
import paint.entity.Shape;
import paint.entity.ShapeType;

public class MoveCommand implements Command {

    private List<MoveEntity> moveEntities;

    public MoveCommand(List<MoveEntity> moveEntities) {
        this.moveEntities = moveEntities;
    }

    @Override public String execute() {
        List<Shape> shapes = new ArrayList<>();
        String res = new String();
        try {
            for (MoveEntity entity : moveEntities) {
                String name = entity.getName();
                Shape shape = ShapeDaoImpl.getInstance().find(name);
                if (shape == null) {
                    return name + " not exists";
                } else {
                    String temp = String
                        .format("%s %s move from (%s) to (%s)\n", ShapeType.getByCode(shape.getType()).name(), name,
                            (shape.getX() + "," + shape.getY()), (entity.getX() + "," + entity.getY()));
                    shape.move(entity.getX(), entity.getY());
                    res += temp;
                    shapes.add(shape);
                }
            }
            for (Shape shape : shapes) {
                ShapeDaoImpl.getInstance().update(shape);
            }
        } catch (SQLException e) {
            return "Move failed";
        }

        return res + "Move Success";
    }
}
