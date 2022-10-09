package com.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.model.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
}
