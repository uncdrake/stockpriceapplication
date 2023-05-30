package com.zensar.stockapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zensar.stockapp.dto.StockDto;
import com.zensar.stockapp.entity.StockEntity;
import com.zensar.stockapp.repository.StockRepository;

@WebMvcTest(StockServiceImplementation.class)
public class TestStockServiceImplementation {
	@MockBean
	StockRepository stockRepo;
	
	@Test
	public void TestGetAllStockPrice() {
		StockServiceImplementation stockServiceImpl = new StockServiceImplementation();
		stockServiceImpl.stockRepo = this.stockRepo;
		StockEntity stocks1 = new StockEntity(1, "Apple", 45 );
		List<StockEntity> listOfStockEntity = new ArrayList<>();
		listOfStockEntity.add(stocks1);
		when(stockRepo.findAll()).thenReturn(listOfStockEntity);
		StockDto dto1 = new StockDto(1,"Apple", 45);
		List<StockDto> dtoList = new ArrayList<>();
		dtoList.add(dto1);
		
		List<StockDto> allStockPrice = stockServiceImpl.getAllStockPrice();
		assertEquals(allStockPrice.get(0).getName(), "Apple");
		
		
	}
}
