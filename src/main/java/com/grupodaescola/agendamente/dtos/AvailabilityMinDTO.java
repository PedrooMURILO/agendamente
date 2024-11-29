package com.grupodaescola.agendamente.dtos;

import com.grupodaescola.agendamente.models.Availability;

public class AvailabilityMinDTO {

	private Integer id;

	public AvailabilityMinDTO() {
	}

	public AvailabilityMinDTO(Availability entity) {
		this.id = entity.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
