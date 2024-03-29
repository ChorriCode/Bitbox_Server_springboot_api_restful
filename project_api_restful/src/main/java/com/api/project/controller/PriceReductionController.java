package com.api.project.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.entity.PriceReduction;
import com.api.project.repository.PriceReductionRepository;

@RestController
public class PriceReductionController {
	 private final PriceReductionRepository priceReductionRepository;

	 PriceReductionController(PriceReductionRepository priceReductionRepository) {
	        this.priceReductionRepository = priceReductionRepository;
	      }
	 @PostMapping("item/price_reduction")
	 void recordItemSate(@RequestBody PriceReduction priceReduction) {
		 priceReductionRepository.save(priceReduction);
	         
	      }
	 
     @DeleteMapping("/item/price_reduction/{id}")
     void deleteItem(@PathVariable int id) {
    	 priceReductionRepository.deleteById(id);
     }
	
     @PutMapping("/item/price_reduction/{id}")
     void updatePriceReduction(@RequestBody PriceReduction priceReduction, @PathVariable int id) {
    	 PriceReduction priceReductionUpdated = priceReductionRepository.getOne(id);
    	 priceReductionUpdated.setItemPriceReduction(priceReduction.getItemPriceReduction());
    	 priceReductionUpdated.setStartDate(priceReduction.getStartDate());
    	 priceReductionUpdated.setEndDate(priceReduction.getEndDate());

    	 priceReductionRepository.save(priceReductionUpdated);
    }
     
     
}
