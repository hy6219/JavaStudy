package view;

import controller.CarController;
import model.vo.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class CarMenu {

    private Scanner sc = new Scanner(System.in);

    private CarController cct = new CarController();

    /**
     * 메인 메뉴
     */
    public void mainMenu() {

        while(true) {
            System.out.println("\n==== 차량 카탈로그 ====");
            System.out.println("1. 카탈로그 전체 조회");
            System.out.println("2. 브랜드별 검색");
            System.out.println("3. 모델명 검색");
            System.out.println("4. 차량 목록 추가");
            System.out.println("5. 차량 정보 변경");
            System.out.println("6. 차량 목록 삭제");
            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴 선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            switch(menu) {
                case 1: cct.selectList(); break;
                case 2: String brand = inputBrand();
                        cct.selectByBrand(brand);
                        break;
                case 3: String model = inputModel();
                        cct.selectByModel(model);
                        break;
                case 4: insertCar(); break;
                case 5: updateCar(); break;
                case 6: cct.deleteCar(inputModel()); break;
                case 0: System.out.println("프로그램을 종료합니다."); return;
                default: System.out.println("잘못 입력하셨습니다, 다시 입력해주세요."); break;
            }

        }

    }

    public void insertCar() {

        System.out.println("\n==== 차량 목록 추가 ====");

        System.out.print("브랜드명: ");
        String brand = sc.nextLine();

        System.out.print("모델명: ");
        String model = sc.nextLine();

        System.out.print("타입(세단, 쿠페, SUV): ");
        String type = sc.nextLine();

        System.out.print("구동 방식(전륜, 후륜, 4륜): ");
        String gearType = sc.nextLine();

        System.out.print("색상: ");
        String color = sc.nextLine();

        System.out.print("문 개수: ");
        String door = sc.nextLine();

        System.out.print("배기량: ");
        String cc = sc.nextLine();

        System.out.print("연비: ");
        String fuel = sc.nextLine();

        System.out.print("가격: ");
        String price = sc.nextLine();

        cct.insertCar(brand, model, type, gearType, color, door, cc, fuel, price);

    }

    /**
     * 사용자에게 브랜드명을 입력받은 후 반환하는 메소드
     */
    public String inputBrand() {
        System.out.print("\n브랜드명: ");
        return sc.nextLine();
    }

    /**
     * 사용자에게 모델명을 입력받은 후 반환하는 메소드
     */
    public String inputModel() {
        System.out.print("\n모델명: ");
        return sc.nextLine();
    }

    public void updateCar() {

        System.out.println("\n==== 차량 정보 변경 ====");

        String brand = inputBrand();

        System.out.print("변경할 모델명: ");
        String model = sc.nextLine();

        System.out.print("변경할 타입(세단, 쿠페, SUV): ");
        String type = sc.nextLine();

        System.out.print("변경할 구동 방식(전륜, 후륜, 4륜): ");
        String gearType = sc.nextLine();

        System.out.print("변경할 색상: ");
        String color = sc.nextLine();

        System.out.print("변경할 문 개수: ");
        String door = sc.nextLine();

        System.out.print("변경할 배기량: ");
        String cc = sc.nextLine();

        System.out.print("변경할 연비: ");
        String fuel = sc.nextLine();

        System.out.print("변경할 가격: ");
        String price = sc.nextLine();

        cct.updateCar(brand, model, type, gearType, color, door, cc, fuel, price);


    }

    /**
     * 응답 화면
     */
    public void displayNoData(String message) {
        System.out.println("\n" + message);
    }

    public void displayCarList(ArrayList<Car> list) {
        System.out.println("\n조회된 데이터는 다음과 같습니다: ");

        for(Car l : list) {
            System.out.println(l);
        }
    }

    public void displaySuccess(String message) {
        System.out.println("\n서비스 요청 성공: " + message);
    }

    public void displayFail(String message) {
        System.out.println("\n서비스 요청 실패: " + message);
    }

}
