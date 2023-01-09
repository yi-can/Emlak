package com.project.questapp.services;

import java.util.List;

import com.project.questapp.entities.Customer;
import com.project.questapp.repos.CustomerRepository;

public class CustomerService {

	private CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer saveOneCustomer(Customer newCustomer) {
		return customerRepository.save(newCustomer);
	}

	public Customer getOneCustomer(Long customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	public void deleteById(Long customerId) {
		customerRepository.deleteById(customerId);
	}

}
