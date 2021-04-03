package model.dao;

import model.vo.CarShop;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static common.JDBCTemplate.*;

public class CarShopDAO {

    private Properties pro = new Properties();

    public CarShopDAO() throws IOException {
        // xml파일 불러오기
        pro.loadFromXML(new FileInputStream("resource/query.xml"));
    }
    public ArrayList<CarShop> selectList(Connection con) throws SQLException, IOException {
        ArrayList<CarShop> list = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = pro.getProperty("selectList");
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();

            while(rs.next()) {
                list.add(new CarShop(rs.getString("USERNAME"),
                                     rs.getString("USERNAME"),
                                     rs.getString("USERSSN"),
                                     rs.getString("USERPHONE"),
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
                                     rs.getInt("PRICE")
                                     ));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        } finally {
            close(rs);
            close(st);
        }

        return list;
    }

    public void insert(Connection con, ArrayList<String> list) {
        String userName = list.get(0).toString();
        String userSsn  = list.get(1).toString();
        String userPhone  = list.get(2).toString();
        String userAddr  = list.get(3).toString();
        String userEmail = list.get(4).toString();
        String brand = list.get(5).toString();
        String model = list.get(6).toString();
        String type = list.get(7).toString();
        String gearType = list.get(8).toString();
        String color = list.get(9).toString();
        int door = Integer.parseInt(list.get(10).toString());
        int cc = Integer.parseInt(list.get(11).toString());
        int fuel = Integer.parseInt(list.get(12).toString());
        int price = Integer.parseInt(list.get(13).toString());

        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = pro.getProperty("insert");
        try {
            st = con.prepareStatement(sql);
            st.setString(1,userName);
            st.setString(2,userSsn);
            st.setString(3,userPhone);
            st.setString(4,userAddr);
            st.setString(5,userEmail);
            st.setString(6,brand);
            st.setString(7,model);
            st.setString(8,type);
            st.setString(9,gearType);
            st.setString(10,color);
            st.setInt(11,door);
            st.setInt(12,cc);
            st.setInt(13,fuel);
            st.setInt(14,price);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
