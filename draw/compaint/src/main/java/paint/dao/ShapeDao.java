package paint.dao;

import java.sql.SQLException;
import java.util.List;
import paint.entity.Shape;

public interface ShapeDao {
    void insert(Shape shape) throws SQLException;

    Shape find(String name) throws SQLException;

    List<Shape> findAll() throws SQLException;

    void update(Shape shape) throws SQLException;
}
