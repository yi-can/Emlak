package com.project.questapp.requests;

import lombok.Data;

@Data
public class PostCreateRequest {
	
	public Long getWorkplaceid() {
		return workplaceid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setWorkplaceid(Long workplaceid) {
		this.workplaceid = workplaceid;
	}
	Long id;
	Long workplaceid;
	String title;
	String text;
}
