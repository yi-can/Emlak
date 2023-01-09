package com.project.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
