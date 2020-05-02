package paint.service;

import java.sql.SQLException;
import paint.dao.ShapeDaoImpl;
import paint.entity.Shape;

public class ShowCommand implements Command {

    private String name;

    public ShowCommand(String name) {
        this.name = name;
    }

    @Override public String execute() {
        try {
            Shape shape = ShapeDaoImpl.getInstance().find(name);
            if(shape == null){
                return name + " not exists";
            }else {
                return shape.toString();
            }
        } catch (SQLException e) {
            return "Show failed";
        }
    }
}
