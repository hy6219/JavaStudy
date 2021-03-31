package controller;

import model.service.CarService;
import model.vo.Car;
import view.CarMenu;

import java.util.ArrayList;

public class CarController {

    public void selectList() {

        ArrayList<Car> list = new CarService().selectList();

        if(list.isEmpty()) {
            new CarMenu().displayNoData("조회된 결과가 없습니다.");
        } else {
            new CarMenu().displayCarList(list);
        }

    }

    public void selectByBrand(String brand) {

        ArrayList<Car> list = new CarService().selectByBrand(brand);

        if(list.isEmpty()) {
            new CarMenu().displayNoData("조회된 결과가 없습니다.");
        } else {
            new CarMenu().displayCarList(list);
        }

    }

    public void selectByModel(String model) {

        ArrayList<Car> list = new CarService().selectByModel(model);

        if(list.isEmpty()) {
            new CarMenu().displayNoData("조회된 결과가 없습니다.");
        } else {
            new CarMenu().displayCarList(list);
        }

    }

    public void insertCar(String brand, String model, String type, String gearType,
                          String color, String door, String cc, String fuel, String price) {

        Car c = new Car(brand, model, type, gearType, color,
                        Integer.parseInt(door),
                        Integer.parseInt(cc),
                        Integer.parseInt(fuel),
                        Integer.parseInt(price));

        int result = new CarService().insertCar(c);

        if(result > 0) {
            new CarMenu().displaySuccess("성공적으로 차량이 추가되었습니다.");
        } else {
            new CarMenu().displayFail("차량 추가에 실패하였습니다.");
        }

    }

    public void updateCar(String brand, String model, String type, String gearType,
                          String color, String door, String cc, String fuel, String price) {

        Car c = new Car();
        c.setBrand(brand);
        c.setModel(model);
        c.setType(type);
        c.setGearType(gearType);
        c.setColor(color);
        c.setDoor(Integer.parseInt(door));
        c.setCc(Integer.parseInt(cc));
        c.setFuel(Integer.parseInt(fuel));
        c.setPrice(Integer.parseInt(price));

        int result = new CarService().updateCar(c);

        if(result > 0) {
            new CarMenu().displaySuccess("성공적으로 차량 정보가 변경되었습니다.");
        } else {
            new CarMenu().displayFail("차량 정보 변경에 실패하였습니다.");
        }

    }

    public void deleteCar(String model) {

        int result = new CarService().deleteCar(model);

        if(result > 0) {
            new CarMenu().displaySuccess("차량이 성공적으로 삭제되었습니다.");
        } else {
            new CarMenu().displayFail("차량 삭제에 실패하였습니다.");
        }

    }

}