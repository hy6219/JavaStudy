package com.javaStudy.car.model.dto.ground;

import com.javaStudy.car.model.dto.Vehicle;

public class Ground extends Vehicle{

	public Ground() {
		// TODO Auto-generated constructor stub
		setInUse(0);
	}

	public Ground(String color, String gearType, int cntDoor) {
		super(color, gearType, cntDoor);
		// TODO Auto-generated constructor stub
		setInUse(0);
	}
	
}
