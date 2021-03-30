package model.vo;

import model.dto.Option;
import model.dto.TypesOfVehicles;

import java.util.Scanner;

public class Menu {
    static boolean run = true;
    public void MainMenu() {

        while(run) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-------------");
            System.out.println("| Main Menu |");
            System.out.println("-------------");
            System.out.println("1. 계약서 작성");
            System.out.println("2. 차종 및 옵션 확인");
            System.out.println("3. QUIT");
            System.out.print(">> ");
            a(sc.nextInt());
        }
    }

    private void a (int num) {
        switch (num) {
            case 1:
                writeAgreement();
                break;
            case 2:
                Option.printOptionList();
                TypesOfVehicles.printTypesOfVehicles();
                break;
            case 3:
                System.out.println("bye");
                run = false;
                break;
            default:
                System.out.println("숫자를 잘못입력하셨습니다.");
                System.out.println("1 ~ 4 사이의 숫자를 입력해주세요.");
                break;
        }
    }

    private void printTypesOfVehicles() {

    }

    private void printOption() {

    }

    private void writeAgreement() {

    }


}
