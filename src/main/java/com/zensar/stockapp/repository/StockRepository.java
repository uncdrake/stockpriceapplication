package com.zensar.stockapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.stockapp.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer> {
	
	public StockEntity findByName(String name);

}
