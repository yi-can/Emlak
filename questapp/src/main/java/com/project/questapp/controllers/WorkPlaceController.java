package com.project.questapp.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.WorkPlace;

import com.project.questapp.services.WorkPlaceService;

@RestController
@RequestMapping("/WorkPlaces")

public class WorkPlaceController {
	
	private WorkPlaceService workPlaceService;

	public WorkPlaceController(WorkPlaceService workPlaceService) {
		this.workPlaceService = workPlaceService;
	}
	
	@GetMapping
	public List<WorkPlace> getAllUsers(){
		return workPlaceService.getAllWorkPlaceService();
	}
	
	@PostMapping
	public WorkPlace createworkPlace(@RequestBody WorkPlace newWorkPlace) {
		return workPlaceService.saveOneworkPlace(newWorkPlace);
	}
	//Çok gerekli değil
	@GetMapping("/workPlaceId")
	public WorkPlace updateOneUser(@PathVariable Long workPlaceId) {
		//custom exeption
		return workPlaceService.getOneWorkPlace(workPlaceId);
	}

	
	@DeleteMapping("/{workPlaceId}")
	public void deleteWorkPlace(@PathVariable Long workPlaceId) {
		workPlaceService.deleteById(workPlaceId);
	}
	
}





















