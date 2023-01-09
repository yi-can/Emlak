package com.project.questapp.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="house")
@Data

public class House {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	Long id;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="work_place_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	WorkPlace workPlace;
	
	
	public String getEmlakTuru() {
		return EmlakTuru;
	}
	public void setEmlakTuru(String emlakTuru) {
		EmlakTuru = emlakTuru;
	}
	public String getDurum() {
		return Durum;
	}
	public void setDurum(String durum) {
		Durum = durum;
	}
	public Long getOdaSayisi() {
		return OdaSayisi;
	}
	public void setOdaSayisi(Long odaSayisi) {
		OdaSayisi = odaSayisi;
	}
	public Long getSalonSayisi() {
		return SalonSayisi;
	}
	public void setSalonSayisi(Long salonSayisi) {
		SalonSayisi = salonSayisi;
	}
	public Long getM2() {
		return m2;
	}
	public void setM2(Long m2) {
		this.m2 = m2;
	}
	public Long getBinaKat() {
		return BinaKat;
	}
	public void setBinaKat(Long binaKat) {
		BinaKat = binaKat;
	}
	public Long getBulunduguKat() {
		return BulunduguKat;
	}
	public void setBulunduguKat(Long bulunduguKat) {
		BulunduguKat = bulunduguKat;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getId() {
		return id;
	}
	String EmlakTuru;//ev arsa
	String Durum;//satılık-kiralık
	Long OdaSayisi;
	Long SalonSayisi;
	Long m2;
	Long BinaKat;
	Long BulunduguKat;
	@Lob
	@Column(columnDefinition="text")//String i text olarak algılaması için.Yoksa varchar 255 olarak alıyor.
	String text;
	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}
