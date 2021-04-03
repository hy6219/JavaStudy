package com.javaStudy.car.model.dto;

public abstract class VehicleCommon implements VehicleControl{
	protected String color;
	protected String gearType;
	protected int cntDoor;
	protected double pos;
	protected final static double inc = 5;
	/*
	 * control �޼��带 ���� 2��и��� LF, 
	 * 1��и��� RF
	 * 3��и��� LB
	 * 4��и��� RB
	 */
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGearType() {
		return gearType;
	}
	public void setGearType(String gearType) {
		this.gearType = gearType;
	}
	public int getCntDoor() {
		return cntDoor;
	}
	public void setCntDoor(int cntDoor) {
		this.cntDoor = cntDoor;
	}
	public double getPos() {
		return pos;
	}
	public void setPos(double pos) {
		this.pos = pos;
	}
	public static double getInc() {
		return inc;
	}
	@Override
	public void control(double pos, int inc)
	{
		
		/*
		 * 1��и� : +0~+90
		 * 2��и� : +90~+180
		 * 3��и� : +180~+270
		 * 4��и� : +270~+360
		 * 360, 720, 1080,...
		 * 
		 * ==> 360���� �Ѵ´ٸ�, �� �и���
		 * (degree%90)==3~4 : 4��и�
		 * (degree%90)==0~1 :1��и�
		 * (degree%90)==1~2 :2��и�
		 * (degree%90)==2~3 :3��и�
		 * 
		 */
		pos+=inc;
		double degQuad = pos % 90;
		int quad 	   = (degQuad < 1)? 1: ((degQuad <2)? 2: ((degQuad < 3)?3 : 4));//��и�
		
		if(quad == 1)
		{
			//1��и�
			controlRF(pos);
		}
		else if(quad == 2)
		{
			//2��и�
			controlLF(pos);
		}
		else if(quad == 3)
		{
			//3��и�
			controlLB(pos);
		}
		else
		{
			//4��и�
			controlRB(pos);
		}
	}
	
	@Override
	public void stop()
	{
		System.out.println(this.getClass().getSimpleName()+ "Ÿ���� ��ۼ����� ����ϴ�.");
		return;
	}
	public static void controlLF(double degree)
	{
		System.out.println("�ϼ��� �������� "+degree+" ��, "+(Math.toRadians(degree))+" ����"
				+ " �����Դϴ�.");
	}

	public static void controlRF(double degree)
	{
		System.out.println("�ϵ��� �������� "+degree+" ��, "+(Math.toRadians(degree))+" ����"
				+ " �����Դϴ�.");
	}

	public static void controlLB(double degree)
	{
		System.out.println("������ �������� "+degree+" ��, "+(Math.toRadians(degree))+" ����"
				+ " �����Դϴ�.");
	}

	public static void controlRB(double degree)
	{
		System.out.println("������ �������� "+degree+" ��, "+(Math.toRadians(degree))+" ����"
				+ " �����Դϴ�.");
	}
	
}
