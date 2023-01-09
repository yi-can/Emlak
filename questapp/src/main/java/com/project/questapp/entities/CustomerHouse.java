package com.project.questapp.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="customerHouse")
@Data

public class CustomerHouse {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	Long id;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="house_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	House house;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Customer customer;
}
