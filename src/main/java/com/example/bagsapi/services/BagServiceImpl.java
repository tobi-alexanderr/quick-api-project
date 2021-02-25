package com.example.bagsapi.services;


import org.springframework.stereotype.Service;

import com.example.bagsapi.exception.BagNotFoundException;
import com.example.bagsapi.model.Bag;
import com.example.bagsapi.repository.BagRepository;

@Service
public class BagServiceImpl implements BagService{

	private final BagRepository bagRepository;
	
	
	public BagServiceImpl(BagRepository bagRepository) {
		super();
		this.bagRepository = bagRepository;
	}

	@Override
	public void saveBag(Bag bag) {
		bagRepository.save(bag); 
	}

	@Override
	public Bag findBagById(Long id) {
		return bagRepository.findById(id).orElseThrow(() -> new BagNotFoundException(id.toString())); 
	}

	@Override
	public void deleteBag(Long id) {
		Bag bag = findBagById(id); 
		bag.setDeleted(true);
		saveBag(bag); 
	}
	
	
	
	
}
