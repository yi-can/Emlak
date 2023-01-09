package com.project.questapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="customer")
@Data

public class Customer {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	Long id;
	//Long userId;
	String MusteriAd;
	String MusteriSoyad;
	String Email;
	String Telefon;
	String Fax;
	@Lob
	@Column(columnDefinition="text")//String i text olarak algılaması için.Yoksa varchar 255 olarak alıyor.
	String text;
	
}
