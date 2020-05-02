package paint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import paint.entity.Shape;

public class ShapeDaoImpl implements ShapeDao {

    /**
     * sql for CREATE_TABLE_SQL
     */
    private static final String CREATE_TABLE_SQL =
        "drop table DRAW if EXISTS ;create table DRAW(name varchar(255),type int,val varchar(255))";
    /**
     * sql for query all
     */
    private static final String QUERY_ALL_SQL = "select * from DRAW";
    /**
     * sql for query one property
     */
    private static final String QUERY_ONE_SQL = "select * from DRAW where name=?";

    /**
     * update sql
     */
    private static final String UPDATE_SQL = "update DRAW set val=? where name=?";

    /**
     * insert sql
     */
    private static final String INSERT_SQL = "insert into DRAW values (?,?,?)";

    private static ShapeDao instance;

    private ShapeDaoImpl() {
        Connection connection = null;
        try {
            connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE_SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ShapeDao getInstance() {
        if (instance == null) {
            instance = new ShapeDaoImpl();
        }
        return instance;
    }

    @Override public void insert(Shape shape) {
        Connection connection = null;
        try {
            connection = DBHelper.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_SQL);
            shape.convert();
            statement.setObject(1, shape.getName());
            statement.setObject(2, shape.getType());
            statement.setObject(3, shape.getValue());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override public Shape find(String name) {
        Connection connection = null;
        List<Shape> shapes = new ArrayList<>();
        try {
            connection = DBHelper.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(QUERY_ONE_SQL);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            shapes = convertToObject(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return shapes.size() > 0 ? shapes.get(0) : null;
    }

    @Override public List<Shape> findAll() {
        Connection connection = null;
        List<Shape> shapes = new ArrayList<>();
        try {
            connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL_SQL);
            shapes = convertToObject(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return shapes;
    }

    @Override public void update(Shape shape) throws SQLException {
        Connection connection = null;
        try {
            connection = DBHelper.getInstance().getConnection();
            shape.convert();
            PreparedStatement statement = connection.prepareStatement(UPDATE_SQL);
            statement.setObject(1, shape.getValue());
            statement.setObject(2, shape.getName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<Shape> convertToObject(ResultSet resultSet) throws SQLException {
        List<Shape> shapes = new ArrayList<>();
        while (resultSet.next()) {
            Shape tempShape = new Shape();
            tempShape.setName(resultSet.getString(1));
            tempShape.setType(resultSet.getInt(2));
            tempShape.setValue(resultSet.getString(3));
            shapes.add(tempShape.parse());
        }
        return shapes;
    }
}
