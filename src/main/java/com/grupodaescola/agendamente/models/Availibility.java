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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_availibility")
public class Availibility {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Duration duration;
	
	@OneToMany(mappedBy = "availibility", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<WorkSchedule> schedules = new ArrayList<>();

	public Availibility() {
	}

	public Availibility(Integer id, Duration duration) {
		this.id = id;
		this.duration = duration;
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

	public List<WorkSchedule> getSchedules() {
		return schedules;
	}
	
	public void addSchedule(WorkSchedule schedule) {
		schedules.add(schedule);
		schedule.setAvailibility(this);
	}
	
	public void removeSchedule(WorkSchedule schedule) {
        schedules.remove(schedule);
        schedule.setAvailibility(null);
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
		Availibility other = (Availibility) obj;
		return Objects.equals(id, other.id);
	}
}
