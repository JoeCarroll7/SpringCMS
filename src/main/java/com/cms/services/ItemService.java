package com.cms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cms.model.Items;
import com.cms.repositories.ItemRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ItemService {
	private final ItemRepository itemRepository;
	
	public void addItemToSystem(Items item) {
		itemRepository.save(item);
	}
	
	public Items getItemById(Integer id) {
		return itemRepository.getReferenceById(id);
	}
	
	public List<Items> getAllItems(){
		return itemRepository.findAll();
	}
}
