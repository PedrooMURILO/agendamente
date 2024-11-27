package com.grupodaescola.agendamente.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_psychologist")
public class Psychologist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String businessName;
	private String phone;
	private String email;
	private String password;
	private String professionalLicense;
	
	@OneToOne(mappedBy = "psychologist")
	private Availibility availibility;
	
	@OneToMany(mappedBy = "psychologist", fetch = FetchType.EAGER)
	private List<Appointment> appointments = new ArrayList<>();

	public Psychologist() {
	}

	public Psychologist(Integer id, String name, String businessName, String phone, String email, String password,
			String professionalLicense) {
		this.id = id;
		this.name = name;
		this.businessName = businessName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.professionalLicense = professionalLicense;
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

	public Availibility getAvailibility() {
		return availibility;
	}

	public void setAvailibility(Availibility availibility) {
		this.availibility = availibility;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public List<Appointment> getAppointments() {
		return appointments;
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
		Psychologist other = (Psychologist) obj;
		return Objects.equals(id, other.id);
	}
}
