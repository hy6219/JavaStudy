package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/*
  * Driver 생성
  * Connection 생성
  * close() 생성
 */
public class JDBCTemplate {

    public static Connection getCon() throws IOException, ClassNotFoundException, SQLException {
        Connection con = null;

        Properties pro = new Properties();

        try {
            pro.load(new FileInputStream("resource/driver.properties"));
            Class.forName(pro.getProperty("driver"));
            con = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("userID"), pro.getProperty("passwd"));
        } catch (IOException | ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void close(Connection con) throws SQLException {
        try {
            if (con != null && !con.isClosed())
                con.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(Statement st) throws SQLException {
        try {
            if (st != null && !st.isClosed())
                st.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void commit(Connection con) {
        try {
            if (con != null && !con.isClosed())
                con.commit();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void rollback(Connection con) {
        try {
            if (con != null && !con.isClosed())
                con.rollback();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
