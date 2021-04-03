package com.javaStudy.car.model.dto;

public abstract class VehicleCommon implements VehicleControl{
	protected String color;
	protected String gearType;
	protected int cntDoor;
	protected double pos;
	protected final static double inc = 5;
	/*
	 * control 메서드를 만들어서 2사분면은 LF, 
	 * 1사분면은 RF
	 * 3사분면은 LB
	 * 4사분면은 RB
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
		 * 1사분면 : +0~+90
		 * 2사분면 : +90~+180
		 * 3사분면 : +180~+270
		 * 4사분면 : +270~+360
		 * 360, 720, 1080,...
		 * 
		 * ==> 360도를 넘는다면, 각 분면은
		 * (degree%90)==3~4 : 4사분면
		 * (degree%90)==0~1 :1사분면
		 * (degree%90)==1~2 :2사분면
		 * (degree%90)==2~3 :3사분면
		 * 
		 */
		pos+=inc;
		double degQuad = pos % 90;
		int quad 	   = (degQuad < 1)? 1: ((degQuad <2)? 2: ((degQuad < 3)?3 : 4));//사분면
		
		if(quad == 1)
		{
			//1사분면
			controlRF(pos);
		}
		else if(quad == 2)
		{
			//2사분면
			controlLF(pos);
		}
		else if(quad == 3)
		{
			//3사분면
			controlLB(pos);
		}
		else
		{
			//4사분면
			controlRB(pos);
		}
	}
	
	@Override
	public void stop()
	{
		System.out.println(this.getClass().getSimpleName()+ "타입의 운송수단을 멈춥니다.");
		return;
	}
	public static void controlLF(double degree)
	{
		System.out.println("북서쪽 방향으로 "+degree+" 도, "+(Math.toRadians(degree))+" 라디안"
				+ " 움직입니다.");
	}

	public static void controlRF(double degree)
	{
		System.out.println("북동쪽 방향으로 "+degree+" 도, "+(Math.toRadians(degree))+" 라디안"
				+ " 움직입니다.");
	}

	public static void controlLB(double degree)
	{
		System.out.println("남서쪽 방향으로 "+degree+" 도, "+(Math.toRadians(degree))+" 라디안"
				+ " 움직입니다.");
	}

	public static void controlRB(double degree)
	{
		System.out.println("남동쪽 방향으로 "+degree+" 도, "+(Math.toRadians(degree))+" 라디안"
				+ " 움직입니다.");
	}
	
}
