package com.api.project.controller;

import org.springframework.stereotype.Controller;

import com.api.project.entity.ItemState;
import com.api.project.repository.ItemRepository;
import com.api.project.repository.ItemStateRepository;

@Controller
public class ItemStateController {

	  private final ItemStateRepository itemStateRepository;

	    ItemStateController(ItemStateRepository itemStateRepository) {
	        this.itemStateRepository = itemStateRepository;
	      }

	      ItemState recordItemSate(ItemState itemState) {
	         itemStateRepository.save(itemState);
	         return itemStateRepository.save(itemState);
	      }
	
}
