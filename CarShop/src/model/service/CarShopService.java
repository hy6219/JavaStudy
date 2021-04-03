package model.service;

import model.dao.CarShopDAO;
import model.vo.CarShop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static common.JDBCTemplate.*;

public class CarShopService {

    public ArrayList<CarShop> selectList() throws SQLException, IOException, ClassNotFoundException {
        Connection con  = getCon();

        ArrayList<CarShop> list = new CarShopDAO().selectList(con);

        close(con);
        return list;
    }

    public void insert(ArrayList<String> list) throws IOException, SQLException, ClassNotFoundException {
        Connection con = getCon();

        new CarShopDAO().insert(con, list);

        close(con);
    }
}
