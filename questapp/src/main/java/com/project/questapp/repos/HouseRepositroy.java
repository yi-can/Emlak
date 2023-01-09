package com.project.questapp.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.House;

public interface HouseRepositroy extends JpaRepository<House, Long> {

	List<House> findByWorkPlaceId(Optional<Long> work_place_id);

}
