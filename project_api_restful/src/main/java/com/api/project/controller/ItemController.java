package com.api.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.entity.Item;
import com.api.project.entity.ItemState;
import com.api.project.repository.ItemRepository;
import com.api.project.repository.ItemStateRepository;
import com.api.project.repository.PriceReductionRepository;
import com.api.project.repository.SupplierRepository;


@RestController
public class ItemController {
	
	private final ItemRepository itemRepository;
	private final ItemStateRepository itemStateRepository;
	private final PriceReductionRepository priceReductionRepository;
	
	ItemController(ItemRepository itemRepository,
			ItemStateRepository itemStateRepository,
			SupplierRepository supplierRepository, PriceReductionRepository priceReductionRepository) {
	    this.itemRepository = itemRepository;
	    this.itemStateRepository = itemStateRepository;
	    this.priceReductionRepository = priceReductionRepository;
	  }

     @PostMapping("/item")
      Item recordItem(@RequestBody Item item) {
    	 itemStateRepository.save(item.getState());
		 Item itemRecorded = itemRepository.save(item);
		 return itemRecorded;
      }
     
     // Only for Admin
     //TODO
     @DeleteMapping("/item/{id}")
     void deleteItem(@PathVariable int id) {
       itemRepository.deleteById(id);
     }
     
     @PutMapping("/item/{id}")
     void updateItem(@RequestBody Item item, @PathVariable int id) {
        Item itemToUpdate = itemRepository.getOne(id);
        ItemState itemStateToUpdate = itemStateRepository.getOne(itemToUpdate.getState().getId());
        priceReductionRepository.getOne(id);
        
        
        itemStateToUpdate.setIsActive(item.getState().getIsActive());
        itemStateToUpdate.setChangedBy(item.getState().getChangedBy());
        itemStateToUpdate.setReason(item.getState().getReason());   
        itemToUpdate.setDescription(item.getDescription());
        itemToUpdate.setPrice(item.getPrice());
        itemToUpdate.setState(itemStateToUpdate);
        itemToUpdate.setSuppliers(item.getSuppliers());
        
        // these should be not modified
        //itemToUpdate.setCreationDate(item.getCreationDate()); 
        //itemToUpdate.setCreatedBy(item.getCreatorUser()); 
        itemRepository.save(itemToUpdate);
    }
     
     @GetMapping("/item/{id}")
     Item getItem(@PathVariable int id) {
       Item item = itemRepository.findById(id).get();
       try {
		item.getState().getChangedBy().setPassword("");
		   item.getCreatorUser().setPassword("");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
	}
       return item;
     }
     
     @GetMapping("/items")
     List <Item> getAllItem() {
    	 List<Item> items = itemRepository.findAll();
    	 for (Item item : items) {
    		 item.getState().getChangedBy().setPassword("");
    	     item.getCreatorUser().setPassword("");   		 
    	 }
       return items;
     }
}
