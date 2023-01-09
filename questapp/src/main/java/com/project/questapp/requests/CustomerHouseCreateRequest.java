package com.project.questapp.requests;



import lombok.Data;

@Data
public class CustomerHouseCreateRequest {
	Long id;
	Long houseId;
	Long customerId;
	String text;
	public Long getHouseId() {
		return houseId;
	}
	public void setHouseId(Long house) {
		this.houseId = house;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customer) {
		this.customerId = customer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
