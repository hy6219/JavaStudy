package controller;

import model.service.CarShopService;
import model.vo.CarShop;
import view.CarShopView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarShopController {
    public void selectList() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<CarShop> list = new CarShopService().selectList();

        if(list.isEmpty())
            new CarShopView().displayNoData("조회된 결과 없음");
        else
            new CarShopView().displayCarList(list);
    }

    public void insert() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> inputInsertlist = new CarShopView().insert();
        new CarShopService().insert(inputInsertlist);
    }
}
