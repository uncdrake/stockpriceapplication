package com.zensar.stockapp.service;

import java.util.List;

import com.zensar.stockapp.dto.StockDto;

public interface StockService {
	public List<StockDto> getAllStockPrice();
}
