package com.grupodaescola.agendamente.models;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_work_schedule")
public class WorkSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private DayOfWeek dayOfWeek;
	private LocalTime morningStartTime ;
	private LocalTime morningEndTime;
	private LocalTime afternoonStartTime ;
	private LocalTime afternoonEndTime;
	
	public WorkSchedule () {
	}

	public WorkSchedule(Integer id, DayOfWeek dayOfWeek, LocalTime morningStartTime, LocalTime morningEndTime,
			LocalTime afternoonStartTime, LocalTime afternoonEndTime) {
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.morningStartTime = morningStartTime;
		this.morningEndTime = morningEndTime;
		this.afternoonStartTime = afternoonStartTime;
		this.afternoonEndTime = afternoonEndTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getMorningStartTime() {
		return morningStartTime;
	}

	public void setMorningStartTime(LocalTime morningStartTime) {
		this.morningStartTime = morningStartTime;
	}

	public LocalTime getMorningEndTime() {
		return morningEndTime;
	}

	public void setMorningEndTime(LocalTime morningEndTime) {
		this.morningEndTime = morningEndTime;
	}

	public LocalTime getAfternoonStartTime() {
		return afternoonStartTime;
	}

	public void setAfternoonStartTime(LocalTime afternoonStartTime) {
		this.afternoonStartTime = afternoonStartTime;
	}

	public LocalTime getAfternoonEndTime() {
		return afternoonEndTime;
	}

	public void setAfternoonEndTime(LocalTime afternoonEndTime) {
		this.afternoonEndTime = afternoonEndTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkSchedule other = (WorkSchedule) obj;
		return Objects.equals(id, other.id);
	}
}
