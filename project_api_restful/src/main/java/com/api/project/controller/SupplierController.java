package com.api.project.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.entity.Supplier;
import com.api.project.repository.SupplierRepository;

@RestController
public class SupplierController {
	 private final SupplierRepository supplierRepository;

	 SupplierController(SupplierRepository supplierRepository) {
	        this.supplierRepository = supplierRepository;
	      }
	 @PostMapping("/supplier")
	 void recordItemSate(@RequestBody Supplier supplier) {
		 supplierRepository.save(supplier);
	         
	      }
	 
    @DeleteMapping("/supplier/{id}")
    void deleteItem(@PathVariable int id) {
    	supplierRepository.deleteById(id);
    }
	
    @PutMapping("/supplier/{id}")
    void updatePriceReduction(@RequestBody Supplier supplier, @PathVariable int id) {
    	Supplier supplierUpdated = supplierRepository.getOne(id);
    	supplierUpdated.setCountry(supplier.getCountry());
    	supplierUpdated.setName(supplier.getName());
    	supplierUpdated.setItems(supplier.getItems());
   
    	supplierRepository.save(supplierUpdated);
   }
    
	
}
