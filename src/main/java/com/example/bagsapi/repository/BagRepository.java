package com.example.bagsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bagsapi.model.Bag;

@Repository
public interface BagRepository extends JpaRepository<Bag, Long>{

}
