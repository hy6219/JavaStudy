package model.service;

import model.dao.CarDao;
import model.vo.Car;

import java.sql.Connection;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

public class CarService {

    public ArrayList<Car> selectList() {

        Connection conn = getConnection();

        ArrayList<Car> list = new CarDao().selectList(conn);

        close(conn);

        return list;

    }

    public ArrayList<Car> selectByBrand(String brand) {

        Connection conn = getConnection();

        ArrayList<Car> list = new CarDao().selectByBrand(conn, brand);

        close(conn);

        return list;

    }

    public ArrayList<Car> selectByModel(String model) {

        Connection conn = getConnection();

        ArrayList<Car> list = new CarDao().selectByModel(conn, model);

        close(conn);

        return list;

    }

    public int insertCar(Car c) {

        Connection conn = getConnection();

        int result = new CarDao().insertCar(conn, c);

        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }

        return result;

    }

    public int updateCar(Car c) {

        Connection conn = getConnection();

        int result = new CarDao().updateCar(conn, c);

        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }

        close(conn);

        return result;

    }

    public int deleteCar(String model) {

        Connection conn = getConnection();

        int result = new CarDao().deleteCar(conn, model);

        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }

        close(conn);

        return result;

    }

}
