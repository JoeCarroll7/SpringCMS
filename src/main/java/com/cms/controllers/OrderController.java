package com.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cms.model.Orders;
import com.cms.services.ItemService;
import com.cms.services.OrderService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class OrderController {
	private final ItemService itemService;
	private final OrderService orderService;
	
	@GetMapping("/orders/createOrder")
	public String getCreateOrder(Model model) {
		model.addAttribute("order", new Orders());
		model.addAttribute("items", itemService.getAllItems());
		return "createOrder";
	}
	
	@PostMapping("/orders/createOrder")
	public String createOrder(@ModelAttribute("order") Orders order) {
		
		return "redirect:/orders";
	}
	
	/*
	@PostMapping("/items/order/{id}")
	public void addItemToOrder(@PathVariable Integer id) {
		
	}
	*/
}
