package com.grupodaescola.agendamente.dtos;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.grupodaescola.agendamente.models.Availibility;
import com.grupodaescola.agendamente.models.WorkSchedule;

public class AvailibilityDTO {

	private Integer id;
	private Duration duration;

	private List<WorkScheduleDTO> schedules = new ArrayList<>();

	public AvailibilityDTO() {
	}

	public AvailibilityDTO(Availibility entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getSchedules() != null) {
			for (WorkSchedule schedule : entity.getSchedules()) {
				this.schedules.add(new WorkScheduleDTO(schedule));
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<WorkScheduleDTO> getSchedules() {
		return schedules;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}
}
