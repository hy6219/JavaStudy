package controller;

import java.util.ArrayList;

import Model.service.CarShopService;
import Model.vo.CarShop;
import view.CarShopMenual;

public class CarShopController {
	
	public void selectList() {
		
		ArrayList<CarShop> arr = new CarShopService().selectList();
		
		if(arr.isEmpty()) {
			new CarShopMenual().displayNoDate("��ȸ�� ����� �����ϴ�.");
		}else {
			new CarShopMenual().displayCarList(arr);
		}
		
	}
	
	public int delete(String SSN){
		
		int result = new CarShopService().delete(SSN);
		System.out.println("CarShopController : " + SSN);
		if(result == 0) {
			new CarShopMenual().noDeleteCar(result);
		}else {
			new CarShopMenual().DeleteCar(result);
		}
		return result;
		
	}
	
	public int insert(CarShop car) {
		int result = new CarShopService().insert(car);
		
		if(result == 0) {
			new CarShopMenual().noInsert("�����Ͱ� ���̵��� �ʾҽ��ϴ�");
		}else {
			new CarShopMenual().insert(result);
		}
		
		return result;
	}
	
	public int modifier(CarShop car) {
		
		int result = new CarShopService().modifyer(car);
		
		if(result == 0) {
			new CarShopMenual().noModifyer("�����Ͱ� �����̵��� �ʾҽ��ϴ�");
		}else {
			new CarShopMenual().Modifyer(result);
		}
		
		return result;
		
	}
	
}
