package com.javaStudy.car.model.dto.marine;

import com.javaStudy.car.model.dto.Vehicle;
import com.javaStudy.car.model.dto.ground.Ground;

public class Marine extends Vehicle{

	
	public Marine() {

		// TODO Auto-generated constructor stub
		setInUse(1);
	}

	public Marine(String color, String gearType, int cntDoor) {
		super(color, gearType, cntDoor);
		// TODO Auto-generated constructor stub
		setInUse(1);
	}

}
