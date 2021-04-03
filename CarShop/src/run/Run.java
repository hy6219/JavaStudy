package run;

import view.CarShopView;

import java.io.IOException;
import java.sql.SQLException;

public class Run {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        new CarShopView().mainMenu();
    }
}
