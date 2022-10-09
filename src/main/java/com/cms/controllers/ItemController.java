package com.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cms.model.Items;
import com.cms.services.ItemService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller("/items")
public class ItemController {
	private final ItemService itemService;
	
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
}
