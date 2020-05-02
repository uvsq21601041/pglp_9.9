package paint;

import java.util.ArrayList;
import java.util.List;
import paint.entity.Cercle;
import paint.entity.Descarre;
import paint.entity.MoveEntity;
import paint.entity.Rectangle;
import paint.entity.Shape;
import paint.entity.ShapeType;
import paint.entity.Triangle;
import paint.service.Command;
import paint.service.CreateCommand;
import paint.service.MoveCommand;
import paint.service.ShowCommand;

public class DrawingTUI {
    public Command nextCommand(String input) throws IllegalArgumentException {
        // check input
        Command command = null;
        if (input.startsWith("move")) {
            String[] data = input.split(" ");
            List<MoveEntity> list = new ArrayList<>();
            for (int i = 1; i < data.length; i++) {
                String inputData = data[i];
                inputData = inputData.replace("(", "");
                inputData = inputData.replace(")", "");
                inputData = inputData.trim();
                String[] subData = inputData.split(",");
                MoveEntity entity =
                    new MoveEntity(subData[0], Integer.parseInt(subData[1]), Integer.parseInt(subData[2]));
                list.add(entity);
            }
            command = new MoveCommand(list);
        } else if (input.startsWith("show")) {
            String name = input.substring(5).trim();
            command = new ShowCommand(name);
        } else {
            String[] data = input.split("=");
            if (data.length == 2) {
                String name = data[0].trim();
                String value = data[1].trim();
                Shape shape = null;
                ShapeType shapeType = ShapeType.Cercle;
                if (value.startsWith("Cercle")) {
                    value = value.substring(6).replace("(", "");
                    value = value.replace(")", "");
                    value = value.trim();
                    String[] cercleData = value.split(",");
                    shape = new Cercle(Integer.parseInt(cercleData[0]), Integer.parseInt(cercleData[1]),
                        Integer.parseInt(cercleData[2]));
                } else if (value.startsWith("Rectangle")) {
                    value = value.substring(9).replace("(", "");
                    value = value.replace(")", "");
                    value = value.trim();
                    String[] rectData = value.split(",");
                    shape = new Rectangle(Integer.parseInt(rectData[0]), Integer.parseInt(rectData[1]),
                        Integer.parseInt(rectData[2]), Integer.parseInt(rectData[3]));
                    shapeType = ShapeType.Rectangle;
                } else if (value.startsWith("DesCarre")) {
                    value = value.substring(8).replace("(", "");
                    value = value.replace(")", "");
                    value = value.trim();
                    String[] desData = value.split(",");
                    shape = new Descarre(Integer.parseInt(desData[0]), Integer.parseInt(desData[1]),
                        Integer.parseInt(desData[2]));
                    shapeType = ShapeType.DesCarre;
                } else if (value.startsWith("Triangle")) {
                    value = value.substring(8).replace("(", "");
                    value = value.replace(")", "");
                    value = value.trim();
                    String[] desData = value.split(",");
                    shape = new Triangle(Integer.parseInt(desData[0]), Integer.parseInt(desData[1]),
                        Integer.parseInt(desData[2]), Integer.parseInt(desData[3]), Integer.parseInt(desData[4]),
                        Integer.parseInt(desData[5]));
                    shapeType = ShapeType.Triangle;
                }
                command = new CreateCommand(shapeType, name, shape);
            }
        }

        return command;
    }
}
