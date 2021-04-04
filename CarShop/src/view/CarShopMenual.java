package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Model.dao.CarShopDao;
import Model.vo.CarShop;
import controller.CarShopController;

public class CarShopMenual {
	
	Scanner sc  = new Scanner(System.in);
	
	private CarShopController chc = new CarShopController();
	
	public void mainMenu() {
		while(true) {
			String delete = null;
			System.out.println("\n===== 차량 계약 프로그램 =====");
			System.out.println("1. 계약서 전체 조회");
			System.out.println("2. 계약서 추가");
			System.out.println("3. 계약서 수정");
			System.out.println("4. 계약서 삭제");
			System.out.println("5. 종료");
			System.out.println("메뉴 선택: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1 : 
				chc.selectList();
				break;
			case 2 :
				System.out.println("사용자의 이름을 입력해주세요 : ");
				String name = sc.nextLine();
				System.out.println("사용자의 주민등록 번호를 입력해주세요 : ");
				String snn = sc.nextLine();
				System.out.println("사용자의 전화번호를 입력해주세요 : ");
				String phone = sc.nextLine();
				System.out.println("사용자의 주소를 입력해주세요 : ");
				String address = sc.nextLine();
				System.out.println("사용자의 이메일을 입력해주세요 : ");
				String email = sc.nextLine();
				System.out.println("주문하실 차의 브랜드를 입력해주세요 : ");
				String brand = sc.nextLine();
				System.out.println("주문하실 차의 모델을 입력해주세요 : ");
				String model = sc.nextLine();
				System.out.println("주문하실 차의 타입을 입력해주세요 : ");
				String type = sc.nextLine();
				System.out.println("주문하실 차의 구동방식을 입력해주세요 : ");
				String gear = sc.nextLine();
				System.out.println("주문하실 차의 색상을 입력해주세요 : ");
				String color = sc.nextLine();
				System.out.println("주문하실 차의 문 갯수를 입력해주세요 : ");
				int door = Integer.parseInt(sc.nextLine());
				System.out.println("주문하실 차의 배기량을 입력해주세요 : ");
				int cc = Integer.parseInt(sc.nextLine());
				System.out.println("주문하실 차의 연비를 입력해주세요 : ");
				int fuel = Integer.parseInt(sc.nextLine());
				System.out.println("주문하실 차의 가격을 입력해주세요 : ");
				int price = Integer.parseInt(sc.nextLine());
				CarShop car = new CarShop(name, snn, phone, address, email, brand, model, type, gear, color, door, cc, fuel, price); 
				chc.insert(car);
				break;
			case 3 : 
				System.out.println("등록하신 주민등록 번호를 입력해주세요 : ");
				String snn1 = sc.nextLine();					
					System.out.println("수정하실 이름을 입력해주세요 : ");
					String name1 = sc.nextLine();
					System.out.println("수정하실 전화번호를 입력해주세요 : ");
					String phone1 = sc.nextLine();
					System.out.println("수정하실 주소를 입력해주세요 : ");
					String address1 = sc.nextLine();
					System.out.println("수정하실 이메일을 입력해주세요 : ");
					String email1 = sc.nextLine();
					System.out.println("수정하실 차의 브랜드를 입력해주세요 : ");
					String brand1 = sc.nextLine();
					System.out.println("수정하실 차의 모델을 입력해주세요 : ");
					String model1 = sc.nextLine();
					System.out.println("수정하실 차의 타입을 입력해주세요 : ");
					String type1 = sc.nextLine();
					System.out.println("수정하실 차의 구동방식을 입력해주세요 : ");
					String gear1 = sc.nextLine();
					System.out.println("수정하실 차의 색상을 입력해주세요 : ");
					String color1 = sc.nextLine();
					System.out.println("수정하실 차의 문 갯수를 입력해주세요 : ");
					int door1 = Integer.parseInt(sc.nextLine());
					System.out.println("수정하실 차의 배기량을 입력해주세요 : ");
					int cc1 = Integer.parseInt(sc.nextLine());
					System.out.println("수정하실 차의 연비를 입력해주세요 : ");
					int fuel1 = Integer.parseInt(sc.nextLine());
					System.out.println("수정하실 차의 가격을 입력해주세요 : ");
					int price1 = Integer.parseInt(sc.nextLine());
					CarShop car1 = new CarShop(name1, snn1, phone1, address1, email1, brand1, model1, type1, gear1, color1, door1, cc1, fuel1, price1); 
					chc.modifier(car1);
				break;
			case 4 : 
				System.out.println("입력하실 주민등록 번호를 입력해주세요.");
				delete = sc.nextLine();
				chc.delete(delete);
				break;
			case 5 : System.out.println("프로그램을 종료합니다.");
				return;
			default : System.out.println("잘못 선택하셨습니다 다시 선택헤 주세요!!"); break;
			}
		}
	}
	
	//응답화면
	public void displayNoDate(String mesage) {
		System.out.println("\n" + mesage);
	}
	
	public void displayCarList(ArrayList<CarShop> arr) {
		for(CarShop n : arr) {
			System.out.println(n);
		}
	}
	
	public void noDeleteCar(int result) {
		
		System.out.println(result + "개의 데이터가 삭제 됐습니다.");
	}
	
	public void DeleteCar(int result) {
		
		System.out.println(result + "개의 데이터가 삭제 됐습니다.");
	}
	
	public void noInsert(String mesage) {
		
		System.out.println("\n" + mesage);
	}
	
	public void insert(int result) {
		
		System.out.println(result + "개의 행이 삽입되었습니다.");
		
	}
	
	public void noModifyer(String mesage) {
		System.out.println("\n" + mesage);
	}
	
	public void Modifyer(int result) {
		System.out.println(result + "개의 행이 수정되었습니다.");
	}
	
	
}
