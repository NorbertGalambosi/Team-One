package DBUtils;

import java.sql.*;

/**
 * Created by Waiting on 22-May-17.
 */
public class DBConnection {
    protected Connection connection = null;

    public DBConnection() {
    }
    private Connection getNewConnection(){
        Connection con=null;
        try {
            Class.forName("org.sqlite.JDBC");
            con= DriverManager.getConnection("jdbc:sqlite:D:\\Facultate\\ISS\\Conferinta\\Team-One\\Conference\\db.db");
        } catch (SQLException e) {
            System.out.println("Error getting connection "+e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public Connection getConnection(){
        try {
            if (connection==null || connection.isClosed())
                connection=getNewConnection();

        } catch (SQLException e) {
            System.out.println("Error DB "+e);
        }
        return connection;
    }
}
