package paint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static DBHelper instance = null;

    /**
     * private default constructor
     */
    private DBHelper() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the instance of DBHelper
     */
    public static synchronized DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    /**
     * get connection with db
     *
     * @return null if get error
     */
    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:drawdb;hsqldb.write_delay=false");
        return conn;
    }
}
