package com.example.bagsapi.services;

import com.example.bagsapi.model.Bag;

public interface BagService {
	
	void saveBag(Bag bag);

	Bag findBagById(Long id);

	void deleteBag(Long id); 
	
}
