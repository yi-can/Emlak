package com.project.questapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.CustomerHouse;
import com.project.questapp.requests.CustomerHouseCreateRequest;

public interface CustomerHouseRepository extends JpaRepository<CustomerHouse, Long> {

	List<CustomerHouse> findByHouseAndCustomerId(Long house_id, Long customer_id);

	List<CustomerHouse> findByHouseId(Long house_id);

	List<CustomerHouse> findByCustomerId(Long customer_id);

	CustomerHouse saveAll(CustomerHouseCreateRequest customerHouseToSave);


}
