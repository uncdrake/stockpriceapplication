package com.zensar.stockapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.stockapp.dto.StockDto;
import com.zensar.stockapp.entity.StockEntity;
import com.zensar.stockapp.repository.StockRepository;

@Service
public class StockServiceImplementation implements StockService {
	
	@Autowired
	public StockRepository stockRepo;

	@Override
	public List<StockDto> getAllStockPrice() {
		List<StockEntity> findAllStock = stockRepo.findAll();
		

		List<StockDto> resultList = new ArrayList<>();
		
		for (StockEntity result : findAllStock) {
			StockDto dto = new StockDto();
			dto.setId(result.getId());
			dto.setName(result.getName());
			dto.setPrice(result.getPrice());
			
			resultList.add(dto);
		}
		return resultList;
	}

}
