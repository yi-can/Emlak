package com.project.questapp.responses;

import com.project.questapp.entities.House;

import lombok.Data;

@Data
public class HouseResponse {
	Long id;
	Long worplaceId;
	String EmlakTuru;
	String Durum;
	Long OdaSayisi;
	Long SalonSayisi;
	Long m2;
	Long BinaKat;
	Long BulunduguKat;
	
	public HouseResponse(House entity) {
		this.id = entity.getId();
		this.EmlakTuru = entity.getEmlakTuru();
		this.Durum = entity.getDurum();
		this.OdaSayisi = entity.getOdaSayisi();
		this.SalonSayisi = entity.getSalonSayisi();
		this.m2 = entity.getM2();
		this.BinaKat = entity.getBinaKat();
		this.BulunduguKat = entity.getBulunduguKat();
	}
}
