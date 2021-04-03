package com.javaStudy.car.model.dto;

import java.util.Comparator;

import com.javaStudy.car.model.dto.ground.Ground;
import com.javaStudy.car.model.dto.marine.Marine;

public class Vehicle extends VehicleCommon implements Comparator{
	protected int inUse;
	/*
	 * 0:ground 1: marine 2: air
	 */

	public Vehicle() {
		// TODO Auto-generated constructor stub
		this("black", "2", 0);
	}

	public Vehicle(String color, String gearType, int cntDoor) {
		this.color = color;
		this.gearType = gearType;
		this.cntDoor = cntDoor;
	}

	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color=color;
	}
	
	public String getGearType()
	{
		return gearType;
	}
	public void setGearType(String gearType)
	{
		this.gearType = gearType;
	}
	
	public int getCntDoor()
	{
		return cntDoor;
	}
	
	public void setCntDoor(int cntDoor)
	{
		this.cntDoor = cntDoor;
	}
	
	public int getInUse() {
		return inUse;
	}

	public void setInUse(int inUse) {
		this.inUse = inUse;
		inUse = (
				(this.getClass().getSimpleName()).equals(Ground.class.getClass().getSimpleName())?
						0:
							((this.getClass().getSimpleName()).equals(Marine.class.getClass().getSimpleName())?1:2));
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(
				"[ "+this.getClass().getSimpleName()+" [gearType: "+this.gearType+","+
						" color: "+this.color+", number of door: "+cntDoor+","+
						" where in use: "+((this.inUse == 0)? "On ground": ((this.inUse == 1)? 
								"for Marine": "for Air"))+"]]");
		return sb.toString();
	}
	
	@Override
	public int hashCode()
	{
		int r = 1;
		int prime = 31;
		
		r += (r * prime) + ((this.color == null)?0:this.color.hashCode());
		r += (r * prime) + ((this.gearType == null)?0:this.gearType.hashCode());
		r += (r * prime) + this.cntDoor;
		r += (r * prime) + this.inUse;
		return r;
		
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == this)
		{
			return true;
		}
		if(obj == null)
		{
			return false;
		}
		
		/*
		 * 
		 */
		if(obj instanceof Vehicle)
		{
			Vehicle v = (Vehicle)obj;
			if(v.cntDoor == this.cntDoor &&
			  (v.color).equals(this.color) &&
			  (v.gearType).equals(this.gearType)&&
			  v.inUse == this.inUse
					)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
		
		/*
		 * color 값으로 정렬
		 */
		if(o1 instanceof Vehicle && 
			o2 instanceof Vehicle)
		{
			Vehicle v1 = (Vehicle)o1;
			Vehicle v2 = (Vehicle)o2;
			return (v1.color).compareTo(v2.color);
		}
		return -1;
	}
	
}
