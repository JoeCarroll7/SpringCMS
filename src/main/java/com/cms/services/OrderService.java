package com.cms.services;

import org.springframework.stereotype.Service;

import com.cms.model.Orders;
import com.cms.repositories.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderService {
	private final OrderRepository orderRepository;
	
	public void createNewOrder(Orders order) {
		Orders orderFinal = new Orders();
		
	}
	
	public void addItemToOrder(Integer id) {
		
	}
	

}
