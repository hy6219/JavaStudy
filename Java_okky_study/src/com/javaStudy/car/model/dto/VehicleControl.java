package com.javaStudy.car.model.dto;

public interface VehicleControl {
	/*
	 * 사륜인지 이륜인지 등에 따라 제어하는 방식이 다를 수 있어서
	 * 인터페이스로 묶음
	 */
	public void control(double pos, int inc);
	public void stop();
}
