package com.grupodaescola.agendamente.dtos;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.beans.BeanUtils;

import com.grupodaescola.agendamente.models.Availibility;

public class AvailibilityDTO {

	private Integer id;
	private LocalTime startTime;
	private LocalTime endTime;
	private Duration duration;

	public AvailibilityDTO() {
	}

	public AvailibilityDTO(Availibility entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}
}
