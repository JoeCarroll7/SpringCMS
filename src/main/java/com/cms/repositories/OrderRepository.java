package com.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
