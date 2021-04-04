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
			System.out.println("\n===== ���� ��� ���α׷� =====");
			System.out.println("1. ��༭ ��ü ��ȸ");
			System.out.println("2. ��༭ �߰�");
			System.out.println("3. ��༭ ����");
			System.out.println("4. ��༭ ����");
			System.out.println("5. ����");
			System.out.println("�޴� ����: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1 : 
				chc.selectList();
				break;
			case 2 :
				System.out.println("������� �̸��� �Է����ּ��� : ");
				String name = sc.nextLine();
				System.out.println("������� �ֹε�� ��ȣ�� �Է����ּ��� : ");
				String snn = sc.nextLine();
				System.out.println("������� ��ȭ��ȣ�� �Է����ּ��� : ");
				String phone = sc.nextLine();
				System.out.println("������� �ּҸ� �Է����ּ��� : ");
				String address = sc.nextLine();
				System.out.println("������� �̸����� �Է����ּ��� : ");
				String email = sc.nextLine();
				System.out.println("�ֹ��Ͻ� ���� �귣�带 �Է����ּ��� : ");
				String brand = sc.nextLine();
				System.out.println("�ֹ��Ͻ� ���� ���� �Է����ּ��� : ");
				String model = sc.nextLine();
				System.out.println("�ֹ��Ͻ� ���� Ÿ���� �Է����ּ��� : ");
				String type = sc.nextLine();
				System.out.println("�ֹ��Ͻ� ���� ��������� �Է����ּ��� : ");
				String gear = sc.nextLine();
				System.out.println("�ֹ��Ͻ� ���� ������ �Է����ּ��� : ");
				String color = sc.nextLine();
				System.out.println("�ֹ��Ͻ� ���� �� ������ �Է����ּ��� : ");
				int door = Integer.parseInt(sc.nextLine());
				System.out.println("�ֹ��Ͻ� ���� ��ⷮ�� �Է����ּ��� : ");
				int cc = Integer.parseInt(sc.nextLine());
				System.out.println("�ֹ��Ͻ� ���� ���� �Է����ּ��� : ");
				int fuel = Integer.parseInt(sc.nextLine());
				System.out.println("�ֹ��Ͻ� ���� ������ �Է����ּ��� : ");
				int price = Integer.parseInt(sc.nextLine());
				CarShop car = new CarShop(name, snn, phone, address, email, brand, model, type, gear, color, door, cc, fuel, price); 
				chc.insert(car);
				break;
			case 3 : 
				System.out.println("����Ͻ� �ֹε�� ��ȣ�� �Է����ּ��� : ");
				String snn1 = sc.nextLine();					
					System.out.println("�����Ͻ� �̸��� �Է����ּ��� : ");
					String name1 = sc.nextLine();
					System.out.println("�����Ͻ� ��ȭ��ȣ�� �Է����ּ��� : ");
					String phone1 = sc.nextLine();
					System.out.println("�����Ͻ� �ּҸ� �Է����ּ��� : ");
					String address1 = sc.nextLine();
					System.out.println("�����Ͻ� �̸����� �Է����ּ��� : ");
					String email1 = sc.nextLine();
					System.out.println("�����Ͻ� ���� �귣�带 �Է����ּ��� : ");
					String brand1 = sc.nextLine();
					System.out.println("�����Ͻ� ���� ���� �Է����ּ��� : ");
					String model1 = sc.nextLine();
					System.out.println("�����Ͻ� ���� Ÿ���� �Է����ּ��� : ");
					String type1 = sc.nextLine();
					System.out.println("�����Ͻ� ���� ��������� �Է����ּ��� : ");
					String gear1 = sc.nextLine();
					System.out.println("�����Ͻ� ���� ������ �Է����ּ��� : ");
					String color1 = sc.nextLine();
					System.out.println("�����Ͻ� ���� �� ������ �Է����ּ��� : ");
					int door1 = Integer.parseInt(sc.nextLine());
					System.out.println("�����Ͻ� ���� ��ⷮ�� �Է����ּ��� : ");
					int cc1 = Integer.parseInt(sc.nextLine());
					System.out.println("�����Ͻ� ���� ���� �Է����ּ��� : ");
					int fuel1 = Integer.parseInt(sc.nextLine());
					System.out.println("�����Ͻ� ���� ������ �Է����ּ��� : ");
					int price1 = Integer.parseInt(sc.nextLine());
					CarShop car1 = new CarShop(name1, snn1, phone1, address1, email1, brand1, model1, type1, gear1, color1, door1, cc1, fuel1, price1); 
					chc.modifier(car1);
				break;
			case 4 : 
				System.out.println("�Է��Ͻ� �ֹε�� ��ȣ�� �Է����ּ���.");
				delete = sc.nextLine();
				chc.delete(delete);
				break;
			case 5 : System.out.println("���α׷��� �����մϴ�.");
				return;
			default : System.out.println("�߸� �����ϼ̽��ϴ� �ٽ� ������ �ּ���!!"); break;
			}
		}
	}
	
	//����ȭ��
	public void displayNoDate(String mesage) {
		System.out.println("\n" + mesage);
	}
	
	public void displayCarList(ArrayList<CarShop> arr) {
		for(CarShop n : arr) {
			System.out.println(n);
		}
	}
	
	public void noDeleteCar(int result) {
		
		System.out.println(result + "���� �����Ͱ� ���� �ƽ��ϴ�.");
	}
	
	public void DeleteCar(int result) {
		
		System.out.println(result + "���� �����Ͱ� ���� �ƽ��ϴ�.");
	}
	
	public void noInsert(String mesage) {
		
		System.out.println("\n" + mesage);
	}
	
	public void insert(int result) {
		
		System.out.println(result + "���� ���� ���ԵǾ����ϴ�.");
		
	}
	
	public void noModifyer(String mesage) {
		System.out.println("\n" + mesage);
	}
	
	public void Modifyer(int result) {
		System.out.println(result + "���� ���� �����Ǿ����ϴ�.");
	}
	
	
}
