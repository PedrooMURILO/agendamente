package com.grupodaescola.agendamente.dtos;

import org.springframework.beans.BeanUtils;

import com.grupodaescola.agendamente.models.Psychologist;

public class PsychologistDTO {

	private Integer id;
	private String name;
	private String phone;
	private String email;
	private String password;
	private String professionalLicense;
	
	private AvailibilityDTO availibility;

	public PsychologistDTO() {
	}
	
	public PsychologistDTO(Psychologist entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getAvailibility() != null) {
            this.availibility = new AvailibilityDTO(entity.getAvailibility());
        }
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfessionalLicense() {
		return professionalLicense;
	}

	public void setProfessionalLicense(String professionalLicense) {
		this.professionalLicense = professionalLicense;
	}

	public AvailibilityDTO getAvailibility() {
		return availibility;
	}

	public void setAvailibility(AvailibilityDTO availibility) {
		this.availibility = availibility;
	}
}
