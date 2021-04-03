package view;

import controller.CarShopController;
import model.vo.CarShop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarShopView {

    private Scanner sc;
    private CarShopController csc;

    public CarShopView() {
        sc = new Scanner(System.in);
        csc = new CarShopController();
    }

    public void mainMenu() throws SQLException, IOException, ClassNotFoundException {
        printMenu();
        EXIT:
        while(true) {
            switch (inputMenu()) {
                case 1 : //전체 계약서 보기
                    csc.selectList();
                    break;
                case 2 : //계약서 작성
                    csc.insert();
                    break;
                case 3 : // 계약서 수정
                    break;
                case 4 : //계약서 삭제
                    break;
                case 5 :
                    System.out.println("BYE");
                    break EXIT;
                default:
                    System.out.println("다시 입력");
                    break;
            }
        }
    }

    public ArrayList<String> insert() {
        ArrayList<String> list = new ArrayList<>();

        System.out.println("===== 계약서 작성 부분 입니다. =====");
        System.out.print("성함 >>");
        list.add(sc.nextLine());

        System.out.print("주민번호 >>");
        list.add(sc.nextLine());

        System.out.print("핸드폰 번호 >>");
        list.add(sc.nextLine());

        System.out.print("주소 >>");
        list.add(sc.nextLine());

        System.out.println("필수값 아닙니다. enter로 넘어가셔도 됩니다.");
        System.out.print("Email >> ");
        list.add(sc.nextLine());

        System.out.print("차 브랜드 >>");
        list.add(sc.nextLine());

        System.out.print("모델명 >>");
        list.add(sc.nextLine());

        System.out.print("타입 >>");
        list.add(sc.nextLine());

        System.out.print("기어 >>");
        list.add(sc.nextLine());

        System.out.print("색상 >>");
        list.add(sc.nextLine());

        System.out.print("문 개수 >>");
        String door_ = sc.nextLine();
        list.add(sc.nextLine());

        System.out.print("배기량 >>");
        list.add(sc.nextLine());

        System.out.print("연비 >>");
        list.add(sc.nextLine());

        System.out.print("가격 >>");
        list.add(sc.nextLine());
        return list;
    }
    public void printMenu() {
        System.out.println("====== 차량 계약서 ======");
        System.out.println("1. 계약서 전체 조회");
        System.out.println("2. 계약서 작성");
        System.out.println("3. 계약서 수정");
        System.out.println("4. 계약서 삭제");
        System.out.println("5. 종료");
    }

    public int inputMenu() {
        System.out.print(" >> ");
        String menu_ = sc.nextLine();
        int menu = Integer.parseInt(menu_);
        return menu;
    }

    //응답 화면

    public void displayNoData(String message) {
        System.out.println(message);
    }

    public void displayCarList(ArrayList<CarShop> list) {
        for (CarShop l: list) {
            System.out.println(l);
        }
    }
}
