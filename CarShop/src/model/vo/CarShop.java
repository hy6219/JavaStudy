package model.vo;

public class CarShop {
    private String userName;
    private String userSsn;
    private String userPhone;
    private String userAddress;
    private String userEmail;

    private String brand;
    private String model;
    private String type;
    private String gearType;
    private String color;
    private int door;
    private int cc;
    private int fuel;
    private int price;

    public CarShop(String username, String string, String userssn, String userphone, String useraddress, String useremail, String brand, String model, String type, String geartype, String color, int door, int cc, int fuel, int price) {}
    public CarShop(String userName, String userSsn, String userPhone, String userAddress, String userEmail, String brand, String model, String type, String gearType, String color, int door, int cc, int fuel, int price) {
        this.userName = userName;
        this.userSsn = userSsn;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSsn() {
        return userSsn;
    }

    public void setUserSsn(String userSsn) {
        this.userSsn = userSsn;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
        return "userName: " + userName +
                ", userSsn: " + userSsn +
                ", userPhone: " + userPhone +
                ", userAddress: " + userAddress +
                ", userEmail: " + userEmail +
                ", brand: " + brand +
                ", model: " + model +
                ", type: " + type +
                ", gearType: " + gearType +
                ", color: " + color +
                ", door: " + door +
                ", cc: " + cc +
                ", fuel: " + fuel +
                ", price: " + price;
    }
}

