package Model.dao;

import static common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import Model.vo.CarShop;

public class CarShopDao {
	private Properties pro = new Properties();
	
	public CarShopDao() {
		try {
			pro.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
	
	public int insert(Connection conn, CarShop car) {
		int result = 0;
		String sql = pro.getProperty("insert");
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getUserSSN());
			pstmt.setString(2, car.getUserSSN());
			pstmt.setString(3, car.getUSerPHONE());
			pstmt.setString(4, car.getUSERADDRESS());
			pstmt.setString(5, car.getUSEREMAIL());
			pstmt.setString(6, car.getBRAND());
			pstmt.setString(7, car.getMODEL());
			pstmt.setString(8, car.getTYPE());
			pstmt.setString(9, car.getGEARTYPE());
			pstmt.setString(10, car.getCOLOR());
			pstmt.setInt(11, car.getDOOR());
			pstmt.setInt(12, car.getCC());
			pstmt.setInt(13, car.getFUEL());
			pstmt.setInt(14, car.getPRICE());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public int delete(Connection conn, String name) {
		int result = 0;
		String sql = pro.getProperty("delete");
		PreparedStatement pstmt = null;
		System.out.println("CarShopDao : " + name);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
			System.out.println("result : "+ result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}
		
	public int modifyer(Connection conn, CarShop car) {
		int result = 0;
		String sql = pro.getProperty("modifyer");
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getUserName());
			pstmt.setString(2, car.getUSerPHONE());
			pstmt.setString(3, car.getBRAND());
			pstmt.setString(4, car.getMODEL());
			pstmt.setString(5, car.getUSERADDRESS());
			pstmt.setString(6, car.getUSERADDRESS());
			pstmt.setString(7, car.getUSERADDRESS());
			pstmt.setString(8, car.getUSERADDRESS());
			pstmt.setString(9, car.getUSERADDRESS());
			pstmt.setString(10, car.getUSERADDRESS());
			pstmt.setString(11, car.getUSERADDRESS());
			pstmt.setString(12, car.getUSERADDRESS());
			pstmt.setString(13, car.getUSERADDRESS());
			pstmt.setString(14, car.getUserSSN());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}
	
	
	public ArrayList<CarShop> selectList(Connection conn){
		
		ArrayList<CarShop> list = new ArrayList<CarShop>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = pro.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new CarShop(rs.getString("UserName"),
							rs.getString("UserSSN"),
							rs.getString("USerPHONE"),
							rs.getString("USERADDRESS"),
							rs.getString("USEREMAIL"),
							rs.getString("BRAND"),
							rs.getString("MODEL"),
							rs.getString("TYPE"),
							rs.getString("GEARTYPE"),
							rs.getString("COLOR"),
							rs.getInt("DOOR"),
							rs.getInt("CC"),
							rs.getInt("FUEL"),
							rs.getInt("PRICE")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
}
