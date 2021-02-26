package com.example.bagsapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bagsapi.model.Bag;
import com.example.bagsapi.services.BagService;


@RestController
@RequestMapping("/api/v1/bag")
@AllArgsConstructor
public class BagController {
	
	private final BagService bagService;
	
	@PostMapping
	public ResponseEntity<?> addBag(@RequestBody Bag bag){
		bagService.saveBag(bag);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bag> getBagById(@PathVariable Long id){
		Bag bag = bagService.findBagById(id);
		return ResponseEntity.status(HttpStatus.OK).body(bag);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBagById(@PathVariable Long id){
		bagService.deleteBag(id);
		return ResponseEntity.ok().build();
	}
	
	
	

	
}
