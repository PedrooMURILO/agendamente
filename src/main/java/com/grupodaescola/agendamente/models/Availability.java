package com.grupodaescola.agendamente.models;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_availability")
public class Availability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Duration duration;
	
	@OneToMany(mappedBy = "availability", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<WorkSchedule> schedules = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "psychologist_id")
	private Psychologist psychologist;
	
	public Availability() {
	}

	public Availability(Integer id, Duration duration, Psychologist psychologist) {
		this.id = id;
		this.duration = duration;
		this.psychologist = psychologist;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public Psychologist getPsychologist() {
		return psychologist;
	}

	public void setPsychologist(Psychologist psychologist) {
		this.psychologist = psychologist;
	}

	public List<WorkSchedule> getSchedules() {
		return schedules;
	}
	
	public void addSchedule(WorkSchedule schedule) {
		schedules.add(schedule);
		schedule.setAvailability(this);
	}
	
	public void removeSchedule(WorkSchedule schedule) {
        schedules.remove(schedule);
        schedule.setAvailability(null);
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
		Availability other = (Availability) obj;
		return Objects.equals(id, other.id);
	}
}
