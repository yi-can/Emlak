package com.project.questapp.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="workplace")
@Data

public class WorkPlace {//User

	@Id
	//@GeneratedValue( strategy = GenerationType.IDENTITY)
	Long id;
	//Long userId;
	String IsletmeAdi;
	String Yetkili;
	String Adres;
	String Telefon;
	String Fax;
	@Lob
	//@Column(columnDefinition="text")//String i text olarak algılaması için.Yoksa varchar 255 olarak alıyor.
	String text;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsletmeAdi() {
		return IsletmeAdi;
	}
	public void setIsletmeAdi(String isletmeAdi) {
		IsletmeAdi = isletmeAdi;
	}
	public String getYetkili() {
		return Yetkili;
	}
	public void setYetkili(String yetkili) {
		Yetkili = yetkili;
	}
	public String getAdres() {
		return Adres;
	}
	public void setAdres(String adres) {
		Adres = adres;
	}
	public String getTelefon() {
		return Telefon;
	}
	public void setTelefon(String telefon) {
		Telefon = telefon;
	}
	public String getFax() {
		return Fax;
	}
	public void setFax(String fax) {
		Fax = fax;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
