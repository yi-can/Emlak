package com.project.questapp.services;

import java.util.List;
import java.util.Optional;

import com.project.questapp.entities.Customer;
import com.project.questapp.entities.CustomerHouse;
import com.project.questapp.entities.House;
import com.project.questapp.repos.CustomerHouseRepository;
import com.project.questapp.requests.CustomerHouseCreateRequest;

public class CustomerHouseService {

	private CustomerHouseRepository customerHouseRepository;
	private CustomerService customerService;
	private HouseService houseService;
	
	public CustomerHouseService(CustomerHouseRepository customerHouseRepository, CustomerService customerService,
			HouseService houseService) {
		this.customerHouseRepository = customerHouseRepository;
		this.customerService = customerService;
		this.houseService = houseService;
	}

	public CustomerHouseService(CustomerHouseRepository customerHouseRepository) {
		this.customerHouseRepository = customerHouseRepository;
	}

	public List<CustomerHouse> getAllCustomerHouse(Optional<Long> house_id, Optional<Long> customer_id) {
		
		if (house_id.isPresent() && customer_id.isPresent()) {
			return customerHouseRepository.findByHouseAndCustomerId(house_id.get(), customer_id.get());
		}else if (house_id.isPresent()) {
			return customerHouseRepository.findByHouseId(house_id.get());
		} else if (customer_id.isPresent()){
			return customerHouseRepository.findByCustomerId(customer_id.get());
		}else
			return customerHouseRepository.findAll();
	}

	public CustomerHouse createOneCustomerHouse(CustomerHouseCreateRequest request) {
		Customer customer = customerService.getOneCustomer(request.getCustomerId());
		House house = houseService.getOneHouseById(request.getHouseId());
		if (customer != null && house != null) {
			CustomerHouseCreateRequest customerHouseToSave = new CustomerHouseCreateRequest();
			customerHouseToSave.setId(request.getId());
			customerHouseToSave.setText(request.getText());
			return customerHouseRepository.saveAll(customerHouseToSave);
		}else
			return null;
	}

}
