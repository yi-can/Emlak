package com.project.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.WorkPlace;

public interface WorkPlaceRepository extends JpaRepository<WorkPlace, Long> {

	WorkPlace findByWorkPlacename(String workPlaceName);

}
