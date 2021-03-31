package model.dao;

import model.vo.Car;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static common.JDBCTemplate.*;

public class CarDao {

    private Properties prop = new Properties();

    public CarDao() {
        try {
            prop.loadFromXML(new FileInputStream("Car/resources/query.xml"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Car> selectList(Connection conn) {

        ArrayList<Car> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String sql = prop.getProperty("selectList");

        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();

            while(rset.next()) {
                list.add(new Car(rset.getString("BRAND"),
                        rset.getString("MODEL"),
                        rset.getString("TYPE"),
                        rset.getString("GEARTYPE"),
                        rset.getString("COLOR"),
                        rset.getInt("DOOR"),
                        rset.getInt("CC"),
                        rset.getInt("FUEL"),
                        rset.getInt("PRICE")));
            }

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return list;

    }

    public ArrayList<Car> selectByBrand(Connection conn, String brand) {

        ArrayList<Car> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectByBrand");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + brand + "%");
            rset = pstmt.executeQuery();

            while(rset.next()) {
                list.add(new Car(rset.getString("BRAND"),
                        rset.getString("MODEL"),
                        rset.getString("TYPE"),
                        rset.getString("GEARTYPE"),
                        rset.getString("COLOR"),
                        rset.getInt("DOOR"),
                        rset.getInt("CC"),
                        rset.getInt("FUEL"),
                        rset.getInt("PRICE")));
            }

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return list;

    }

    public ArrayList<Car> selectByModel(Connection conn, String model) {

        ArrayList<Car> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectByModel");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + model + "%");
            rset = pstmt.executeQuery();

            while(rset.next()) {
                list.add(new Car(rset.getString("BRAND"),
                                 rset.getString("MODEL"),
                                 rset.getString("TYPE"),
                                 rset.getString("GEARTYPE"),
                                 rset.getString("COLOR"),
                                 rset.getInt("DOOR"),
                                 rset.getInt("CC"),
                                 rset.getInt("FUEL"),
                                 rset.getInt("PRICE")));
            }

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return list;

    }

    public int insertCar(Connection conn, Car c) {

        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertCar");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getBrand());
            pstmt.setString(2, c.getModel());
            pstmt.setString(3, c.getType());
            pstmt.setString(4, c.getGearType());
            pstmt.setString(5, c.getColor());
            pstmt.setInt(6, c.getDoor());
            pstmt.setInt(7, c.getCc());
            pstmt.setInt(8, c.getFuel());
            pstmt.setInt(9, c.getPrice());

            result = pstmt.executeUpdate();

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;

    }

    public int updateCar(Connection conn, Car c) {

        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("updateCar");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getModel());
            pstmt.setString(2, c.getType());
            pstmt.setString(3, c.getGearType());
            pstmt.setString(4, c.getColor());
            pstmt.setInt(5, c.getDoor());
            pstmt.setInt(6, c.getCc());
            pstmt.setInt(7, c.getFuel());
            pstmt.setInt(8, c.getPrice());
            pstmt.setString(9, c.getBrand());

            result = pstmt.executeUpdate();

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;

    }

    public int deleteCar(Connection conn, String model) {

        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteCar");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, model);
            result = pstmt.executeUpdate();

        } catch(SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;

    }

}
