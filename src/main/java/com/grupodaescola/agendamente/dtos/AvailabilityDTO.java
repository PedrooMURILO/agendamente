package com.grupodaescola.agendamente.dtos;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.grupodaescola.agendamente.models.Availability;
import com.grupodaescola.agendamente.models.WorkSchedule;

public class AvailabilityDTO {

	private Integer id;
	private Duration duration;

	private List<WorkScheduleDTO> schedules = new ArrayList<>();
	
	private PsychologistMinDTO psychologist;

	public AvailabilityDTO() {
	}

	public AvailabilityDTO(Availability entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getSchedules() != null) {
			for (WorkSchedule schedule : entity.getSchedules()) {
				this.schedules.add(new WorkScheduleDTO(schedule));
			}
		}
		if (entity.getPsychologist() != null) {
			this.psychologist = new PsychologistMinDTO(entity.getPsychologist());
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

	public PsychologistMinDTO getPsychologist() {
		return psychologist;
	}

	public void setPsychologist(PsychologistMinDTO psychologist) {
		this.psychologist = psychologist;
	}
}
