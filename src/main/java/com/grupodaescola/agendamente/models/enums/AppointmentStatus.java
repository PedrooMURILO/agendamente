package com.grupodaescola.agendamente.models.enums;

public enum AppointmentStatus {

	SCHEDULED(1),
	COMPLETED(2),
	CANCELED(3);
	
	private int code;
	
	private AppointmentStatus(int code) {
		this.code = code;
	}
	
	private int getCode() {
		return code;
	}
	
	public static AppointmentStatus valueOf(int code) {
		for (AppointmentStatus value : AppointmentStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
