package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.project.questapp.entities.CustomerHouse;
import com.project.questapp.requests.CustomerHouseCreateRequest;
import com.project.questapp.services.CustomerHouseService;

@RestController
@RequestMapping("/customerHouse")
public class CustomerHouseController {

	private CustomerHouseService customerHouseService;

	public CustomerHouseController(CustomerHouseService customerHouseService) {
		this.customerHouseService = customerHouseService;
	}
	
	@GetMapping
	public List<CustomerHouse> getAllHouse(@RequestParam Optional<Long> house_id, @RequestParam Optional<Long> customer_id){
		return customerHouseService.getAllCustomerHouse(house_id, customer_id);
	}
	
	@PostMapping
	public CustomerHouse createCustomerHouse(@RequestBody CustomerHouseCreateRequest request) {
		return customerHouseService.createOneCustomerHouse(request);
	}
	
}
