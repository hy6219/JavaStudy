package common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),
												prop.getProperty("user"),
												prop.getProperty("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	public static void close(Connection conn) {
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
	
	try {
		if(rs != null) {
			rs.close();
		}
	} catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		
		try {
			if(conn != null) {
				conn.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void roleback(Connection conn) {
		
		try {
			if(conn != null) {
				conn.rollback();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
