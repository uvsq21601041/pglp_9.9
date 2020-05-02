package paint.dao;

import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import paint.entity.Cercle;
import paint.entity.Rectangle;
import paint.entity.Shape;

public class ShapeDaoImplTest {

    @Test
    public void testInsert() throws SQLException {
        Shape shape = new Cercle(0,0,50);
        ShapeDaoImpl.getInstance().insert(shape);
        List<Shape> shapes = ShapeDaoImpl.getInstance().findAll();
        System.out.println(shapes);
    }

    @Test
    public void testupdate() throws SQLException {
        Shape shape = new Rectangle(0,0,50,100);
        shape.setName("r1");
        ShapeDaoImpl.getInstance().insert(shape);
        Shape shape1 = ShapeDaoImpl.getInstance().find("r1");
        System.out.println(shape1);
        Rectangle rectangle = (Rectangle)shape1;
        rectangle.setWidth(100);
        ShapeDaoImpl.getInstance().update(rectangle);
        shape1 = ShapeDaoImpl.getInstance().find("r1");
        System.out.println(shape1);
    }
}
