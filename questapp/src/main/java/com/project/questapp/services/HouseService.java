package com.project.questapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.project.questapp.entities.House;
import com.project.questapp.entities.WorkPlace;
import com.project.questapp.repos.HouseRepositroy;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.responses.HouseResponse;

public class HouseService {
	
	private HouseRepositroy houseRepositroy;
	private WorkPlaceService workplaceService;

	public HouseService(HouseRepositroy houseRepositroy, WorkPlaceService workplaceService) {
		this.houseRepositroy = houseRepositroy;
		this.workplaceService = workplaceService;
	}

	public List<HouseResponse> getAllHouse(Optional<Long> work_place_id) {
		List<House> list;
		if(work_place_id.isPresent()) {
			list = houseRepositroy.findByWorkPlaceId(work_place_id);
		}
		list = houseRepositroy.findAll();
		return list.stream().map(p -> new HouseResponse(p)).collect(Collectors.toList());
	}



	public void deleteById(Long houseId) {
		houseRepositroy.deleteById(houseId);	
	}

	public House getOneHouseById(Long work_place_id) {
		return houseRepositroy.findById(work_place_id).orElse(null);
	}

	public House saveOneHouse(PostCreateRequest newPostRequest) {
		WorkPlace workPlace = workplaceService.getOneWorkPlace(newPostRequest.getWorkplaceid());
		if (workPlace == null) {
			return null;
		}
		House toHouse = new House();
		toHouse.setId(newPostRequest.getId());
		return houseRepositroy.save(toHouse);
	}

	
}
