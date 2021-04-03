package com.javaStudy.car.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

import com.javaStudy.car.model.dto.Vehicle;
import com.javaStudy.car.model.dto.air.Airplane;
import com.javaStudy.car.model.dto.ground.Car;
import com.javaStudy.car.model.dto.marine.ATV;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Car("blue", "4", 4));
		vehicles.add(new ATV("gray", "12", 6));
		vehicles.add(new Car("white", "4", 2));
		vehicles.add(new Car("red", "4", 2));
		vehicles.add(new Airplane("white", "2", 1));
		vehicles.add(new ATV("black", "12", 4));
		vehicles.add(new Airplane("whiteBlue", "2", 1));
		vehicles.add(new ATV("gray", "12", 2));
	
		
		System.out.println("Before sorting vehicles by \'color\': ");
		/*
		 * 보기좋게 편집
		 */
		ListIterator iter = vehicles.listIterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		Collections.sort(vehicles, new Vehicle());
		System.out.println();
		System.out.println();
		System.out.println("After sorting vehicles by \'color\': ");
		iter = vehicles.listIterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}

}
