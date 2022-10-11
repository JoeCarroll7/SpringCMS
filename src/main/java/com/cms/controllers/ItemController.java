package com.cms.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cms.model.Items;
import com.cms.services.ItemService;
import com.cms.services.OrderService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class ItemController {
	private final ItemService itemService;
	private final OrderService orderService;
	
	@GetMapping("/items/addItem")
	public String getAddItem(Model model) {
		model.addAttribute("item", new Items());
		return "addItem";
	}
	
	@PostMapping("/items/addItem")
	public String addItem(@ModelAttribute("item") Items item) {
		itemService.addItemToSystem(item);
		return "addItem";
	}
	
	@GetMapping("/items")
	public String listAllItems(Model model){
		model.addAttribute("items", itemService.getAllItems());
		return "listAllItems";
	}
	
	@PostMapping("/items/order/{id}")
	public void addItemToOrder(@PathVariable Integer id) {
		
	}
	
	@GetMapping("/items/{id}")
	public String deleteItem(@PathVariable Integer id) {
		itemService.deleteItem(id);
		return "redirect:/items";
	}
	
}
