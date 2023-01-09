package com.project.questapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.Customer;
import com.project.questapp.services.CustomerService;

@RestController
@RequestMapping("/Customers")
public class CustomerController {
	
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomers();
	}
	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer newCustomer) {
		return customerService.saveOneCustomer(newCustomer);
	}
	//Çok gerekli değil
	@GetMapping("/customerId")
	public Customer updateOneUser(@PathVariable Long customerId) {
		//custom exeption
		return customerService.getOneCustomer(customerId);
	}

	
	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable Long customerId) {
		customerService.deleteById(customerId);
	}

}
