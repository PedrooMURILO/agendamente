package com.grupodaescola.agendamente.dtos;

import com.grupodaescola.agendamente.models.Psychologist;

public class PsychologistMinDTO {

	private Integer id;
	private String name;

	public PsychologistMinDTO() {
	}

	public PsychologistMinDTO(Psychologist entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
