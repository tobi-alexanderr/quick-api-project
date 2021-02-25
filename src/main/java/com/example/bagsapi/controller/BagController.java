package com.example.bagsapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bagsapi.model.Bag;
import com.example.bagsapi.services.BagService;

//import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/bag")
//@AllArgsConstructor
public class BagController {
	
	private final BagService bagService;

	public BagController(BagService bagService) {
		super();
		this.bagService = bagService;
	}
	
	@PostMapping
	public ResponseEntity<?> addBag(@RequestBody Bag bag){
		bagService.saveBag(bag);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBagById(@RequestParam Long id){
		bagService.findBagById(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBagById(@RequestParam Long id){
		bagService.deleteBag(id);
		return ResponseEntity.ok().build();
	}
	
	
	

	
}
