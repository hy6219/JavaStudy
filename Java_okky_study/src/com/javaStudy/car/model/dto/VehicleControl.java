package com.javaStudy.car.model.dto;

public interface VehicleControl {
	/*
	 * ������� �̷����� � ���� �����ϴ� ����� �ٸ� �� �־
	 * �������̽��� ����
	 */
	public void control(double pos, int inc);
	public void stop();
}
