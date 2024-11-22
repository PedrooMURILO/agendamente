package com.grupodaescola.agendamente.dtos;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.grupodaescola.agendamente.models.Note;

public class NoteDTO {

	private Integer id;
	private String content;
	private LocalDateTime timestamp;
	
	public NoteDTO() {
	}
	
	public NoteDTO(Note entity) {
		BeanUtils.copyProperties(entity, this);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
}
