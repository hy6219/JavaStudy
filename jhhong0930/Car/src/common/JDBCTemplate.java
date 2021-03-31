package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection() {

        Connection conn = null;

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("Car/resources/driver.properties"));
            Class.forName(prop.getProperty("driver"));
            conn = DriverManager.getConnection(prop.getProperty("url"),
                                               prop.getProperty("username"),
                                               prop.getProperty("password"));

        } catch(IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }

    public static void close(Connection conn) {

        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void close(Statement stmt) {

        try {
            if(stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void close(ResultSet rset) {

        try {
            if(rset != null && !rset.isClosed()) {
                rset.close();
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void commit(Connection conn) {

        try {
            if(conn != null && !conn.isClosed()) {
                conn.commit();
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void rollback(Connection conn) {

        try {
            if(conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
