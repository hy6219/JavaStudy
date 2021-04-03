package com.javaStudy.car.model.dto.air;

import com.javaStudy.car.model.dto.Vehicle;

public class Air extends Vehicle{

	public Air() {
		// TODO Auto-generated constructor stub
		setInUse(2);
	}

	public Air(String color, String gearType, int cntDoor) {
		super(color, gearType, cntDoor);
		// TODO Auto-generated constructor stub
		setInUse(2);
	}
	
}
