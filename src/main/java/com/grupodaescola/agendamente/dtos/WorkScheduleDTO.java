package com.grupodaescola.agendamente.dtos;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.springframework.beans.BeanUtils;

import com.grupodaescola.agendamente.models.WorkSchedule;

public class WorkScheduleDTO {

	private Integer id;
	private DayOfWeek dayOfWeek;
	private LocalTime morningStartTime ;
	private LocalTime morningEndTime;
	private LocalTime afternoonStartTime ;
	private LocalTime afternoonEndTime;
	
	public WorkScheduleDTO() {
	}

	public WorkScheduleDTO(WorkSchedule entity) {
		BeanUtils.copyProperties(entity, this);
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
}
