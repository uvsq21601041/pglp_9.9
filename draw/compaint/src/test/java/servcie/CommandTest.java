package servcie;

import java.sql.SQLException;
import java.util.Arrays;
import org.junit.Test;
import paint.dao.ShapeDaoImpl;
import paint.entity.Cercle;
import paint.entity.MoveEntity;
import paint.entity.Rectangle;
import paint.entity.Shape;
import paint.entity.ShapeType;
import paint.service.Command;
import paint.service.CreateCommand;
import paint.service.MoveCommand;
import paint.service.ShowCommand;

public class CommandTest {

    @Test public void testCreate() throws SQLException {
        Rectangle rectangle = new Rectangle(0, 0, 100, 50);
        Command command = new CreateCommand(ShapeType.Rectangle, "r1", rectangle);
        command.execute();
        Shape shape = ShapeDaoImpl.getInstance().find("r1");
        System.out.println(shape);
    }

    @Test public void testMove() {
        Cercle circle = new Cercle(1, 1, 5);
        Command command = new CreateCommand(ShapeType.Cercle, "c1", circle);
        String res = command.execute();
        System.out.println(res);
        MoveEntity moveEntity = new MoveEntity("c1", 6, 6);
        command = new MoveCommand(Arrays.asList(moveEntity));
        res = command.execute();
        System.out.println(res);
        command = new ShowCommand("c1");
        res = command.execute();
        System.out.println(res);
    }

}
