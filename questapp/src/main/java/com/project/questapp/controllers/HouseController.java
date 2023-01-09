package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.House;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.responses.HouseResponse;
import com.project.questapp.services.HouseService;

@RestController
@RequestMapping("/houses")
public class HouseController {
	
	private HouseService houseService;

	public HouseController(HouseService houseService) {
		this.houseService = houseService;
	}
	
	@GetMapping
	public List<HouseResponse> getAllHouse(@RequestParam Optional<Long> work_place_id){
		return houseService.getAllHouse(work_place_id);
	}
	
	@GetMapping("/{workplaceid}")
	public House getOneHouse(@PathVariable Long work_place_id) {
		return houseService.getOneHouseById(work_place_id);
	}
	
	@PostMapping
	public House createHouse (@RequestBody PostCreateRequest newPostRequest) {
		return houseService.saveOneHouse(newPostRequest);
	}
	
	@DeleteMapping("/{customerId}")
	public void deleteHouse(@PathVariable Long houseId) {
		houseService.deleteById(houseId);
	}
}
