class Car {
    String color;
    String gearType;
    int cntDoor;
    Car() {}
    Car(String color, String gearType, int cntDoor) {
        this.color = color;
        this.gearType = gearType;
        this.cntDoor = cntDoor;
    }
    public static void main(String[] args){
        Car c1 = new Car();
        c1.color = "black";
        c1.gearType = "manual";
        c1.cntDoor = 4;

        Car c2 = new Car("red", "auto", 4);
    }
}