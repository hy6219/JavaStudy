package Model.service;

import java.sql.Connection;
import java.util.ArrayList;

import Model.dao.CarShopDao;
import Model.vo.CarShop;

import static common.JDBCTemplate.*;

public class CarShopService {
	
	public ArrayList<CarShop> selectList(){
		
		Connection conn = getConnection();
		
		ArrayList<CarShop> arr = new CarShopDao().selectList(conn);
		
		close(conn);
		
		return arr;
	}
	
	public int delete(String SSN) {
		
		Connection conn = getConnection();
		System.out.println("CarShopService : " + SSN);
		int result = new CarShopDao().delete(conn , SSN);
		
		close(conn);
		
		return result;
		
	}
	
	public int insert(CarShop car){
		
		Connection conn = getConnection();
		int result = new CarShopDao().insert(conn, car);
		
		close(conn);
		
		return result;
		
	}
	
	public int modifyer(CarShop car) {
		
		Connection conn = getConnection();
		int result = new CarShopDao().modifyer(conn ,car);
		
		close(conn);
		
		return result;
		
	}
	
}
