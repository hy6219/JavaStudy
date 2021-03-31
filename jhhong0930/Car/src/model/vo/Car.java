package model.vo;

public class Car {

    private String brand;    // 브랜드명
    private String model;    // 모델명
    private String type;     // 타입(세단, 쿠페, SUV)
    private String gearType; // 구동 방식(전륜, 후륜, 4륜)
    private String color;    // 색상
    private int door;        // 문 개수
    private int cc;          // 배기량
    private int fuel;        // 연비
    private int price;       // 가격

    public Car(){}

    public Car(String brand, String model, String type, String gearType, String color, int door, int cc, int fuel, int price) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.gearType = gearType;
        this.color = color;
        this.door = door;
        this.cc = cc;
        this.fuel = fuel;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "brand: " + brand + ", model: " + model + ", type: " + type
          +  ", gearType: " + gearType + ", color: " + color + ", door: " + door
          +  ", cc: " + cc + ", fuel: " + fuel + ", price: " + price;
    }
}
