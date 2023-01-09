package com.project.questapp.services;

import java.util.List;

import com.project.questapp.entities.WorkPlace;
import com.project.questapp.repos.WorkPlaceRepository;

public class WorkPlaceService {

	private WorkPlaceRepository workPlaceRepository;

	public WorkPlaceService(WorkPlaceRepository workPlaceRepository) {
		this.workPlaceRepository = workPlaceRepository;
	}

	public List<WorkPlace> getAllWorkPlaceService() {
		return workPlaceRepository.findAll();
	}

	public WorkPlace saveOneworkPlace(WorkPlace newWorkPlace) {
		return workPlaceRepository.save(newWorkPlace);
	}
	//Çok gerekli değil
	public WorkPlace getOneWorkPlace(Long workPlaceId) {
		return workPlaceRepository.findById(workPlaceId).orElse(null);
	}

	public void deleteById(Long workPlaceId) {
		workPlaceRepository.deleteById(workPlaceId);		
	}

	public WorkPlace getOneWorkPlace(String isletmeAdi) {
		return workPlaceRepository.findByWorkPlacename(isletmeAdi);
	}
	
	

}
