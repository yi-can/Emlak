package com.project.questapp.requests;

import lombok.Data;

@Data
public class WorkPlaceRequest {
	
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
	String IsletmeAdi;
	String Yetkili;
}
